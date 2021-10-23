package Tasks.taskController;

import Tasks.taskModel.BuildBridgeModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;

/**
 * @author Clara Simonsson
 */
public class BuildBridgeController {

    private BuildBridgeModel bbm;

    public BuildBridgeController(BuildBridgeModel bbm){
        this.bbm = bbm;

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        if(gc.getInput().isKeyDown(Input.KEY_F)){
            sbg.enterState(101, new FadeOutTransition(), new HorizontalSplitTransition());
        }
    }
}
