package Tasks.taskModel;

import Tasks.Highscores;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Malte Carlstedt
 * Model for the beer chugging task
 */
public class BeerChuggingModel {

    private Highscores hs = new Highscores("data/highscores/highscore.txt", true); // TODO kommentera
    private final int greenIndicatorHeight = 64, greenIndicatorWidth = 30;
    private final int jumpingBeerHeight = 24, jumpingBeerWidth = 30;

    /** Invisible rectangle for the jumping beer and green indicator location.
     * Using a rectangle to be able to calculate when the two are intersecting
     */
    public Rectangle greenIndicatorRect = new Rectangle(158, 630, jumpingBeerWidth, jumpingBeerHeight);
    public Rectangle jumpingBeerRect = new Rectangle(160, 665, greenIndicatorWidth, greenIndicatorHeight);

    /** The number of times the jumpingbeer intersects or contains inside the green indicator each update */
    public int numberOfChugs = 0;
    /** Index for which sprite is to be drawn for indicating the animation drinking */
    public int chugIndexAnimation = 0;

    /** An array with the top 5 best score from highscore.txt file */
    public ArrayList<Double> beerChuggingHighScore;

    /** Boolean for our green indicator to make sure it changes direction when reaching it's height*/
    public boolean upDir = true;

    /** Variable for time that has passed since the task started */
    public float timePassed;

    /** The speed at which the green indicator moves at */
    public double greenIndicatorSpeed = 3;

    /** Boolean for if the jumping beer is inside the green indicator */
    public boolean beerInside;

    public boolean isTaskFinished = false;
    public boolean isTaskRunning;

    /** The negative downforce for pulling the jumpingbeer down after a jump*/
    public final static float gravity = 0.7f;
    /** The height of each jump when pressing the jump button */
    public final static float jumpStrength = -5;
    /** The vertical Y direction for our jump, alterning depending if going up or down*/
    public float vY = 0;

    /**
     * Constructor for beerchuggingmodel. Starts the task and read from highscore
     */
    public BeerChuggingModel(){
        isTaskRunning = true;
        readHighScoreList();
        //background = Ekak.INSTANCE.loadMap();
    }

   
    /**
     * Reads the top 5 highscore for this task and adds them to an arrayList
     */
    public void readHighScoreList(){
        // Read the top score
        beerChuggingHighScore = hs.readHighScore();
        // Remove all but five
        hs.trimHighscore(beerChuggingHighScore);
    }

    /**
     * Adds our highscore for this task which in this case will be the time taken to finish drinking up.
     */
    public void addHighScore(){
        // Add our score we just got.
        String time = String.valueOf(timePassed);
        try {
            hs.writeHighScore(time);
        }catch (IOException e){
            e.printStackTrace();
        }
        beerChuggingHighScore.add(Double.parseDouble(time));

        Collections.sort(beerChuggingHighScore);
        // Remove all but top 5
        hs.trimHighscore(beerChuggingHighScore);
    }
     /**
     * Checks if the jumping beer is inside or intersects with the green indicator
     * @return How many times the beer has been inside or intersected with the indicator.
     */
    public int checkIntersect(){
        if(greenIndicatorRect.intersects(jumpingBeerRect) || greenIndicatorRect.contains(jumpingBeerRect)){
            numberOfChugs++;
            // Changes a boolean to indicate for player that the jumping beer is inside or intersected with the indicator.
            beerInside = true;
        }else{
            beerInside = false;
        }
        return numberOfChugs;
    }
    /**
     * Updates location for the jumping beer for each time the user has pressed the spacebar.
     */
    public void beerJump() {
        setJumpingBeerLocationY(getJumpingBeerLocationY() - 25);
        vY = jumpStrength;
    }

    /**
     * If the player has managed to be inside the green indicator for 30 updates. The sprite changes one image.
     * Resets the numberOfChugs until we have reached the last sprite.
     * If task if finished we add our score. The score will only be added if we manage to beat the top 5 scores
     */
    public void updateChugAnimation(){
        if(numberOfChugs > 30){
            numberOfChugs = 0;
            chugIndexAnimation++;
        }else if (isTaskFinished){
            // Task finished, add score and reset stuff
            if(isTaskRunning){
                addHighScore();
                beerChuggingHighScore = hs.readHighScore();
                hs.trimHighscore(beerChuggingHighScore);
            }
            isTaskRunning = false;
        }
    }

    /**
     * A timer that updates the time it takes for player to chug beer.
     * @param delta time in ms since last update
     */
    public void chugTimer(int delta){
        // Stop when the beer is empty.
        if(!isTaskFinished){
            // Changes from ms to seconds and adds to our variable
            timePassed += (double) delta/1000;
            // Round to two decimals.
            timePassed = (float) (Math.round(timePassed * 100.0) / 100.0);
        }
    }

    /**
     * Updates the green indicator that moves up and down. Also increases its speed each time it changes dir.
     */
    public void loopGreenIndicatorLocation() {
        if (upDir && getGreenIndicatorLocation().y > 326) {
            setGreenIndicatorLocationY((int) (getGreenIndicatorLocation().y - greenIndicatorSpeed));
        }else{
            upDir = false;
            // Increasing speed each time it changes direction
        }

        greenIndicatorSpeed += 0.002;

        if (!upDir && getGreenIndicatorLocation().y < 630){
            setGreenIndicatorLocationY((int) (getGreenIndicatorLocation().y + greenIndicatorSpeed));
        }else{
            upDir = true;
            // Increasing speed each time it changes direction

        }
        greenIndicatorSpeed += 0.002;
    }

    public Rectangle getGreenIndicatorLocation(){
        return greenIndicatorRect;
    }

    public void setGreenIndicatorLocationY(int greenIndicatorReactLocation) {
        this.greenIndicatorRect.y = greenIndicatorReactLocation;
    }

    public int getJumpingBeerLocationY() {
        return jumpingBeerRect.y;
    }

    public int getJumpingBeerLocationX(){
        return jumpingBeerRect.x;
    }

    public void setJumpingBeerLocationY(int jumpingBeerLocation) {
        this.jumpingBeerRect.y = jumpingBeerLocation;
    }

    /**
     * Resets the task so that it can be played again
     */
    public void resetBeerChuggingTask() {
        chugIndexAnimation = 0;
        timePassed = 0;
        greenIndicatorSpeed = 3;
        isTaskRunning = true;
        isTaskFinished = false;
    }
}
