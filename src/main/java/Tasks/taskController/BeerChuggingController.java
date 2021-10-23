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
     * Update function for the logic of the task.
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

    public void jump(Input input){
        // Adds the constant pull downwards from gravity
        bcm.vY += bcm.gravity;
        if (input.isKeyPressed(Input.KEY_SPACE ) && bcm.getJumpingBeerLocationY() >= 370){
            bcm.beerJump();
        }
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

    public void exitTask(Input input, StateBasedGame sbg){
        if (input.isKeyDown(Input.KEY_F)){
            bcm.resetBeerChuggingTask();
            sbg.enterState(101, new FadeOutTransition(), new HorizontalSplitTransition());
        }
    }
}
