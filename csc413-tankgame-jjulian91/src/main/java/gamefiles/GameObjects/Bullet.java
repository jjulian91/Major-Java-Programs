/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefiles.GameObjects;

/**
 *
 */


import gamefiles.HashMaps.ConfigFile;
import gamefiles.TankWars;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * @author Jonathan Julian
 *
 * Bullet Game object.
 */

public class Bullet extends GameObject{

    private int damage;

    int centerX, centerY;

    /**
     * constructor instantiates bullet from Tanks current position
     *
     * @param img
     *          img of bullet
     * @param x
     *          current X location
     * @param y
     *          current Y location
     * @param damage
     *          current damage produced by bullet  -- can be used for powerups
     * @param angle
     *          tanks current relative angle
     * @param speed
     *          speed of bullet -- can be used for powerups
     * @param R
     *          radius from center of tank to edge
     * @param tankX
     *          gets center of current tank position -- possible to be removed
     * @param tankY
     *          gets center of current tank position -- possible ot be removed
     */
    public Bullet(BufferedImage img, int x, int y, int damage, int angle, int speed, int R, int tankX, int tankY){
        super(img,x,y,speed,angle,R);
        this.damage = damage;
        this.show = true;
        //finds the center of the tank
        centerX = tankX/2;
        centerY = tankY/2;
        //updates to find center of tank  *Help from Brian Li*
        this.x += (int) Math.round(R * Math.cos(Math.toRadians(angle)))+centerX+img.getWidth()/2;
        this.y += (int) Math.round(R * Math.sin(Math.toRadians(angle)))+centerY+img.getHeight()/2;
        setX(this.x);
        setY(this.y);
        updateBorder();
    }

    /**
     * handles collision
     * @param go
     *          object collided with
     */
    @Override
    public void collide(GameObject go) {
        if(go instanceof Wall){
            //checks for a destructible wall
            if(go.destructable){
                TankWars.explosions.add(new Explosion(getX(), getY(), TankWars.bigExp));
                go.setShow(false);
                this.setShow(false);
            }
            else{
                TankWars.explosions.add(new Explosion(getX(), getY(), TankWars.smallExp));
                this.setShow(false);
            }
        }
        //checks for tank to see if damage needs to be done.
        else if(go instanceof Tank){
            Tank tank = (Tank) go;
            if(!tank.getBulletList().contains(this)){
                tank.reduceHealth(this.getDamage());
                if(tank.getBoom()){
                    TankWars.explosions.add(new Explosion(getX(), getY(), TankWars.bigExp));
                }
                else {TankWars.explosions.add(new Explosion(getX(), getY(), TankWars.smallExp));}
                setShow(false);
            }
        }

    }

    /**
     * returns bullets damage value
     * @return
     *          bullets damage value
     */
    public int getDamage(){
        return this.damage;
    }

    /**
     * updates bullet to be shown or not -- used in collisions
     * @param s
     *          new value for show.
     */
    public void setShow(boolean s){
        this.show = s;
    }

    /**
     * updates the current locatoin of bullet.
     */
    public void update(){
        moveForwards();
        TankWars.removeDrawable(this);
        TankWars.addDrawable(this);
    }

    /**
     * unused in this implementation as long as there is map border of indestructible walls.
     * @return
     *          value of if exceeds map border
     */
    @Override
    protected boolean checkBorder() {
        if (x < 0) {
            setShow(false);
            return false;
        }
        else if (x >= ConfigFile.get("MAP_WIDTH")) {

            setShow(false);
            return false;
        }
        else if (y < 0) {
            setShow(false);
            return false;
        }
        else if (y >= ConfigFile.get("MAP_HEIGHT")) {
            setShow(false);
            return false;
        }
        else{return true;}
    }

    /**
     * updates if bullet needs to be reduced in damage -- can be used as a power up.
     * @param d
     */
    @Override
    public void reduceHealth(int d) {

    }

    /**
     * updates the bullets location
     */
    @Override
    protected void moveForwards(){
        x += speed*getVx();
        y += speed*getVy();
        getBorder();
        //checkBorder();
    }

    /**
     * draws bullet to world.
     * @param g
     *          world to draw bullet to.
     */
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //rotates the bullet in the direction it needs to be.
        AffineTransform rotation = AffineTransform.getTranslateInstance(x,y);
        rotation.rotate(angle, img.getWidth()/2.0, img.getHeight()/2.0);
        g2.drawImage(img, rotation, null);
     }
}
