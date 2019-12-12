package gamefiles.GameObjects;

import java.awt.image.BufferedImage;

/**
 * @author
 * @author  Jonathan Julian
 * moved from Plane game
 */
public class Health extends GameObject{
    /**
     * sets health bar object
     * @param img
     *          healthbar used
     * @param x
     *          location bar is drawn x coord
     * @param y
     *          location bar is drawn y coord
     */
    public Health(BufferedImage img, int x, int y) {
        super(img, x, y);

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
     */
    @Override
    public int getDamage() {
        return 0;
    }

    /**
     * required for abstraction
     * @param d
     */
    @Override
    public void reduceHealth(int d) {

    }
}
