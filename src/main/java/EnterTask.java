import model.MapModel;

import model.MapStates.*;
import model.PlayerModel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

/** Represents the entering to a task-state
 *
 * @author Clara Simonsson
 * @author Malte Carlstedt
 */
public class EnterTask {

    /** Checks the terms in the if-statements  is fulfilled. If it is fulfilled, we jump to the right state.
     * @param gc represents the container that have the game.
     * @param mapModel represents the map in the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     */

    public void update(GameContainer gc, MapModel mapModel, StateBasedGame sbg){
        Input input = gc.getInput();
        MapState currMap = mapModel.getCurrentMap();
        if(input.isKeyDown(Input.KEY_F) && mapModel.hasTask()){
            mapModel.taskDone = true;
            if (Ekak.INSTANCE.equals(currMap)) {
                sbg.enterState(69, new FadeInTransition(), new HorizontalSplitTransition());
            } else if (DeltaP.INSTANCE.equals(currMap)) {
                sbg.enterState(420, new FadeInTransition(), new HorizontalSplitTransition());
            } else if (Dammen.INSTANCE.equals(currMap)) {
                sbg.enterState(21, new FadeInTransition(), new HorizontalSplitTransition());
            }
        }
    }
}
