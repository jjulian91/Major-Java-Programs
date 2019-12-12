package gamefiles.GameObjects;

import java.awt.image.BufferedImage;

/**
 * @author Joanthan Julian
 * used to create indestructible walls.
 */
public class IndestructibleWall extends GameObject implements Wall {
    /**
     * constructor for indestructible wall
     * @param img
     *          img to be used
     * @param x
     *          location of image X coord
     * @param y
     *          location of image Y coord.
     */
    public IndestructibleWall(BufferedImage img, int x, int y) {
        super(img, x, y);
        setDestructable(false);
        update();
    }

    /**
     * required for abstraction
     * @param go
     */
    @Override
    public void collide(GameObject go) {

    }

    /**
     * required for abstraction
     *
     */
    @Override
    public int getDamage() {
        return 0;
    }


    /**
     * required for abstraction
     *
     */
    @Override
    public void reduceHealth(int d) {

    }
}