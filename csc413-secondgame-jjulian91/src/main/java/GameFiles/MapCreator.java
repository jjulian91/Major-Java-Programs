package GameFiles;

import GameFiles.GameObjects.Asteroid;
import GameFiles.GameObjects.Base;
import GameFiles.GameObjects.GameObject;
import GameFiles.GameObjects.Home;
import GameFiles.HashMaps.ImageTable;

import java.util.ArrayList;

class MapCreator {
    //640 x 512
    //10 x 8
    // 5 moons
    static int x, y;
    static void create(int level){
        int speed;
        if(level < 5)
            speed = 2;
        else {speed =(int)(Math.random()*5+1);}

        if(level > 5) {
            level = 5;
        }
        for(int i = 0; i< level; i++){
            int angle = (int)(Math.random()*360+1);
            while(angle > 0 && angle < 10 || angle > 175 && angle < 185)
                angle = (int)(Math.random()*360+1);
            GalacticMail.addAsteroid(new Asteroid(ImageTable.get("Asteroid"), (int)(Math.random()*550+1),
                    (int)(Math.random()*400+1), speed,angle));
        }
        for(int i = 0; i < 6; i++){
            //sets home to be current location of ship.
            if(i == 0){
               x = GalacticMail.getFirstX();
               y = GalacticMail.getFirstY();
                Home newHome = new Home(ImageTable.get("Home"), x, y);
                GalacticMail.addMapObject(newHome);
            }
            //generates 5 moons in random locations
            else{
                boolean collides = true;
                Base newBase = new Base(ImageTable.get("Base"), 0,0);
                ArrayList<GameObject> mapItems = GalacticMail.getMapItems();
                while(collides) {
                    collides = false;
                    newBase = new Base(ImageTable.get("Base"), (int) (Math.random() * 550 + 1),
                            (int) (Math.random() * 400 + 1));
                    for (GameObject go : mapItems) {
                        if (go.getBorder().intersects(newBase.getBorder()))
                            collides = true;
                    }
                }
                GalacticMail.addMapObject(newBase);
            }

        }
        /*try{
            File map = new File(GalacticMail.class.getResource("/map.csv").toURI());
            FileWriter fw = new FileWriter(map, false);
        }
        catch (URISyntaxException | IOException e){e.printStackTrace();}*/
    }
}
