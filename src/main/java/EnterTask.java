import model.MapModel;
import model.MapStates.MapState;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

/** Represents the entering to a task-state
 */
public class EnterTask {

    private Input input;
    private String currMap;

    // TODO: fix so the maps are being loaded.

    /** Checks the terms in the if-statements  is fulfilled. If it is fulfilled, we jump to the right state.
     * @param gc represents the container that have the game.
     * @param mapModel represents the map in the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     */

    // NOT AT ALL FINAL. JUST FOR DEV AND TESTING.
    public void update(GameContainer gc, MapModel mapModel, StateBasedGame sbg){
        input = gc.getInput();
        currMap = mapModel.getCurrentMap().toString();
        if(input.isKeyDown(Input.KEY_F)){
            if (currMap.equals("EKAK")){
                sbg.enterState(69, new FadeInTransition(), new HorizontalSplitTransition()); // Idk ser lite dumt ut
            }
            else if (currMap.equals("DELTAP")){
                sbg.enterState(420, new EmptyTransition(), new VerticalSplitTransition());
            }
            else if (currMap.equals("ADAMMEN")){
                sbg.enterState(21, new FadeOutTransition(), new VerticalSplitTransition());
            }
        }
    }
}
