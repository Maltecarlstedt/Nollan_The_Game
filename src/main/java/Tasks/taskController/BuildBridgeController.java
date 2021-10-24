package Tasks.taskController;

import Tasks.taskModel.BuildBridgeModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;

/**
 * Updates the task.
 * Uses: BuildBridgeModel
 * @author Clara Simonsson
 */
public class BuildBridgeController {

    private BuildBridgeModel bbm;

    public BuildBridgeController(BuildBridgeModel bbm){
        this.bbm = bbm;

    }

    /**
     * Checks if the task is done
     * @param gc - The container that have the game
     * @param sbg - A state of the game so that we can change state back to maingame.
     */
    public void update(GameContainer gc, StateBasedGame sbg){
        if(gc.getInput().isKeyDown(Input.KEY_F)){
            sbg.enterState(1, new FadeOutTransition(), new HorizontalSplitTransition());
        }
    }
}
