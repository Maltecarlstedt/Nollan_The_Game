package Tasks;

import Tasks.taskController.GatheringPantController;
import Tasks.taskModel.GatheringPantModel;
import Tasks.taskView.GatheringPantView;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/** The task "Gathering pant".
 * @auther Steffanie Kristiansson
 */
public class PantRetrievingTask extends BasicGameState {

    private GatheringPantModel pm;
    private GatheringPantController pc;
    private GatheringPantView pv;


    /** Initiating the task.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        pm = new GatheringPantModel();
        pv = new GatheringPantView();
        pc = new GatheringPantController(pm);
    }


    /** Render the pant.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param g represents the graphics context to be used for rendering.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        pv.render(gc, g, pm, pc);
    }


    /** Update the frame of pant.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param delta represents time in ms since last update.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        pc.update(gc, delta);
    }


    /** A special ID for this specific state.
     * @return represents this state with a unique int.
     */
    @Override
    public int getID() {
        return 420;
    }
}
