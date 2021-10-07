package Tasks.taskController;

import Tasks.taskModel.Pant;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import Tasks.taskModel.GatheringPantModel;
import Tasks.taskView.GatheringPantView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** Controls the task "Gathering pant".
 * @auther Steffanie Kristiansson
 */
public class GatheringPantController implements ActionListener{

    public PlayerModel playerModel;

    private GatheringPantModel pantModel;
    private GatheringPantView pantView;

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
    Boolean isRunning = false;


    /** The Controllers constructor, taking in the model and view to be able to use them.
     * @param pantModel representing the model to get data from the it.
     * @param pantView representing the view to be able to draw.
     * @throws SlickException if file not found, slick-exception.
     */
    public GatheringPantController (GatheringPantModel pantModel, GatheringPantView pantView) throws SlickException {
        this.pantModel = pantModel;
        this.pantView = pantView;
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
    }


    /** Check if there is pant on the screen, if not, create another one.
     * @throws SlickException if file not found, slick-exception.
     */
    public void pantOnScreen() throws SlickException {
       if (count == 0) {   // if timer down on 0, create new pant
            pantModel.addPant();
            startTimer(10);
            totalPantOnScreen++;
        }
    }


    // TODO: Fix the collision between the player and the pant.
    /** Check if pant and player are at the same point, if so, gather the pant and remove it,
     *  gives point and generate a new pant (not working and under develop).
     * @throws SlickException if file not found, slick-exception.
     */
    public void checkPant() throws SlickException {
        for(Pant pant : pantModel.getPants()) {
            if ((playerModel.getPlayerLocation().getX() == pant.getPantLocation().getX()) && (playerModel.getPlayerLocation().getY() == pant.getPantLocation().getY())) {
                pantGathered++;
                if (totalPantOnScreen >= 0) {
                    totalPantOnScreen--;
                } else {
                    totalPantOnScreen = 0;
                }
                pantModel.addPant();
            }
        }
    }


    /** If there is five pant on screen, it is game over, the time and amount pant gathered is shown.
     *  Else continue the time counting.
     * @param delta represents time in ms since last update.
     */
    public void pantTimer(int delta) {

        if (totalPantOnScreen > 5) {
            //stopWatch.stop();
            System.out.println("Bra samlat! " + pantGathered + " st!!");
            System.out.println("Din tid blev: " + pantModel.pantTimePassed);
        } else {
            // Change from ms to seconds
            pantModel.pantTimePassed += (double) delta/1000;
            // round to two decimals
            pantModel.pantTimePassed = (float) (Math.round(pantModel.pantTimePassed * 100.0) / 100.0);
        }
    }


    /** If action caused by the player, then check the pant (under development).
     * @param e the event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            //checkPant();
        }
    }


    /** A timer for the pant.
     * @param countPassed the pant-timer.
     */
    public void startTimer(int countPassed) {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    stopWatch.stop();
                    System.out.println("New pant should appear!");
                } else {
                    System.out.println("you have " + count + " seconds remaining");
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
