package Tasks.taskController;

import Tasks.taskModel.Pant;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import Tasks.taskModel.GatheringPantModel;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;


/** Controls the task "Gathering pant".
 * @auther Steffanie Kristiansson
 */
public class GatheringPantController {

    private GatheringPantModel pm;

    /** Variables for the player's score.
     */
    public int pantGathered = 0;

    /** Finished the task
     */
    public Boolean finished = false;
    
    /** The Controllers constructor, taking in the model and view to be able to use them.
     * @param pm representing the model to get data from the it.
     * @throws SlickException if file not found, slick-exception.
     */
    public GatheringPantController (GatheringPantModel pm) throws SlickException {
        this.pm = pm;
    }

    /** To update the running task.
     * @param gc the container that have the game.
     * @param delta represents time in ms since last update.
     * @throws SlickException if file not found, slick-exception.
     */
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        pantTimer(delta);
        pantGameOver(sbg);
        mouseFollower(gc);
        pantSpawner();
    }

    /** Check if task is completed, else if timer is at 0, create a new pant.
     * @throws SlickException if file not found, slick-exception.
     */
    public void pantGameOver(StateBasedGame sbg){
        if(finished) {
            // TODO: Make the ending display the players score etc
            pm.getPants().clear();
            sbg.enterState(1, new EmptyTransition(), new FadeInTransition());
        }

    }

    /** If there is five pant on screen, it is game over, the time and amount pant gathered is shown.
     *  Else continue the time counting.
     * @param delta represents time in ms since last update.
     */
    public void pantTimer(int delta) {
        if (pm.pantTimePassed <= 0) {
            finished = true;
        } else {
            // Change from ms to seconds
            pm.pantTimePassed -= (double) delta/1000;
            pm.pantSpawnerTimer += (double) delta/1000;
            // round to two decimals
            pm.pantSpawnerTimer = (float) (Math.round(pm.pantSpawnerTimer * 100.0) / 100.0);
            pm.pantTimePassed = (float) (Math.round(pm.pantTimePassed * 100.0) / 100.0);
        }
    }

    public void pantSpawner() throws SlickException {
        if (pm.pantSpawnerTimer >= 3.0 && pm.getPants().size() < 5){
            pm.addPant();
            pm.pantSpawnerTimer = 0;
        }
    }

    /** Track the mouse and score point if intersect
     * @param gc the container that have the game.
     * @throws SlickException if file not found, slick-exception.
     */
    public void mouseFollower(GameContainer gc) throws SlickException{
        // track the mouse
        pm.mouseBall.setCenterX(gc.getInput().getMouseX());
        pm.mouseBall.setCenterY(gc.getInput().getMouseY());

        for (Pant p : pm.getPants()) {
            p.getPantLocation().getCenterX();
            p.getPantLocation().getCenterY();
        }

        for (int i = pm.getPants().size() - 1; i >= 0; i--) {
            Pant p = pm.getPants().get(i);
            if (p.getPantLocation().intersects(pm.mouseBall)) {
                pm.getPants().remove(i);
                pantGathered++;
                pm.pantTimePassed += 0.3;
                // Not letting more than 5 pants spawn
                if (pm.getPants().size() < 5){
                    pm.addPant();
                }
            }
        }
    }
}
