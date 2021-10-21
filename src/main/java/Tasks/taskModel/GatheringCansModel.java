package Tasks.taskModel;


import Tasks.Highscores;
import model.MapStates.DeltaP;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.tiled.TiledMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/** Model of the task "Gathering Cans". Starts the task and keeps track of high-scores and the timers.
 * @author Steffanie Kristiansson
 * @author Alexander Brunnegård
 */
public class GatheringCansModel {

    /** Represents time passed on can-task.
     */
    private float taskTimer = 10;
    public float canSpawnerTimer = 3;
    public Circle mouseBall;
    public Image timerBox;
    private TiledMap background;
    public Image highScoreBox;
    private int score = 0;

    public boolean finished = false;
    public boolean isRunning = true;

    private Highscores hs = new Highscores("data/highscores/canHighscore.txt", true);

    private ArrayList<Double> canHighscore = new ArrayList<>();

    /** An ArrayList of all the cans.
     */
    ArrayList<Cans> cans = new ArrayList<>();


    /** Gets the list of all the cans.
     * @return An array-list of all the cans.
     */
    public ArrayList<Cans> getCans() {
        return cans;
    }

    /** Initializing the Can Model.
     * @throws SlickException if file not found, slick-exception.
     */
    public GatheringCansModel() throws SlickException {
        init();
        initTimerSetup();
    }

    /** Creates a new can.
     * @throws SlickException if file not found, slick-exception.
     */
    public void addCan() throws SlickException {
        cans.add(new Cans());
    }


    /** Initialize the mouse-"ball"
     */
    public void init() throws SlickException {
        // the mouse with a circle and radius to collide with the cans
        mouseBall = new Circle(0,0,10);
        background = DeltaP.DELTAP.loadMap();
        initHighScoreBox();
        readHighScoreList();
    }

    /** Initialize the high-score box.
     * @throws SlickException if file not found, slick-exception.
     */
    public void initHighScoreBox() throws SlickException {
        highScoreBox = new Image("data/boxes/highScoreBox_V2.png");
    }

    /** Read the top 5 score from our save, and sort them.
     */
    public void readHighScoreList(){
        canHighscore = hs.readHighScore();
        Collections.reverse(canHighscore);
        hs.trimHighscore(canHighscore);
    }

    /** Add the high-score to the List.
     */
    public void addHighScore(){
        // Try to add our score we just got.
        try {
            hs.writeHighScore(String.valueOf(score));
        }catch (IOException e){
            e.printStackTrace();
        }
        // Even though the player might not be top 5, we add his or hers score either way.
        canHighscore.add((double)score);
        canHighscore = hs.readHighScore();
        Collections.reverse(canHighscore);
        hs.trimHighscore(canHighscore);
    }

    /**
     * Fetches the image for the box where the timer will be placed inside
     * @throws SlickException Generic exception
     */
    public void initTimerSetup() throws SlickException {
        timerBox = new Image("data/boxes/timerBox.png");
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

    public ArrayList<Double> getCanHighscore() {
        return canHighscore;
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

    public void canRecieved(){
        taskTimer += 0.3;
    }

    public void outOfTime(){
        taskTimer = 0;
    }

    /** A timer for the spawner.
     * @param delta delta represents time in ms since last update.
     */
    public void timerUpdate(int delta){
        taskTimer -= (double) delta/1000;
        canSpawnerTimer += (double) delta/1000;
        // round to two decimals
        canSpawnerTimer = (float) (Math.round(canSpawnerTimer * 100.0) / 100.0);
        taskTimer = (float) (Math.round(taskTimer * 100.0) / 100.0);
    }
}
