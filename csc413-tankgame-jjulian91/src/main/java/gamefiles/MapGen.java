package gamefiles;

import gamefiles.GameObjects.GameObject;
import gamefiles.HashMaps.ConfigFile;
import gamefiles.HashMaps.ImageTable;
import gamefiles.HashMaps.MapObjects;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * @author Jonthan Julian
 *
 * Class generates the map allows for dynamic map generation from csv file.
 *
 *
 */

public class MapGen {
    private static BufferedReader reader;


    public static void init(Graphics2D g) throws IOException {

        //gets block size to apply correct spacing below
        int wallDims = ConfigFile.get("WallSize");

        try{
            //reader from the resources directory.
            reader = new BufferedReader(new InputStreamReader(gamefiles.TankWars.class.getResourceAsStream(
                    "/map.csv"), "UTF-8"));

            String currentRow;

            int j = 0;
            //loops through each row of items
            while((currentRow = reader.readLine()) != null){
                String[] splitLine = currentRow.split(",");
                String imgName;
                for(int i =0; i < splitLine.length; i++){
                    //checks for default "null" blocks
                    int objType = 0;
                    objType = Integer.parseInt(splitLine[i]);
                    if(objType != 0){
                        //update here for making folders.
                        String objName = MapObjects.get(objType);
                        //instantiates object via reflection for placement in the mapObjects arrayList
                         Class<?> obj = Class.forName("gamefiles.GameObjects."+objName);
                        if(objName.contains("Wall")){
                            if(objName.equals("IndestructibleWall")){
                                imgName = "Wall2.gif";
                            }
                            else{
                                imgName = "Wall1.gif";
                            }
                        }
                        else{
                            imgName = "addLife.png";
                        }
                        //gets image for object instantiation.
                        BufferedImage img = ImageTable.get(imgName);
                        GameObject newObj = (GameObject) obj.getConstructor(BufferedImage.class, int.class, int.class)
                                .newInstance(img, wallDims*i, wallDims*j);
                        //adds item to mapObjects arrayList for drawing
                        TankWars.addMapObject(newObj);
                    }

                }
                j++;
            }

        }
        catch (FileNotFoundException e){
            System.out.println("file not found   "+e);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException |
                ClassNotFoundException e){
            System.out.println("Method not found   "+e);
        }
        catch(NumberFormatException e){
            System.out.println("number issue");
        }


    }
}
