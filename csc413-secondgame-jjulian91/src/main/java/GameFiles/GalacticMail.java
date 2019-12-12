package GameFiles; /**
 *
 * @author Anthony Souza
 * @author Jonathan Julian
 *
 * Drive file for the program
 */

import GameFiles.GameObjects.*;
import GameFiles.HashMaps.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;



public class GalacticMail extends JPanel {
    private Thread thread;


    private static boolean initialized = false;
    private static boolean lastMoon = false;
    private BufferedImage world;
    private BufferedImage background;
    private static Graphics2D buffer;
    private static boolean baseCollide;
    private JFrame jf;
    private static Ship p1;
    private static int level = 0;
    private static boolean Playing = true;
    //private static ArrayList<GameObject> art = new ArrayList<>();
    private static ArrayList<GameObject> mapItem = new ArrayList<>();
    private static ArrayList<Asteroid> asteroids = new ArrayList<>();
    boolean scoresPrinted;
        //entry for game

    public static void main(String[] args) {
        Thread x;
        GalacticMail game = new GalacticMail();
        game.init();

        //game control loop
        try {
            while (Playing) {
                //art = new ArrayList<>(); //clears drawable ArrayList
                p1.update();
                //art.add(p1);
                checkCollisions();
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

            scoresPrinted = false;

            //creates Jframe
            this.jf = new JFrame("Galactic Mail     Player Score : 0      Level "+level);
            //creates world buffered image for the map
            this.world = new BufferedImage(ConfigFile.get("MAP_WIDTH"), ConfigFile.get("MAP_HEIGHT"),
                    BufferedImage.TYPE_INT_RGB);

            //scales jf to fit on screen
            this.jf.setSize(ConfigFile.get("SCREEN_WIDTH"), ConfigFile.get("SCREEN_HEIGHT"));
            this.jf.setResizable(false);
            jf.setLocationRelativeTo(null);

            //loads the background for use later
            background = ImageTable.get("Background");


            //NEW Ship CREATED
            p1 = new Ship(ImageTable.get("ShipLanded"),1, 1,KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT,
                    KeyEvent.VK_ENTER, 0,0, (int)(Math.random()*100));
            //SETS Ship CONTROLS
            Control tc1 = new Control(p1, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE);

            //adds keylistener to the Frame
            this.jf.addKeyListener(tc1);
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
        /*public static void addDrawable(GameObject image){
            art.add(image);
        }*/

        /**
         * removes the drawable item from drawable ArrayList
         * @param image
         *          item to be removed
         */
        /*public static void removeDrawable(GameObject image){art.remove(image);}*/

        /**
         * call from repaint to draw game
         * creates buffer, calls drawmap (to render map)
         * calls drawgame to draw gameobjects.
         * @param g
         *      item to be drawn on.
         */
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D)g;
            super.paintComponent(g2);
            buffer = world.createGraphics();
            //buffer.clearRect(0, 0, ConfigFile.get("SCREEN_WIDTH"), ConfigFile.get("SCREEN_HEIGHT"));
            buffer.drawImage(background,0,0,null);
            if(mapItem.isEmpty()){
                asteroids = new ArrayList<>();
                level++;
                MapCreator.create(level);
            }
            drawGame(buffer);
            g2.drawImage(world,0,0, null);
            g2.dispose();
        }

        /**
         * adds object to map ArrayList.
         * @param map
         *          item to be added
         */
        static void addMapObject(GameObject map){
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
         * @param bufferImg
         *          Image to draw to.
         */
        private void drawGame(Graphics2D bufferImg){
            if(p1.isLanded() && mapItem.size()==1){
                jf.setTitle("Press Blast off for the next Level!");
            }
            else if(p1.getScore() > 0)
                jf.setTitle("Galactic Mail     Player Score : "+p1.getScore()+"      Level "+level);
            else{jf.setTitle("Galactic Mail     Player Score : 0      Level "+level);}
            Font stringFont = new Font( "SansSerif", Font.PLAIN, 18 );
            bufferImg.setFont(stringFont);
            bufferImg.setColor(Color.white);
            //checks if game is over
            if(p1.getBoom()){
                endGame(bufferImg);
                }
            else{
                //draws current items in list of MapObjects
                //removes mapobjects based on their current showstatus.
                for(int i = 0; i < mapItem.size(); i++){
                    if(mapItem.get(i).getShow()) {
                        mapItem.get(i).draw(bufferImg);
                    }
                    else{mapItem.remove(i);}
                }
                p1.draw(buffer);
                try{
                    for (Asteroid ast:asteroids) {
                        ast.update();
                        ast.draw(buffer);
                    }
                }
                catch(ConcurrentModificationException | IndexOutOfBoundsException | NullPointerException e){
                    e.printStackTrace();}
            }
        }

        /**
         * checks for collisions.
         * iterates through art moveables and checks if two moveable items intersect. omits map items from this check
         * checks for moveable items to collide with walls, shrinks the test cases.
         */
        private static void checkCollisions(){
            for (int k = 0; k < mapItem.size(); k++) { // checks immovable objects
                GameObject baseObj = mapItem.get(k);
                baseCollide = baseObj.getCollideable();
                if ((baseCollide && baseObj.getBorder().contains(p1.getMiniBoundary())))
                    p1.collide(baseObj);
            }
            if(!p1.isLanded() )
             for (Asteroid ast:asteroids) {
                if(ast.getBorder().intersects(p1.getBorder()))
                    p1.isDied();
            }
        }

        static boolean getInit(){return initialized;}

        static int getLevel(){return level;}

        static void addAsteroid(Asteroid ast){
            asteroids.add(ast);
        }

        static int getFirstX(){
            return p1.getX();
        }

        static int getFirstY(){
            return  p1.getY();
        }

        public void setTitle(String val){
            jf.setTitle(val);
        }
        private void endGame(Graphics2D buffer){
            Font stringFont = new Font( "SansSerif", Font.PLAIN, 20);
            buffer.setFont(stringFont);
            if(!scoresPrinted)
                ScoreTable.displayScore(buffer,ConfigFile.get("SCREEN_WIDTH")-400,
                        ConfigFile.get("SCREEN_HEIGHT")/3, p1.getScore());
            scoresPrinted = true;
            setPlaying(false);
        }
    public static void setPlaying(boolean playing) {
        Playing = playing;
    }
    }


