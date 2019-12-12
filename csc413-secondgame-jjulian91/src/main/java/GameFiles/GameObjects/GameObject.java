/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameFiles.GameObjects;

/**
 *
 */


import GameFiles.GalacticMail;
import GameFiles.HashMaps.ConfigFile;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author  Jonathan Julian
 * GameObject Superclass
 * used to make objects to be drawn/used in game.
 */

public abstract class GameObject implements Drawable {
     int x, y, width, height, speed;

     boolean collideable = true;

     private Image [] imgArray;

     boolean show;

     int radius;

     public BufferedImage img;

     int angle;

    private int screenHeight = ConfigFile.get("SCREEN_HEIGHT");
    private int screenWidth = ConfigFile.get("SCREEN_WIDTH");



     Rectangle2D boundary;

    /**
     * basic needs of game object for drawing.
     */
    public GameObject(int x, int y, String img){
         this.x = x;
         this.y = y;

        try{
            this.img = ImageIO.read(GameObject.class.getResource("/Resources/"+img));
            this.width = this.img.getWidth();
            this.height = this.img.getHeight();
        }
         catch (IOException e){
             System.out.println("img not found" +e);
         }
        this.boundary = new Rectangle2D.Double(this.x, this.y, width, height);
        speed = 0;
        radius = height/2;
    }

    /**
     * basic needs of wall for drawing.
     */
    public GameObject(BufferedImage img, int x, int y){
        this.img = img;
        this.width = this.img.getWidth();
        this.height = this.img.getHeight();
        this.x = x;
        this.y = y;
        boundary = new Rectangle2D.Double(this.x+20, this.y+20, width-40, height-40);
        this.show = true;

    }

    /**
     * Ship/Bullet.
     * @param img
     *          image of object
     * @param x
     *          x coordinate of object
     * @param y
     *          y coordinate of objcet
     * @param speed
     *           speed of obj
     * @param angle
     *          current relative angle
     */
    public GameObject(BufferedImage img, int x, int y, int speed, int angle){
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = this.img.getWidth();
        this.height = this.img.getHeight();
        this.speed = speed;
        this.angle = angle;
        this.boundary = new Rectangle2D.Double(this.x, this.y, width, height);
        this.show = true;
    }

    /**
     * used to create explosions
     * @param x
     *          x coordinate of explosion
     * @param y
     *          y coordinate of explosion
     * @param img
     *          array of images used in the explosion
     */
    public GameObject(int x, int y, Image[] img) {
        this.x = x;
        this.y = y;
        this.imgArray = img;
        this.width = img[0].getWidth(null);
        this.height = img[0].getHeight(null);
        this.boundary = new Rectangle2D.Double(this.x, this.y, width, height);
        this.show = true;
    }

    /**
     * Abstract method to be used in other classes could be defined here and overridden there.
     * @param go
     */
    public abstract void collide(GameObject go);

    /**
     * Abstract method to be used in other classes could be defined here and overridden there.
     */
    public abstract int getDamage();

    /**
     * Abstract method to be used in other classes could be defined here and overridden there.
     */
    public abstract void reduceHealth(int d);

    /**
     * used for indestructible walls/items -- can be used as powerup.
     * @param newVal
     */
    protected void setCollideable(boolean newVal){
        collideable = newVal;
    }

    /**
     *
     * @return
     *          objects x coordinate
     */
    public int getX(){
        return this.x;
    }

    /**
     *
     * @return
     *          objects y coordinate
     */
    public int getY(){
        return this.y;
    }

    /**
     * @return
     *          objects img width
     */
    protected int getWidth(){
        return this.width;
    }

    /**
     * @return
     *          objects img height
     */
    protected int getHeight(){
        return this.height;
    }

    /**
     * updates current X position
     * @param a
     */
    public void setX(int a){
        this.x = a;
    }

    /**
     * updates current y
     */
    public void setY(int b){
        this.y = b;
    }

    /**
     * updates show boolean
     * @param show
     */
    public void setShow(boolean show){
        this.show = show;
    }

    /**
     * creates Vx (used for object rotation
     * @return
     */
    public int getVx(){
        return (int) Math.round(speed * Math.cos(Math.toRadians(angle)));
    }

    /**
     * creates Vy (used for object rotation
     * @return
     */
    public int getVy(){
        return (int) Math.round(speed * Math.sin(Math.toRadians(angle)));
    }

    /**
     * updates object to move in desired direction
     */
    protected void moveForwards() {
        x += getVx();
        y += getVy();
        checkBorder();
        updateBorder();
    }

    public boolean getCollideable(){
        return this.collideable;
    }

    /**
     * checks for object going off map screen, unused as long as map is outlined in indestructible walls.
     */
    private void checkBorder() {
        if (x < 0) {
            this.x += screenWidth;
        }
        else if(x > screenWidth) {
            this.x -= screenWidth;
        }
        if (y < 0) {
            this.y += screenHeight;
        }
        else if (y > screenHeight) {
            this.y -= screenHeight;
        }
    }

    /**
     * default draw method for objects to world
     * @param g
     */
    public void draw(Graphics g){
        if(show){
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(img, x,y, null);
            //g2.draw(boundary);
        }
    }

    /**
     * updates border used in collisions
     */
    protected void updateBorder(){
        boundary.setFrame(x, y, img.getWidth(), img.getHeight());
    }

    /**
     * returns current boundary of the hit border
     * @return
     */
    public Rectangle2D getBorder(){
        updateBorder();
        return boundary;
    }

    /**
     * updates drawable arraylist
     */
    /*protected void update(){
        GalacticMail.addDrawable(this);
    }*/

    /**
     *
     * @return
     *          if object is shown or not.
     */
    public boolean getShow(){return show;}

}
