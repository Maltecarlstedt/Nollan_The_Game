package Tasks.taskController;

import Tasks.taskModel.Pant;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
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

    /** Finished the task
     */
    
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
        if(pm.isRunning) {
            mouseFollower(gc);
            pantSpawner();
            pantTimer(delta);
        }
        if(pm.finished)
            pantGameOver(gc, sbg);

    }

    /** Check if task is completed, else if timer is at 0, create a new pant.
     * @throws SlickException if file not found, slick-exception.
     */
    public void pantGameOver(GameContainer gc, StateBasedGame sbg){
        if(gc.getInput().isKeyDown(Input.KEY_F)) {
            // TODO: Make the ending display the players score etc
            resetTask();
            sbg.enterState(1, new EmptyTransition(), new FadeInTransition());
        }

    }

    /** If there is five pant on screen, it is game over, the time and amount pant gathered is shown.
     *  Else continue the time counting.
     * @param delta represents time in ms since last update.
     */
    public void pantTimer(int delta) {
        if (pm.getTaskTimer() <= 0 && pm.isRunning) {
            stopTimer();
            exitTask();
        } else {
            // Change from ms to seconds
            pm.timerUpdate(delta);
        }
    }

    private void stopTimer(){
        pm.outOfTime();
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
                pm.increaseScore();
                pm.pantRecieved();
                // Not letting more than 5 pants spawn
                if (pm.getPants().size() < 5){
                    pm.addPant();
                }
            }
        }
    }

    public void exitTask(){
        pm.addHighScore();
        pm.getPants().clear();
        pm.finished = true;
        pm.isRunning = false;
    }

    private void resetTask(){
        pm.resetTimer();
        pm.resetScore();
        pm.isRunning = true;
        pm.finished = false;
    }
}
