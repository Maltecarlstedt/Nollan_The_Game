package Tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Alexander Brunnegård
 * @author Malte Carlstedt
 * This class enables the writing and reading from a highscore file
 */
public class Highscores {

    private String filePath;
    private boolean append_to_file = false;

    // To overwrite the file use this constructor.
    public Highscores(String filePath){
        this.filePath = filePath;
    }

    /**
     * The constructor that makes us being able to write in an existing
     * file, instead of deleting the content and starting over.
     * @param filePath The path to the highscore txt file
     * @param append_value if true   -   write to a file that is not full
     *                     if false  -   delete the content of the file
     *                                   and then write to that empty file
     */
    public Highscores(String filePath, boolean append_value){
        this.filePath = filePath;
        this.append_to_file = append_value;
    }

    /**
     * Writes a textline to the filepath
     * @param textLine - the text that is to be written to the file
     * @throws IOException - if no file is found at the filepath
     */
    // TODO: Bug, sometimes the scores are written on the same line. Making readHighScore not able to read.
    public void writeHighScore(String textLine) throws IOException{
        FileWriter writer = new FileWriter(filePath, append_to_file);
        PrintWriter print_line = new PrintWriter(writer);
        print_line.printf("%s" + "%n" , textLine);
        print_line.close();
    }

    /**
     * Extracts the data from the file of the highscore
     * @return the arraylist of the highscore
     */
    public ArrayList<Double> readHighScore(){
        ArrayList<Double> highScoresSorted = new ArrayList<>();
        try{
            File highScoreFile =  new File(filePath);
            Scanner readHighScore = new Scanner(highScoreFile);
            while(readHighScore.hasNextLine()){
                String highScoreData = readHighScore.nextLine();
                highScoresSorted.add(Double.parseDouble(highScoreData));
            }
            Collections.sort(highScoresSorted);
            readHighScore.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found");
            e.printStackTrace();
        }
        return highScoresSorted;
    }

    /**
     * Trims down the list to size 5.
     * @param untrimmedList - the trimmed arraylist
     */
    public void trimHighscore(ArrayList<Double> untrimmedList){
        while(untrimmedList.size() > 5){
            untrimmedList.remove(untrimmedList.size() - 1);
        }
    }
}


