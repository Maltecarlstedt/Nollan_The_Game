package Tasks;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Highscores {

    private String filePath;
    private boolean append_to_file = false;
    
    public Highscores(String filePath){
        this.filePath = filePath;
    }

    public Highscores(String filePath, boolean append_value){
        this.filePath = filePath;
        this.append_to_file = append_value;
    }

    public void writeHighScore(String textLine) throws IOException{
        FileWriter writer = new FileWriter(filePath, append_to_file);

        PrintWriter print_line = new PrintWriter(writer);

        print_line.printf("%s" + "%n" , textLine);
        print_line.close();
    }

/*
    public void writeHighScore(double score){
        try{
            PrintWriter writer = new PrintWriter("data/highscore.txt", "UTF-8");
            writer.println(score);
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    */

}
