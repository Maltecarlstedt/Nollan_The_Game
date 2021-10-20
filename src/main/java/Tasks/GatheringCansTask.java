package Tasks;

import Tasks.taskController.GatheringCansController;
import Tasks.taskModel.GatheringCansModel;
import Tasks.taskView.GatheringCansView;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/** The task "Gathering Cans".
 * @author Steffanie Kristiansson
 */
public class GatheringCansTask extends BasicGameState {

    private GatheringCansModel pm;
    private GatheringCansController pc;
    private GatheringCansView pv;


    /** Initiating the task.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        pm = new GatheringCansModel();
        pv = new GatheringCansView();
        pc = new GatheringCansController(pm);
    }

    /** Render the can.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param g represents the graphics context to be used for rendering.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        pv.render(g, pm);
    }


    /** Update the frame of can.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param delta represents time in ms since last update.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        pc.update(gc, sbg, delta);
    }


    /** A special ID for this specific state.
     * @return represents this state with a unique int.
     */
    @Override
    public int getID() {
        return 420;
    }
}
