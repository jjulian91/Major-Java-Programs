package gamefiles.HashMaps;

import java.util.HashMap;

/**
 * @author Jonthan Julian
 *
 * Class populates a Hashmap of all possible map inputs when loading from mapGen class.
 */

public class MapObjects {
    static HashMap<Integer, String> mapObjectTable;
    public static void init(){
        mapObjectTable = new HashMap<>();
        mapObjectTable.put(1, "IndestructibleWall");
        mapObjectTable.put(2, "DestructibleWall");
        mapObjectTable.put(3, "LivesBoost");

    }
    public static String get(Integer key){
        return mapObjectTable.get(key);
    }
}
