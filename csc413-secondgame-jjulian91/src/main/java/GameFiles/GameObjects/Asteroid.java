package GameFiles.GameObjects;

import java.awt.image.BufferedImage;

public class Asteroid extends GameObject {

    public Asteroid(BufferedImage img, int x, int y, int speed, int angle){
        super(img, x, y, speed, angle);
    }

    public void update(){
        moveForwards();
    }
    @Override
    public void collide(GameObject go) {}

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public void reduceHealth(int d) {
    }


}
