package gamefiles.HashMaps;

import gamefiles.TankWars;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Jonthan Julian
 *
 * Class populates a Hashmap consistenting of all images used for game.
 */

public class ImageTable {
        private static HashMap<String, BufferedImage> images = new HashMap<>();

        public static void init(){
            try {
                images.put("Tank", ImageIO.read(gamefiles.TankWars.class.getResource("/tank1.png")));
                images.put("SmallExp", ImageIO.read(gamefiles.TankWars.class.getResource("/small.gif")));
                images.put("LargeExp", ImageIO.read(gamefiles.TankWars.class.getResource("/large.gif")));
                images.put("Bullet", ImageIO.read(gamefiles.TankWars.class.getResource("/Weapon.gif")));
                images.put("Bar1", ImageIO.read(gamefiles.TankWars.class.getResource("/bar1.png")));
                images.put("Bar2", ImageIO.read(gamefiles.TankWars.class.getResource("/bar2.png")));
                images.put("Bar3", ImageIO.read(gamefiles.TankWars.class.getResource("/bar3.png")));
                images.put("Bar4", ImageIO.read(gamefiles.TankWars.class.getResource("/bar4.png")));
                images.put("Background", ImageIO.read(gamefiles.TankWars.class.getResource("/Background.bmp")));
                images.put("Life", ImageIO.read(gamefiles.TankWars.class.getResource("/lifeDot.png")));
                images.put("addLife.png", ImageIO.read(gamefiles.TankWars.class.getResource("/addLife.png")));
                images.put("Wall1.gif", ImageIO.read(gamefiles.TankWars.class.getResource("/Wall1.gif")));
                images.put("Wall2.gif", ImageIO.read(gamefiles.TankWars.class.getResource("/Wall2.gif")));

            }
            catch(IOException e){
                System.out.println("Failed to init Photos "+e);
            }
        }

        public static BufferedImage get(String key){
            return images.get(key);
        }
}


