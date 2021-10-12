package Tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Highscores {

    private String filePath;
    private boolean append_to_file = false;

    // To overwrite the file use this constructor.
    public Highscores(String filePath){
        this.filePath = filePath;
    }

    public Highscores(String filePath, boolean append_value){
        this.filePath = filePath;
        this.append_to_file = append_value;
    }

    // TODO: Bug, sometimes the scores are written on the same line. Making readHighScore not able to read.
    public void writeHighScore(String textLine) throws IOException{
        FileWriter writer = new FileWriter(filePath, append_to_file);
        PrintWriter print_line = new PrintWriter(writer);
        print_line.printf("%s" + "%n" , textLine);
        print_line.close();
    }

    public ArrayList<Double> readHighScore(){
        ArrayList<Double> highScoresSorted = new ArrayList<>();
        try{
            File highScoreFile =  new File(filePath);
            Scanner readHighScore = new Scanner(highScoreFile);
            while(readHighScore.hasNextLine()){
                String highScoreData = readHighScore.nextLine();
                highScoresSorted.add(Double.parseDouble(highScoreData));
            }
            sortHighScore(highScoresSorted);
            readHighScore.close();
        }catch (FileNotFoundException e){
            System.out.println("File not Found");
            e.printStackTrace();
        }
        return highScoresSorted;
    }
    public void sortHighScore(ArrayList<Double> unsortedList){
        Collections.sort(unsortedList);
        while(unsortedList.size() > 5){
            unsortedList.remove(unsortedList.size() - 1);
        }
    }
}


