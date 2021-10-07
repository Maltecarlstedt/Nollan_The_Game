package Tasks;

import Tasks.taskController.GatheringPantController;
import Tasks.taskModel.GatheringPantModel;
import Tasks.taskModel.Pant;
import Tasks.taskView.GatheringPantView;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


/** The task "Gathering pant".
 * @auther Steffanie Kristiansson
 */
public class PantRetrievingTask extends BasicGameState {

    private GatheringPantModel pm;
    private GatheringPantController pc;
    private GatheringPantView pantView;

    private Circle mouseBall;


    /** Initiating the task.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        pm = new GatheringPantModel();
        pantView = new GatheringPantView();
        pc = new GatheringPantController(pm, pantView);

        // the mouse with a circle and radius
        mouseBall = new Circle(0,0,5);

    }


    /** Render the pant.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param g represents the graphics context to be used for rendering.
     * @throws SlickException if file not found, slick-exception.
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        pantView.render(gc, g, pm);

        // the mouse color
        g.setColor(Color.cyan);
        g.fill(mouseBall);
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


        // track the mouse
        mouseBall.setCenterX(gc.getInput().getMouseX());
        mouseBall.setCenterY(gc.getInput().getMouseY());

        for (Pant p : pm.getPants()) {
            p.getPantLocation().getCenterX();
            p.getPantLocation().getCenterY();
        }

        for (int i = pm.getPants().size() - 1; i >= 0; i--) {
            Pant p = pm.getPants().get(i);
            if (p.getPantLocation().intersects(mouseBall)) {
                pm.getPants().remove(i);
                pc.pantGathered++;
                System.out.println(pc.pantGathered);
                if (pc.totalPantOnScreen > 0) {
                    pc.totalPantOnScreen--;
                    System.out.println(pc.totalPantOnScreen);
                } else {
                    pc.totalPantOnScreen = 0;
                    System.out.println(pc.totalPantOnScreen);
                }
                pm.addPant();
                pc.totalPantOnScreen++;
            }
        }

        if (pc.isRunning == false) {
            sbg.enterState(1);
        }
    }


    /** A special ID for this specific state.
     * @return represents this state with a unique int.
     */
    @Override
    public int getID() {
        return 420;
    }
}
