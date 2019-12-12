package gamefiles.GameObjects;


import gamefiles.HashMaps.ConfigFile;
import gamefiles.HashMaps.ImageTable;
import gamefiles.TankWars;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 *
 * @author anthony-pc
 * @author Jonathan Julian
 *      updated code to fit int program
 */
public class Tank extends GameObject {

    private final int R = 2;

    private int score;

    //alive?
    private boolean boom;
    private int fireable;
    //supplementary images
    private BufferedImage bulletImg;
    private BufferedImage lifeImg;
    private BufferedImage[] healthBars;
    private GameObject healthbar;



    //Stats
    private int health, damage, bulletDamage;
    private int lifeCount;

    //fireing
    private int bulletSpeed;
    private ArrayList<Bullet> myBulletList;

    //Controls
    private int up, down, left, right, fire;
    private boolean UpPressed;
    private boolean DownPressed;
    private boolean RightPressed;
    private boolean LeftPressed;
    private boolean FirePressed;

    //collision
    private Rectangle2D imgRect;


    public Tank(BufferedImage img, int life, int damage, int up, int down, int left, int right, int fire,int x, int y,
                int angle) {
        super(img, x, y, 8, angle, 4);
        this.lifeCount = life;
        this.damage = damage;
        this.bulletDamage = 4;
        this.health = 200;
        this.up = up;
        this.down = down;
        this.left = left;
        this.angle = angle;
        this.right = right;
        this.fire = fire;
        this.boom = false;
        this.myBulletList = new ArrayList<>();
        this.healthBars = new BufferedImage[4];
        bulletSpeed = 2;
        imgRect = new Rectangle2D.Double(x, y, getWidth(), getHeight());
        fireable = 60;
        try {
            bulletImg = ImageTable.get("Bullet");
            this.healthBars[0] = ImageTable.get("Bar1");
            this.healthBars[1] = ImageTable.get("Bar2");
            this.healthBars[2] = ImageTable.get("Bar3");
            this.healthBars[3] = ImageTable.get("Bar4");
            lifeImg = ImageTable.get("Life");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Player Tank: no resources are found");
        }
    }

    public void toggleUpPressed() {
        this.UpPressed = true;
    }

    public void toggleDownPressed() {
        this.DownPressed = true;
    }

    public void toggleRightPressed() {
        this.RightPressed = true;
    }

    public void toggleLeftPressed() {
        this.LeftPressed = true;
    }

    public void toggleFirePressed() {
        this.FirePressed = true;
    }

    public void unToggleFirePressed() {
        this.FirePressed = false;
    }

    public void unToggleUpPressed() {
        this.UpPressed = false;
    }

    public void unToggleDownPressed() {
        this.DownPressed = false;
    }

    public void unToggleRightPressed() {
        this.RightPressed = false;
    }

    public void unToggleLeftPressed() {
        this.LeftPressed = false;
    }

    public void update() {
        if(fireable >0)
            fireable--;
        if (this.UpPressed) {
            this.moveForwards();
        }
        if (this.DownPressed) {
            this.moveBackwards();
        }

        if (this.LeftPressed) {
            this.rotateLeft();
        }
        if (this.RightPressed) {
            this.rotateRight();
        }

        if (this.FirePressed) {
            fire();
        }
        TankWars.addDrawable(this);
    }

    public int screenX() {
        int min = ConfigFile.get("SCREEN_WIDTH") / 4;
        int max = ConfigFile.get("MAP_WIDTH") - ConfigFile.get("SCREEN_WIDTH") / 2;
        if (x <= min) {
            return 0;
        } else if ((x - min) >= max) {
            return max;
        }
        return x - min;
    }

    public int screenY() {
        int min = ConfigFile.get("SCREEN_HEIGHT") / 2;
        int max = ConfigFile.get("MAP_HEIGHT") - ConfigFile.get("SCREEN_HEIGHT");
        if (y <= min) {
            return 0;
        } else if ((y - min) >= max) {
            return max;
        }
        return y - min;
    }

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


    public boolean getBoom() {
        return this.boom;
    }

    /**
     * This starts the PlaneGame methods
     *
     */


    public void addLife() {
        this.lifeCount += 1;
    }

    public void isDied() {
        TankWars.explosions.add(new Explosion(x, y, TankWars.bigExp));
        //System.out.println("player Tank explodes");

        //sp.play();
        if (this.lifeCount > 1) {
            lifeCount--;
            this.health = 200;
            this.x = (int)(Math.random()*1000+1);
            this.y = (int)(Math.random()*600+1);
        } else {
            this.x = 480;
            this.y = 500;
            boom = true;
        }

    }

    @Override
    public void collide(GameObject go) {

        if(go instanceof Tank){
            this.revert();
            go.revert();
        }
        if(go instanceof Wall){
            this.revert();
        }
        if(go instanceof LivesBoost){
            this.addLife();
            go.setShow(false);
        }
    }

    public int getDamage() {
        return this.damage;
    }


    public ArrayList<Bullet> getBulletList() {
        return this.myBulletList;
    }

    private void fire() {
        if(fireable == 0) {
            Bullet playerb;
            //still not working
            playerb = new Bullet(this.bulletImg, x, y, bulletDamage*4, angle, 8,
                    (int) (imgRect.getWidth() / 2.0) + 10, getWidth() / 2, getHeight() / 2);
            this.myBulletList.add(playerb);
            TankWars.addDrawable(playerb);
            fireable = 60;
        }
        unToggleFirePressed();

    }

    public void draw(Graphics g) {
        if (!boom) {
            imgRect = getBorder();
            AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
            rotation.rotate(Math.toRadians(angle), this.img.getWidth() / 2.0,
                    this.img.getHeight() / 2.0);

            Graphics2D g2d = (Graphics2D) g;
            if (this.health >= 150) {
                healthbar = new Health(healthBars[0], x, y + getHeight() + 8);
                healthbar.draw(g);
            }
            if (this.health < 150 && this.health >= 100) {
                healthbar = new Health(healthBars[1], x, y + getHeight() + 8);
                healthbar.draw(g);
            }
            if (this.health < 100 && this.health >= 50) {
                healthbar = new Health(healthBars[2], x, y + getHeight() + 8);
                healthbar.draw(g);
            }
            if (health < 50) {
                healthbar = new Health(healthBars[3], x, y + getHeight() + 8);
                healthbar.draw(g);
            }
            for (int i = 0; i < lifeCount; i++) {
                GameObject lifeObj = new Life(this.lifeImg, x + i * lifeImg.getWidth(null),
                        y - 20);
                lifeObj.draw(g);
            }
            //invisible tank....
            g2d.drawImage(this.img, rotation, null);
            //g2d.draw(imgRect);
        }


    }

    public int getScore(){return this.score;}
}