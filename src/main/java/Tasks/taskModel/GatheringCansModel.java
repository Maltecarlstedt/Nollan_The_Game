package Tasks.taskModel;

import Tasks.Highscores;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/** Model of the task "Gathering Cans". Starts the task and keeps track of high-scores and the timers.
 * @author Steffanie Kristiansson
 * @author Alexander Brunnegård
 */
public class GatheringCansModel {

    /** Represents time passed on can-task.
     */
    private float taskTimer = 5;
    public float canSpawnerTimer = 3;
    public Circle mouseBall;
    private int score = 0;

    public boolean finished = false;
    public boolean isRunning = true;

    private Highscores hs = new Highscores("data/highscores/canHighscore.txt", true);

    private ArrayList<Double> canHighscore = new ArrayList<>();

    /** An ArrayList of all the cans.
     */
    ArrayList<Rectangle> cans = new ArrayList<>();

    private Random random = new Random();


    /** Gets the list of all the cans.
     * @return An array-list of all the cans.
     */
    public ArrayList<Rectangle> getCans() {
        return cans;
    }

    /** Initializing the Can Model.
     */
    public GatheringCansModel() {
        init();
    }

    /** Creates a new can.
     */
    public void addCan() {
        cans.add(newCan());
    }

    /** Initialize the mouse-"ball" and "create a new can".
     */
    public void init() {
        // the mouse with a circle and radius to collide with the cans
        mouseBall = new Circle(0,0,10);
        readHighScoreList();
        newCan();
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
        canHighscore = hs.readHighScore();
        Collections.reverse(canHighscore);
        hs.trimHighscore(canHighscore);
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
        taskTimer = 5;
    }

    public float getTaskTimer() {
        return taskTimer;
    }

    public void canReceived(){
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

    /** Create new can randomly on the screen.
     */
    public Rectangle newCan() {
        int x = random.nextInt((int)(1024/32))*32; // can on a square 32x32
        int y = random.nextInt((int)(768/32))*32; // can on a square 32x32

        return new Rectangle(x, y, 32, 32);
    }
}
