package Tasks;

import Tasks.taskController.GatheringCansController;
import Tasks.taskModel.GatheringCansModel;
import Tasks.taskView.GatheringCansView;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/** The task "Gathering Cans" which calls everything to start the task. Uses Gathering Cans model, controller and view.
 * @author Steffanie Kristiansson
 */
public class GatheringCansTask extends BasicGameState {

    private GatheringCansModel gcm;
    private GatheringCansController gcc;
    private GatheringCansView gcv;


    /** Initiating the task.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        gcm = new GatheringCansModel();
        gcv = new GatheringCansView();
        gcc = new GatheringCansController(gcm);
    }

    /** Render the can.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param g represents the graphics context to be used for rendering.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        gcv.render(g, gcm);
    }


    /** Update the frame of can.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param delta represents time in ms since last update.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        gcc.update(gc, sbg, delta);
    }


    /** A special ID for this specific state.
     * @return represents this state with a unique int.
     */
    @Override
    public int getID() {
        return 420;
    }
}
