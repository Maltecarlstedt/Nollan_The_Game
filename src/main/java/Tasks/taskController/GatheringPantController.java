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

public class GatheringPantController implements ActionListener{

    /**
     * GatheringPantController should handle the input from the user:
     *          - user colliding with an pripps
     *          - coordinates of the pripps and the user
     */

    public PlayerModel playerModel;

    private GatheringPantModel pantModel;
    private GatheringPantView pantView;
    private Pant burk;

    public int totalPantOnScreen;
    public int pantGathered;


    /**
     * The countdown timer
      */
    Timer stopWatch;
    int count = 0;
    int delay = 1000; // in milli-seconds

    Boolean isRunning = false;

    // Constructor
    public GatheringPantController (GatheringPantModel pantModel, GatheringPantView pantView) throws SlickException {
        this.pantModel = pantModel;
        this.pantView = pantView;
    }

    public void update(GameContainer gc, int delta) throws SlickException{
        isRunning = true;
        pantTimer(delta);
        pantOnScreen();
    }

    public void pantOnScreen() throws SlickException {
       if (count == 0) {   // if timer down on 0, create new pant
            pantModel.addPant();
            startTimer(10);
            totalPantOnScreen++;
        }
    }

    // Check if player and pant is at the same coordinates, then gather a score and that pant should disappear
    public void checkPant() throws SlickException {
        for(Pant pant : pantModel.getPants()) {
            if ((playerModel.getPlayerLocation().getX() == burk.getPantLocation().getX()) && (playerModel.getPlayerLocation().getY() == burk.getPantLocation().getY())) {
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
            //System.out.println(pantModel.pantTimePassed);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            //checkPant();
        }
    }

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
