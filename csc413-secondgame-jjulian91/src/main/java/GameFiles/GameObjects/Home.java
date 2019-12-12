package GameFiles.GameObjects;

import java.awt.image.BufferedImage;

public class Home extends GameObject {

    public Home(BufferedImage img, int x, int y){
        super(img, x, y);
    }
    @Override
    public void collide(GameObject go) {

    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public void reduceHealth(int d) {

    }
}
