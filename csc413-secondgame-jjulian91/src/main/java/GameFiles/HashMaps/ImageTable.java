
package GameFiles.HashMaps;

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
                images.put("ShipLaunched", ImageIO.read(GameFiles.GalacticMail.class.getResource("/Flying.gif")));
                images.put("ShipLanded", ImageIO.read(GameFiles.GalacticMail.class.getResource("/Landed.gif")));
                images.put("Base", ImageIO.read(GameFiles.GalacticMail.class.getResource("/Bases.gif")));
                images.put("Asteroid", ImageIO.read(GameFiles.GalacticMail.class.getResource("/Asteroid.gif")));
                images.put("Background", ImageIO.read(GameFiles.GalacticMail.class.getResource("/Background.bmp")));
                images.put("Home",ImageIO.read(GameFiles.GalacticMail.class.getResource("/Moon.gif")));

            }
            catch(IOException e){
                System.out.println("Failed to init Photos "+e);
            }
        }

        public static BufferedImage get(String key){
            return images.get(key);
        }
}


