package Tasks.taskController;

import Tasks.taskModel.Pant;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import Tasks.taskModel.GatheringPantModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** Controls the task "Gathering pant".
 * @auther Steffanie Kristiansson
 */
public class GatheringPantController {

    public PlayerModel playerModel;

    private GatheringPantModel pm;



    /** Variables for the player's time and score.
     */
    public int totalPantOnScreen = 0;
    public int pantGathered = 0;

    /** Variables for the timer on the pant.
     */
    public Timer stopWatch;
    public int count = 0;
    public int delay = 1000; // in milli-seconds

    /** Variable (true/false) if the task is running.
     */
    public Boolean isRunning = false;


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
    public void update(GameContainer gc, int delta) throws SlickException{
        isRunning = true;
        pantTimer(delta);
        pantOnScreen();
        Input input = gc.getInput();
        mouseFollower(gc);
    }


    /** Check if timer is at 0, if so, then create a new pant.
     * @throws SlickException if file not found, slick-exception.
     */
    public void pantOnScreen() throws SlickException {
       if (count == 0) {   // if timer down on 0, create new pant
            pm.addPant();
           totalPantOnScreen++;
            startTimer(10);
        }
    }


    /** If there is five pant on screen, it is game over, the time and amount pant gathered is shown.
     *  Else continue the time counting.
     * @param delta represents time in ms since last update.
     */
    public void pantTimer(int delta) {

        if (totalPantOnScreen > 5) {
            stopWatch.stop();
            //System.out.println("Bra samlat! " + pantGathered + " st!!");
            //System.out.println("Din tid blev: " + pm.pantTimePassed);
            isRunning = false;
            // TODO: fix so the mini-game stops
        } else {
            // Change from ms to seconds
            pm.pantTimePassed += (double) delta/1000;
            // round to two decimals
            pm.pantTimePassed = (float) (Math.round(pm.pantTimePassed * 100.0) / 100.0);
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
                //System.out.println(pantGathered);
                if (totalPantOnScreen > 0) {
                    totalPantOnScreen--;
                    //System.out.println(totalPantOnScreen);
                } else {
                    totalPantOnScreen = 0;
                    //System.out.println(totalPantOnScreen);
                }
                pm.addPant();
                totalPantOnScreen++;
            }
        }
    }


    /** A timer for the pant if pant is gathered.
     * @param countPassed the pant-timer.
     */
    public void startTimer(int countPassed) {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    stopWatch.stop();
                    //System.out.println("New pant should appear!");
                } else {
                    //System.out.println("you have " + count + " seconds remaining");
                    count--;
                }
            }
        };
        stopWatch = new Timer(delay, action);
        stopWatch.setInitialDelay(0);
        stopWatch.start();
        count = countPassed;
    }
}
