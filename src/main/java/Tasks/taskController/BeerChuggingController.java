package Tasks.taskController;

import Tasks.taskModel.BeerChuggingModel;
import Tasks.taskView.BeerChuggingView;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;
import java.io.IOException;

/**
 * @author Malte Carlstedt
 * Controller for the Beer Chugging task
 *
 * Uses BeerChuggingModel and BeerChuggingView
 * Used by BeerChuggingTask
 */
public class BeerChuggingController {

    /** An instance of our beerchugging model and View */
    private BeerChuggingModel bcm;
    private BeerChuggingView bcv;


    /**
     * Constructor for beer chugging controller. Initialize which model to work on.
     * @param bcm The model
     */
    public BeerChuggingController(BeerChuggingModel bcm, BeerChuggingView bcv){
        this.bcm = bcm;
        this.bcv = bcv;
    }
    /**
     * Update function for the logic of the task each update.
     *
     * @param gc The container that have the game
     * @param delta Time in ms since last update
     */
    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        Input input = gc.getInput();
        bcm.loopGreenIndicatorLocation();
        bcm.checkIntersect();
        bcm.updateChugAnimation();
        chugAnimationUpdate();
        bcm.chugTimer(delta);
        jump(input);
        if(bcm.isTaskFinished){
            exitTask(input, sbg);
        }
    }

    /**
     * Handles the input from the user pressing the spacebar to simulate an actual jump in game.
     *
     * @param input the input from the user
     */
    public void jump(Input input){
        // Adds the constant pull downwards from gravity
        bcm.vY += bcm.gravity;
        // Make sure that the jump is disabled if we are out of bound.
        if (input.isKeyPressed(Input.KEY_SPACE ) && bcm.getJumpingBeerLocationY() >= 370){
            bcm.beerJump();
        }
        // Make sure to catch the beer so it doesnt fall of the screen.
        if (bcm.getJumpingBeerLocationY() <= 665) {
            bcm.setJumpingBeerLocationY((int) (bcm.getJumpingBeerLocationY() + 0.2f + bcm.vY));
        }
    }

    /** Changes sprite image to be drawn to illustrate the player drinking*/
    private void chugAnimationUpdate(){
        if (bcm.chugIndexAnimation <= 8){
            bcv.currentChugAnimation = bcv.chuggingAnimation.getSubImage(bcm.chugIndexAnimation, 0);
        }else
            bcm.isTaskFinished = true;
    }

    /**
     * Changes state back to maingame when player presses 'F'. Also resets the task.
     * @param input Input from the user
     * @param sbg A state of the game so that we can change state back to maingame.
     */
    public void exitTask(Input input, StateBasedGame sbg){
        if (input.isKeyDown(Input.KEY_F)){
            bcm.resetBeerChuggingTask();
            sbg.enterState(101, new FadeOutTransition(), new HorizontalSplitTransition());
        }
    }
}
