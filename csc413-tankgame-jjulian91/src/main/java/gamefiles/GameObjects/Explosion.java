/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gamefiles.GameObjects;

/**
 * @author
 * @author Jonathan julian
 *
 * Taken from planes game -- used to animate explosions.
 */

import java.awt.*;

public class Explosion extends GameObject {
    private Image [] img;
    private int count;
    private boolean finished;

    /**
     * instantiates explosion of any type.
     */
    public Explosion(int x, int y, Image[] img){
        super(x, y, img);
        this.count = 0;
        this. finished = false;
        this.img = img;
    }

    /**
     * from abstract class
     * @param go
     */
    @Override
    public void collide(GameObject go) {

    }

    /**
     * from abstract class
     * @return
     */
    @Override
    public int getDamage() {
        return 0;
    }

    /**
     * from abstract class
     * @param d
     */
    @Override
    public void reduceHealth(int d) {

    }

    /**
     * checks if explosion has iterated through all items in array
     * @return
     */
    public boolean getFinished(){
        return this.finished;
    }

    /**
     * updates counter to move to next photo in explosion.
     */
    public void update(){
        if(count < img.length-1){
            count ++;
        }
        else{
            finished = true;
        }
    }

    /**
     * draws images to world.
     */
    public void draw(Graphics2D g) {
         if (!finished && count-1 > 0) {
             g.drawImage(img[count-1], x, y, null);
         }
     }


}
