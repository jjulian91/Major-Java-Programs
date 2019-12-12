package GameFiles.GameObjects;

import GameFiles.GalacticMail;
import GameFiles.HashMaps.ImageTable;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;



/**
 *
 * @author anthony-pc
 * @author Jonathan Julian
 *      updated code to fit int program
 */
public class Ship extends GameObject {
    private GameObject baseRemoved;

    private int rotationSpeed;
    private Rectangle2D miniBoundary;
    private int score = 0;
    //alive?
    private boolean boom;

    //supplementary images
    private boolean landed = true;


    //Stats
    private int health;
    private int lifeCount;

    //fireing


    //Controls
    private int left, right, blastOff;

    private boolean RightPressed;
    private boolean LeftPressed;

    //collision
    private Rectangle2D imgRect;


    public Ship(BufferedImage img, int life, int damage, int left, int right, int blastOff, int x, int y,
                int angle) {
        super(img, x, y, 1, angle);
        this.lifeCount = life;
        this.health = damage;
        this.left = left;
        this.angle = angle;
        this.right = right;
        this.blastOff = blastOff;
        this.rotationSpeed = 4;
        this.boom = false;
        imgRect = new Rectangle2D.Double(x, y, getWidth(), getHeight());
        miniBoundary = new Rectangle2D.Double(x+20, y+20, width/3, height/3);

    }

    public void toggleRightPressed() {
        this.RightPressed = true;
    }

    public void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    public void toggleblastOffPressed() {
        while(landed) {
            landed = false;
        }
            blastOff();

    }


    public void unToggleRightPressed() {
        this.RightPressed = false;
    }

    public void unToggleLeftPressed() {
        this.LeftPressed = false;
    }


    /**
     * updates object to move in desired direction
     */
    private void rotateLeft() {
        this.angle -= this.rotationSpeed;
        this.angle %= 360;
    }

    /**
     * updates object to move in desired direction
     */
    private void rotateRight() {
        this.angle += this.rotationSpeed;
        this.angle %= 360;
    }

    public void update() {
        if(img.equals(ImageTable.get("ShipLaunched")))
            landed = false;
        if(!landed){
            rotationSpeed = 2;
            moveForwards();
        }
        else{rotationSpeed = 4;}
        if(landed && !(baseRemoved instanceof Home) && score > 0){
            if(GalacticMail.getMapItems().size() != 1) {//doesn't deduct points for waiting on last moon.
                score -= 1;
            }
        }
        if (this.LeftPressed) {
            this.rotateLeft();
        }
        if (this.RightPressed) {
            this.rotateRight();
        }
    }

    public int getX(){return this.x;}

    public int getY(){return this.y; }

    public int getWidth(){return this.width;}

    public int getHeight(){return this.height;}

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y + ", angle=" + angle;
    }

    @Override
    public void reduceHealth(int d) {
        if(health < d)
            isDied();
        else{health -= d;}
    }

    @Override
    protected void updateBorder(){
        boundary.setFrame(x, y, img.getWidth(), img.getHeight());
        miniBoundary.setFrame(x+20, y+20, width/3, height/3);
    }

    public boolean getBoom() {
        return this.boom;
    }

    /**
     * This starts the PlaneGame methods
     *
     */
    public void isDied() {
        boom = true;
        GalacticMail.setPlaying(false);
    }

    @Override
    public void collide(GameObject go) {
        if(go instanceof Home){
            this.x = go.x+8;
            this.y = go.y+8;
            baseRemoved = go;
            landed = true;
        }
        else if(go instanceof Base){
            this.img = ImageTable.get("ShipLanded");
            this.x = go.x+8;
            this.y = go.y+8;
            baseRemoved = go;
            super.speed = ((Base)baseRemoved).getSpeed();
            go.setCollideable(false);
            landed = true;
            score += 500;
        }
        else{

            this.setShow(false);
            isDied();
        }


    }

    @Override
    public int getDamage() {
        return 0;
    }

    private void blastOff() {
        if(GalacticMail.getMapItems().size()>1)
            this.img = ImageTable.get("ShipLaunched");
        if(!landed && baseRemoved != null) {
            baseRemoved.setShow(false);
        }
    }

    public void draw(Graphics g) {
        if (!boom) {
            imgRect = getBorder();
            AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
            rotation.rotate(Math.toRadians(angle), this.img.getWidth() / 2.0,
                    this.img.getHeight() / 2.0);
            Graphics2D g2d = (Graphics2D) g;
            //invisible tank....
            g2d.drawImage(this.img, rotation, null);
            //g2d.draw(miniBoundary);
        }


    }

    public Rectangle2D getMiniBoundary(){return this.miniBoundary; }

    public int getScore(){return this.score;}

    public boolean isLanded(){return landed;}
}