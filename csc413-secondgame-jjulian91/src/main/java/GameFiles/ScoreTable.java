package GameFiles;

import GameFiles.GameObjects.Ship;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ScoreTable {

    private static BufferedReader reader;
    private static String fName= "/Scores.txt";
    private static ArrayList<Score> scoreBoard = new ArrayList<>();
    private static URL filePath;

    public static void init() {
        filePath = GalacticMail.class.getResource(fName);
        String currentRow;
        String name="", score="";
        int scoreInt = 0;
        try {
            //reader from the resources directory.
            reader = new BufferedReader(new InputStreamReader(GalacticMail.class.getResourceAsStream(
                    "/Scores.txt"), "UTF-8"));
            reader.readLine();
            while((currentRow = reader.readLine()) != null){
                String[] splitLine = currentRow.split("-");
                for (int i = 0; i < splitLine.length; i++) {
                    if (i == 0)
                        name = splitLine[i];
                    else if (i == 1) {
                        score = splitLine[i];
                        scoreInt = Integer.parseInt(score);
                    }
                }
                scoreBoard.add(new Score(name, scoreInt));
            }
            reader.close();
        } catch (IOException e) {e.printStackTrace();}
    }


    static int getMin(){return scoreBoard.get(4).getScore();}

    static void updateScore(int playerScore){
        init();
        int index = 4;
        int playerPosition = 6;
        String userName = null;
        if(playerScore > getMin()) {
            while (index >= 0 && playerScore > scoreBoard.get(index).getScore()) {
                index--;
                playerPosition--;
            }
            if (playerPosition != 6) {
                //popup for name entry
                //get info from pop up entry
                while (userName == null) {
                    userName = JOptionPane.showInputDialog("You've lost but enter your name High Score!");
                }
                scoreBoard.add(playerPosition - 1, new Score(userName, playerScore));

                try {
                    File outFile = new File(GalacticMail.class.getResource("/Scores.txt").getFile());
                    if (outFile.delete())
                        System.out.println("Deleted");
                    if (outFile.createNewFile())
                        System.out.println("Created");
                    PrintWriter output = new PrintWriter(outFile, "UTF-8");
                    output.println("Scores");

                    for (int i = 0; i < 5; i++) {
                        System.out.println(scoreBoard.get(i).toString());
                        output.write(scoreBoard.get(i).getName() + "-" + scoreBoard.get(i).getScore());
                        output.println();
                    }
                    output.close();
                } catch (IOException i) {
                    System.out.println("failed to write");
                }
            }
        }
        else{JOptionPane.showMessageDialog(null,"Loser!");}
    }

    static void displayScore(Graphics2D g2, int width, int height, int p1){
        ScoreTable.updateScore(p1);
        g2.drawString(scoreBoard.get(0).toString(), width, height);
        g2.drawString(scoreBoard.get(1).toString(), width, height+30);
        g2.drawString(scoreBoard.get(2).toString(), width, height+60);
        g2.drawString(scoreBoard.get(3).toString(), width, height+90);
        g2.drawString(scoreBoard.get(4).toString(), width, height+120);
    }

    static String top5(){
        String returnStr = new String();

        for(int i = 0; i < 5; i++){
            returnStr = returnStr.concat(scoreBoard.get(i).toString()+"\n");
        }
        return returnStr;
    }
}