package GameFiles.HashMaps;

import java.util.HashMap;

/**
 * @author Jonthan Julian
 *
 * Class populates a Hashmap consistenting of all configuration parameters.
 */

public class ConfigFile {
    private static HashMap<String, Integer> configuration = new HashMap<>();

    public static void init(){
        configuration.put("MAP_WIDTH", 640); //
        configuration.put("MAP_HEIGHT",512);  //
        configuration.put("SCREEN_WIDTH", 640);
        configuration.put("SCREEN_HEIGHT", 512);
        configuration.put("BASE_SIZE", 64);

    }

    public static Integer get(String key){
       return configuration.get(key);
    }

}
