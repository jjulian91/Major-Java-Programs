package gamefiles.HashMaps;

import java.util.HashMap;

/**
 * @author Jonthan Julian
 *
 * Class populates a Hashmap consistenting of all configuration parameters.
 */

public class ConfigFile {
    private static HashMap<String, Integer> configuration = new HashMap<>();

    public static void init(){
        configuration.put("MAP_WIDTH", 2016); //32*63
        configuration.put("MAP_HEIGHT",1536);  //32*48
        configuration.put("SCREEN_HEIGHT", 768);
        configuration.put("SCREEN_WIDTH", 1280);
        configuration.put("WallSize", 32);
    }

    public static Integer get(String key){
       return configuration.get(key);
    }
}
