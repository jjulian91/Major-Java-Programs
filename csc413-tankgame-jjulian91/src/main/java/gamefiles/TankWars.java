package gamefiles;
import gamefiles.GameObjects.*;
import gamefiles.HashMaps.ConfigFile;
import gamefiles.HashMaps.ImageTable;
import gamefiles.HashMaps.MapObjects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 *
 * @author Anthony Souza
 * @author Jonathan Julian
 *
 * Drive file for the program
 */

public class TankWars extends JPanel {
    private Thread thread;


    private final double MINI_SCALE = .1;
    private final double MINI_SCALE_Y = .143;
    private boolean initialized = false;
    private BufferedImage world, Left, Right, mini;
    private BufferedImage background;
    private Image power,myTank;
    private static Graphics2D g2, buffer;
    private JFrame jf;
    private static Tank p1, p2;
    private static boolean Playing = true;
    public static ArrayList<Explosion> explosions = new ArrayList<Explosion>(10000);
    //static ArrayList<PowerUp> powerUp = new ArrayList<PowerUp>();
    public static Image [] smallExp = new Image[6];
    public static Image [] bigExp = new Image[7];
    private static ArrayList<GameObject> art = new ArrayList<>();
    private static ArrayList<GameObject> mapItem = new ArrayList<>();


    //entry for game
    public static void main(String[] args) {
        Thread x;
        TankWars game = new TankWars();
        game.init();

        //game control loop
        try {
            while (Playing) {
                checkCollisions();
                art = new ArrayList<>(); //clears drawable ArrayList
                p1.update();
                p2.update();
                game.repaint();
                Thread.sleep(1000 / 144);
            }
        } catch (InterruptedException ignored) {}
    }

    /**
     * initializes game
     */
    private void init() {
        ConfigFile.init(); //loads configuration hashmap
        ImageTable.init(); //loads images to hashmap
        MapObjects.init(); //loads mapobjects.

        //creates Jframe
        this.jf = new JFrame("Tanks");
        //creates world buffered image for the map
        this.world = new BufferedImage(ConfigFile.get("MAP_WIDTH"), ConfigFile.get("MAP_HEIGHT"), BufferedImage.TYPE_INT_RGB);

        //scales jf to fit on screen
        this.jf.setSize(ConfigFile.get("SCREEN_WIDTH"), ConfigFile.get("SCREEN_HEIGHT"));
        this.jf.setResizable(false);
        jf.setLocationRelativeTo(null);

        //loads the background for use later
        background = ImageTable.get("Background");

        //loads small explosion image array for looping
        for(int i = 0; i < smallExp.length; i++){
           smallExp[i] = ImageTable.get("SmallExp");
        }
        //loads large explosion image array for looping
        for(int i = 0; i < bigExp.length; i++){
            bigExp[i] = ImageTable.get("LargeExp");
        }
        //drawBackGroundWithTileImage();
        myTank = ImageTable.get("Tank");
        //power = ImageIO.read(TankWars.class.getResource("/Shield1.gif"));

        //NEW TANKS CREATED
        p2 = new Tank(ImageTable.get("Tank"), 3, 75, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER, ConfigFile.get("MAP_WIDTH")/4,
                ConfigFile.get("MAP_HEIGHT")/4, 90);

        p1 = new Tank(ImageTable.get("Tank"),3, 75,KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A,
                KeyEvent.VK_D, KeyEvent.VK_SPACE, ConfigFile.get("MAP_WIDTH")/4*3,
                ConfigFile.get("MAP_HEIGHT")/4*3, 180);
        //SETS TANK CONTROLS
        TankControl tc2 = new TankControl(p2,KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,
                KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER);
        TankControl tc1 = new TankControl(p1,KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D,
                KeyEvent.VK_SPACE);

        //add tanks to gameobjects.
        art.add(p1);
        art.add(p2);

        //adds keylistener to the Frame
        this.jf.addKeyListener(tc1);
        this.jf.addKeyListener(tc2);

        this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jf.setVisible(true);
        this.jf.setLayout(new BorderLayout());
        this.jf.add(this);
    }

    /**
     * adds item to Art ArrayList
     * @param image
     *          image to be rendered
     */

    public static void addDrawable(GameObject image){
        art.add(image);
    }

    /**
     * removes the drawable item from drawable ArrayList
     * @param image
     *          item to be removed
     */

    public static void removeDrawable(GameObject image){art.remove(image);}


    /**
     * call from repaint to draw game
     * creates buffer, calls drawmap (to render map)
     * calls drawgame to draw gameobjects.
     * @param g
     *      item to be drawn on.
     */
    public void paintComponent(Graphics g){
        g2 = (Graphics2D) g;
        super.paintComponent(g2);
        buffer = (Graphics2D) g;
        if(world == null)
            world =  (BufferedImage) createImage(ConfigFile.get("MAP_WIDTH"), ConfigFile.get("MAP_HEIGHT"));
        g2 = world.createGraphics();
        drawMap();
        drawGame(g2);
    }


    /**
     * adds object to map ArrayList.
     * @param map
     *          item to be added
     */
    public static void addMapObject(GameObject map){
        mapItem.add(map);
    }


    /**
     * getter for mapitems  unused in this implementation
     * @return item from mapObjects arraylist
     */
    public static ArrayList<GameObject> getMapItems(){return mapItem;}

