package gamefiles.GameObjects;


import java.awt.image.BufferedImage;

/**
 * @author Jonathan Julian
 * Creates lifes for tanks
 */
public class Life extends GameObject {
    /**
     * default constructor
     * @param img
     *          life dot Image
     * @param x
     *          location of X coord
     * @param y
     *          location of y coord
     *
     */
    public Life(BufferedImage img, int x, int y) {
        super(img, x, y);
    }

    /**
     * propagated from Abstract class
     * @param d
     */
    @Override
    public void reduceHealth(int d) {

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

}
