import model.MapModel;
import model.MapStates.MapState;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

/** Represents the entering to a task-state
 *
 * @author Clara & Malte
 */
public class EnterTask {

    private Input input;
    private String currMap;

    /** Checks the terms in the if-statements  is fulfilled. If it is fulfilled, we jump to the right state.
     * @param gc represents the container that have the game.
     * @param mapModel represents the map in the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     */
    public void update(GameContainer gc, MapModel mapModel, StateBasedGame sbg){
        input = gc.getInput();
        currMap = mapModel.getCurrentMap().toString();
        if(input.isKeyDown(Input.KEY_F) && mapModel.hasTask()){
            mapModel.taskDone = true;
            int id = sbg.getCurrentStateID();
            switch (currMap){
                case "EKAK":
                    id = 69;
                    break;
                case "DELTAP":
                    id = 420;
                    break;
                case "ADAMMEN":
                    id = 21;
                    break;
            }
            sbg.enterState(id, new FadeInTransition(), new HorizontalSplitTransition());
        }
    }
}
