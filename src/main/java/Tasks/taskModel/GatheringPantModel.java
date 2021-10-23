package Tasks.taskModel;


import Tasks.Highscores;
import model.MapStates.DeltaP;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.tiled.TiledMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/** Model of the task "Gathering pant".
 * @auther Steffanie Kristiansson
 */
public class GatheringPantModel {

    /** Represents time passed on pant-task.
     */
    private float taskTimer = 10;
    public float pantSpawnerTimer = 3;
    public Circle mouseBall;
    public Image timerBox;
    private TiledMap background;
    public Image highScoreBox;
    private int score = 0;

    public boolean finished = false;
    public boolean isRunning = true;

    private Highscores hs = new Highscores("data/pantHighscore.txt", true);

    private ArrayList<Double> pantHighscore = new ArrayList<>();

    /** An ArrayList of all the pant.
     */
    ArrayList<Pant> pants = new ArrayList<>();


    /** Gets the list of all the pant.
     * @return An array-list of all the pant.
     */
    public ArrayList<Pant> getPants() {
        return pants;
    }


    public GatheringPantModel() throws SlickException {
        init();
        initTimerSetup();
    }

    /** Creates a new pant.
     * @throws SlickException if file not found, slick-exception.
     */
    public void addPant() throws SlickException {
        pants.add(new Pant());
    }


    /** Initiate the mouse-"ball"
     */
    public void init() throws SlickException {
        // the mouse with a circle and radius
        mouseBall = new Circle(0,0,10);
        background = DeltaP.DELTAP.loadMap();
        initHighScoreBox();
        readHighScoreList();

    }

    public void initHighScoreBox() throws SlickException {
        highScoreBox = new Image("data/highScoreBox.png");
    }

    public void readHighScoreList(){
        //Read the top 5 score from our save
        pantHighscore = hs.readHighScore();
        // Sort them
        Collections.reverse(pantHighscore);
        hs.trimHighscore(pantHighscore);
    }

    public void addHighScore(){
        // Try to add our score we just got.
        try {
            hs.writeHighScore(String.valueOf(score));
        }catch (IOException e){
            e.printStackTrace();
        }
        // Even though the player might not be top 5 we add his or hers score either way.
        pantHighscore.add((double)score);
        pantHighscore = hs.readHighScore();
        Collections.reverse(pantHighscore);
        hs.trimHighscore(pantHighscore);
    }

    /**
     * Fetches the image for the box where the timer will be placed inside
     * @throws SlickException Generic exception
     */
    public void initTimerSetup() throws SlickException {
        timerBox = new Image("data/timerBox.png");
    }

    public TiledMap getBackground() {
        return background;
    }

    public void increaseScore(){
        score++;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Double> getPantHighscore() {
        return pantHighscore;
    }

    public void resetScore(){
        score = 0;
    }

    public void resetTimer(){
        taskTimer = 10;
    }

    public float getTaskTimer() {
        return taskTimer;
    }

    public void pantRecieved(){
        taskTimer += 0.3;
    }

    public void outOfTime(){
        taskTimer = 0;
    }

    public void timerUpdate(int delta){
        taskTimer -= (double) delta/1000;
        pantSpawnerTimer += (double) delta/1000;
        // round to two decimals
        pantSpawnerTimer = (float) (Math.round(pantSpawnerTimer * 100.0) / 100.0);
        taskTimer = (float) (Math.round(taskTimer * 100.0) / 100.0);
    }
    // TODO: create some kind of database (or such) to save the score for each completed task.
}
