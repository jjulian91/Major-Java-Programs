package gamefiles.GameObjects;

import java.awt.image.BufferedImage;

/**
 * @author Jonathan Julian
 * creates powerup for life boost
 */
public class LivesBoost extends GameObject {
    /**
     * default constructor
     * @param img
     *          image for powerup
     * @param x
     *          location of x coord
     * @param y
     *          location of y coord
     */
    public LivesBoost(BufferedImage img, int x, int y) {
        super(img, x, y);
    }

    /**
     * propagated from Abstract class
     * @param go
     */
    @Override
    public void collide(GameObject go) {

    }

    /**
     * propagated from Abstract class
     *
     */
    @Override
    public int getDamage() {
        return 0;
    }

    /**
     * propagated from Abstract class
     *
     */
    @Override
    public void reduceHealth(int d) {

    }
}
