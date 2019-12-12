package gamefiles.GameObjects;

import gamefiles.TankWars;

import java.awt.image.BufferedImage;

/**
 * @author  Jonathan Julian
 * Destructable wall class. used as a mapObject.
 */

public class DestructibleWall extends GameObject implements Wall {

    public DestructibleWall(BufferedImage img, int x, int y) {
        super(img, x, y);
        updateBorder();

    }

    /**
     * handles collisions between 2 objects.
     * @param go
     */
    @Override
    public void collide(GameObject go) {
        TankWars.explosions.add(new Explosion(x, y, TankWars.bigExp));
        this.setShow(false);
    }

    /**
     * used in the abtract class unused here.
     * @return
     */
    @Override
    public int getDamage() {
        return 0;
    }


    /**
     * destroys wall. can be used to upgrade wall health.
     * @param d
     */
    @Override
    public void reduceHealth(int d) {

    }
}
