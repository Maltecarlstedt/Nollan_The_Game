package Tasks.taskController;

import Tasks.Highscores;
import Tasks.taskModel.BeerChuggingModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Controller for the Beer Chugging task
 */
public class BeerChuggingController {

    /** An instance of our beerchugging model and View */
    private BeerChuggingModel bcm;


    /** The speed at which the green indicator moves at */
    private double indicatorSpeed = 3;
    /** The negative downforce for pulling the jumpingbeer down after a jump*/
    private final static float gravity = 0.7f;
    /** The height of each jump when pressing the jump button */
    private final static float jumpStrength = -5;
    /** The vertical Y direction for our jump, alterning depending if going up or down*/
    private float vY = 0;
    /** Boolean for our green indicator to make sure it changes direction when reaching it's height*/
    private boolean upDir = true;
    /** The number of times the jumpingbeer intersects or contains inside the green indicator each update */
    private int numberOfChugs = 0;
    /** Index for which sprite is to be drawn for indicating the animation drinking */
    private int chugIndexAnimation = 0;



    /**
     * Constructor for beer chugging controller. Initialize which model to work on.
     * @param bcm The model
     */
    public BeerChuggingController(BeerChuggingModel bcm){
        this.bcm = bcm;
    }

    /**
     * Update function for the logic of the task.
     *
     * @param gc The container that have the game
     * @param delta Time in ms since last update
     * @throws SlickException Generic Exception
     */
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException, IOException {
        loopGreenThingyLocation();
        beerJump(gc, delta);
        checkIntersect();
        updateChugAnimation();
        chugTimer(delta);
        if(bcm.isTaskFinished){
            exitTask(gc, sbg);
        }
    }

    /**
     * A timer that updates the time it takes for player to chug beer.
     * @param delta
     */
    public void chugTimer(int delta){
        // Stop when the beer is empty. AKA when reaching the last sprite.
        if(chugIndexAnimation > 8){
            //System.out.println("Bra hävt! Din tid blev: " + bcm.timePassed);
        }else
        // Changes from ms to seconds
        bcm.timePassed += (double) delta/1000;
        // Round to two decimals.
        bcm.timePassed = (float) (Math.round(bcm.timePassed * 100.0) / 100.0);
    }

    /**
     * Updates the green indicator that moves up and down. Also increases its speed each time it changes dir.
     */
    public void loopGreenThingyLocation() {
        if (upDir) {
            if(bcm.getGreenThingyLocation().y > 326){
                bcm.setGreenThingyLocation((int) (bcm.getGreenThingyLocation().y - indicatorSpeed));
            }else
                upDir = false;
                // Increasing speed each time it changed direction
                indicatorSpeed += 0.001;
            }else{
            if(bcm.getGreenThingyLocation().y < 630){
                bcm.setGreenThingyLocation((int) (bcm.getGreenThingyLocation().y + indicatorSpeed));

            }else
                upDir = true;
            // Increasing speed each time it changed direction
            indicatorSpeed += 0.001;
        }
    }

    /**
     * Checks if the jumping beer is inside or intersects with the green indicator
     * @return How many times the beer has been inside or intersected with the indicator.
     */
    public int checkIntersect(){
        if(bcm.greenThingyReact.intersects(bcm.jumpingBeerRect) || bcm.greenThingyReact.contains(bcm.jumpingBeerRect)){
            numberOfChugs++;
            // Changes a boolean to indicate for player that the jumping beer is inside or intersected with the indicator.
            bcm.inside = true;
        }else{
            bcm.inside = false;
        }
        return numberOfChugs;
    }

    /**
     * A jump algorithm that makes the jumping beer jump each time pressing the space bar and then fall down.
     * @param gc The container that have the game
     * @param delta Time in ms since last update
     */
    public void beerJump(GameContainer gc, int delta) {
        // TODO: Write the jump algorithm using delta instead to make the jump smoother.
        // Adds the constant pull downwards from gravity
        vY += gravity;
        // Input from player
        Input input = gc.getInput();

        // Makes sure that we cant jump outside of our bar indicator.
        // TODO: Make use of variables here instead of hardcoded numbers.
        if(bcm.getJumpingBeerLocationY() < 370){
        }else
            if (input.isKeyPressed(Input.KEY_SPACE)) {
                bcm.setJumpingBeerLocationY(bcm.getJumpingBeerLocationY() - 25);
                vY = jumpStrength;
        }
        if(bcm.getJumpingBeerLocationY() >= 665){
        }
        else {
            bcm.setJumpingBeerLocationY((int) (bcm.getJumpingBeerLocationY() + 0.2f + vY));
        }
    }

    /**
     * If the player has managed to be inside the green indicator for 30 updates. The sprite changes one image.
     * Resets the numberOfChugs until we have reached the last sprite.
     */
    public void updateChugAnimation(){
        if(numberOfChugs > 30){
            numberOfChugs = 0;
            chugIndexAnimation++;
            if(chugIndexAnimation <= 8){
                bcm.updateChug(chugIndexAnimation);
            }else{
                bcm.isTaskFinished = true;
            }
        }
    }

    public void exitTask(GameContainer gc, StateBasedGame sbg){
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_F)){
            bcm.addHighScore();
            sbg.enterState(1, new FadeInTransition(), new HorizontalSplitTransition());
        }
        resetBeerChuggingTask();
    }

    private void resetBeerChuggingTask() {
        //TODO: DO this
        // Started on this
    }

}
