package Tasks.taskController;

import Tasks.taskModel.Cans;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import Tasks.taskModel.GatheringCansModel;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;


/** Controls the task "Gathering Cans" when resetting the task and collision between the mouse and the can.
 *  Uses the Gathering Cans Model.
 * @author Steffanie Kristiansson
 * @author Alexander Brunnegård
 */
public class GatheringCansController {

    private GatheringCansModel pm;
    
    /** Taking in the model to be able to use it.
     * @param pm representing the model to get data from it.
     */
    public GatheringCansController(GatheringCansModel pm) {
        this.pm = pm;
    }

    /** To update the running task.
     * @param gc the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param delta represents time in ms since last update.
     * @throws SlickException if file not found, slick-exception.
     */
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        if(pm.isRunning) {
            mouseFollower(gc);
            canSpawner();
            canTimer(delta);
        }
        if(pm.finished)
            canGameOver(gc, sbg);

    }

    /** Check if task is completed, else if timer is at 0, create a new can.
     * @param gc the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     */
    public void canGameOver(GameContainer gc, StateBasedGame sbg){
        if(gc.getInput().isKeyDown(Input.KEY_F)) {
            // TODO: Make the ending display the players score etc
            resetTask();
            sbg.enterState(1, new EmptyTransition(), new FadeInTransition());
        }

    }

    /** If there is five cans on screen, it is game over, the time and amount cans gathered is shown.
     *  Else continue the time counting.
     * @param delta represents time in ms since last update.
     */
    public void canTimer(int delta) {
        if (pm.getTaskTimer() <= 0 && pm.isRunning) {
            stopTimer();
            exitTask();
        } else {
            // Change from ms to seconds
            pm.timerUpdate(delta);
        }
    }

    /** Stop the timer.
     */
    private void stopTimer(){
        pm.outOfTime();
    }

    /** Adds a new can every 3 seconds.
     * @throws SlickException if file not found, slick-exception.
     */
    public void canSpawner() throws SlickException {
        if (pm.canSpawnerTimer >= 3.0 && pm.getCans().size() < 5){
            pm.addCan();
            pm.canSpawnerTimer = 0;
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

        for (Cans p : pm.getCans()) {
            p.getCanLocation().getCenterX();
            p.getCanLocation().getCenterY();
        }

        for (int i = pm.getCans().size() - 1; i >= 0; i--) {
            Cans p = pm.getCans().get(i);
            if (p.getCanLocation().intersects(pm.mouseBall)) {
                pm.getCans().remove(i);
                pm.increaseScore();
                pm.canRecieved();
                // Not letting more than 5 cans spawn
                if (pm.getCans().size() < 5){
                    pm.addCan();
                }
            }
        }
    }

    /** Exit the task with the high-score.
     */
    public void exitTask(){
        pm.addHighScore();
        pm.getCans().clear();
        pm.finished = true;
        pm.isRunning = false;
    }

    /** To restart the task and play again.
     */
    private void resetTask(){
        pm.resetTimer();
        pm.resetScore();
        pm.isRunning = true;
        pm.finished = false;
    }
}