    /**
     * draws game based on current state of game
     * checks for player to be dead or alive, if player died the loser is placed on the screen.
     * growth for adding score if needed.
     * @param g2
     */
    private void drawGame(Graphics2D g2){
        Font stringFont = new Font( "SansSerif", Font.PLAIN, 18 );

        //checks if game is over
        if(p1.getBoom() || p2.getBoom()){
            stringFont = new Font( "SansSerif", Font.PLAIN, 25 );
            String winner;
            buffer.setFont( stringFont );
            if(p1.getBoom()){
                winner = "Player 2";
                buffer.drawString("GAME OVER! YOU LOSE "+winner, ConfigFile.get("SCREEN_WIDTH")/4*3-(500),
                        ConfigFile.get("SCREEN_HEIGHT")/2);
            }
            else{
                winner = "Player 1";
                buffer.drawString("GAME OVER! YOU LOSE "+winner, ConfigFile.get("SCREEN_WIDTH")/4-(500),
                        ConfigFile.get("SCREEN_HEIGHT")/2);
            }

        }
        else{
            //draws tank to minimap
            p1.draw(g2);
            p2.draw(g2);

            //updates bullets to get their current locations .
            updateBullets(p1);
            updateBullets(p2);

            //draws current items in list of MapObjects
            //removes mapobjects based on their current showstatus.
            for(int i = 0; i < mapItem.size(); i++){
                if(mapItem.get(i).getShow())
                    mapItem.get(i).draw(g2);
                else{mapItem.remove(i);}
            }
            try{
                //draws bullets or removes based on current show status
                for(int i = 0; i < art.size(); i++) {
                    if(!( art.get(i)instanceof Tank)){
                        if(art.get(i).getShow())
                            art.get(i).draw(g2);
                        else{
                            art.remove(i);
                        }
                    }
                }
                //draws explosions, or removes them
                for(int i = 0; i< explosions.size(); i++){
                    explosions.get(i).draw(g2);
                    if(explosions.get(i).getFinished()) {
                        explosions.remove(i);
                        i --;
                    }
                    else{
                        explosions.get(i).update();
                    }
                }
            }
            catch(ConcurrentModificationException | IndexOutOfBoundsException | NullPointerException e){}


            //call to draw the split screen
            drawSplitScreen(world);
        }
    }

    /**
     * draws map background or intialized mapObjects list if first run.
     */
    private void drawMap() {
        int TileWidth = background.getWidth(this);
        int TileHeight = background.getHeight(this);
        int NumberX = (ConfigFile.get("MAP_WIDTH") / TileWidth);
        int NumberY = (ConfigFile.get("MAP_HEIGHT") / TileHeight);
        for (int i = -1; i <= NumberY; i++) {
            for (int j = 0; j <= NumberX; j++) {
                g2.drawImage(background, j * TileWidth,
                        i * TileHeight, TileWidth,
                        TileHeight, this);
            }
        }
        if (!initialized){
            try {
                MapGen.init(g2);
            } catch (IOException e) {
            }
            initialized = true;
        }
    }

    /**
     * unused in implementation
     * @return returns current art Arraylist
     */
    public static ArrayList<GameObject> getArt(){
        return art;
    }

    /**
     * draws the splitscrenn to buffer
     * @param world
     *          The item to be referenced in subimages.
     */
    private void drawSplitScreen(BufferedImage world){
        //score board if needed
        String content = "PLAYER1 : "+p1.getScore();
        String content1 = "PLAYER2 : "+p2.getScore();
        Font stringFont = new Font( "SansSerif", Font.PLAIN, 18 );
        Image worldMini = world.getScaledInstance((int)(ConfigFile.get("MAP_WIDTH")*MINI_SCALE),
                (int) (ConfigFile.get("MAP_HEIGHT")*MINI_SCALE_Y),0);
        //creates split screen from subimage of param
        Left = world.getSubimage(p1.screenX(),p1.screenY(),ConfigFile.get("SCREEN_WIDTH")/2,
                ConfigFile.get("SCREEN_HEIGHT"));
        Right = world.getSubimage(p2.screenX(),p2.screenY(),ConfigFile.get("SCREEN_WIDTH")/2,
                ConfigFile.get("SCREEN_HEIGHT"));


        buffer.setFont( stringFont );
        buffer.setColor(Color.white);

        //prints score to splitscreen
        buffer.drawString(content,20,20);
        buffer.drawString(content1,ConfigFile.get("SCREEN_WIDTH")/2+20, 20);

        //draws screen to jpanel
        buffer.drawImage(Left,0,0,null);
        buffer.drawImage(Right,ConfigFile.get("SCREEN_WIDTH")/2,0, null);

        //draws minimap to jpanel
        buffer.drawImage(worldMini, ConfigFile.get("SCREEN_WIDTH")/12*5, ConfigFile.get("SCREEN_HEIGHT")/14*9,
                null);
    }


    /**
     * checks for collisions.
     * iterates through art moveables and checks if two moveable items intersect. omits map items from this check
     * checks for moveable items to collide with walls, shrinks the test cases.
     */
    private static void checkCollisions(){
        for(int i = 0; i < art.size(); i++){
            GameObject obj = art.get(i);
            for(int j = 0; j < art.size(); j++){
                if(i != j){
                    GameObject otherObject = art.get(j);
                    if(obj.getBorder().intersects(otherObject.getBorder())){
                        obj.collide(otherObject);
                        otherObject.collide(obj);
                    }
                }
            }
            for(int k = 0; k < mapItem.size(); k++){ // checks immovable objects
                GameObject WallObject = mapItem.get(k);
                if(obj.getBorder().intersects(WallObject.getBorder()))
                    obj.collide(WallObject);
            }
        }
    }

    /**
     * updates the bullets for the referenced tank
     * @param p
     *      tank referenced for updating bulletlist
     */
    private void updateBullets(Tank p){

        try {
            for (Bullet shotsFired : p.getBulletList()) {
                if(shotsFired.getShow()) {
                    shotsFired.update();
                    addDrawable(shotsFired);
                }
                else{p.getBulletList().remove(shotsFired);}
            }
        } catch (ConcurrentModificationException e) { }
    }

}
