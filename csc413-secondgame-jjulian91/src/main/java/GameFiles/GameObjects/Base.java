package GameFiles.GameObjects;

import java.awt.image.BufferedImage;

public class Base extends GameObject {
    int speed;
    public Base(BufferedImage img, int x, int y){
        super(img, x, y);
        speed = (int)(Math.random() * ( 5 - 1 )+1);
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

    public int getSpeed(){
        return this.speed;
    }
}
