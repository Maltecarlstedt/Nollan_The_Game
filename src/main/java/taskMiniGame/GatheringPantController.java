package taskMiniGame;

import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GatheringPantController implements ActionListener{

    /**
     * GatheringPantController should handle the input from the user:
     *          - user colliding with an pripps
     *          - coordinates of the pripps and the user
     */

    PlayerModel playerModel;

    private GatheringPantModel pantModel;
    private GatheringPantView pantView;

    public int totalPantOnScreen;
    public int pantGathered;
    private int pantX;
    private int pantY;

    public final int SCREEN_WIDTH = 600;
    public final int SCREEN_HEIGHT = 600;
    public final int UNIT_SIZE = 32;

    /**
     * The countdown timer
      */
    Timer stopWatch;
    int count = 0;
    int delay = 1000; // in milli-seconds


    Random random = new Random();
    Boolean isRunning = false;

    // Constructor
    public GatheringPantController (GatheringPantModel pantModel, GatheringPantView pantView) throws SlickException {
        this.pantModel = pantModel;
        this.pantView = pantView;
    }

    public void update(GameContainer gc, int delta) throws SlickException{
        pantTimer(delta);
        newPant();
        isRunning = true;
        startTimer(3);
        pantOnScreen();

    }

    // Create new pant on the screen to collect
    public void newPant() {
        pantX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE; // pant på en ruta som är 32x32
        pantY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE; // pant på en ruta som är 32x32
    }

    public void pantOnScreen() {
        if (count == 0) {
            newPant();
            startTimer(3);
            totalPantOnScreen++;
        }
    }

    // Check if player and pant is at the same coordinates, then gather a score and that pant should disappear
    public void checkPant() {
        if ((playerModel.getPlayerLocation().x == pantX) && (playerModel.getPlayerLocation().y == pantY)) {
            pantGathered++;
            totalPantOnScreen--;
        }
    }

    public void pantTimer(int delta) {
        if (totalPantOnScreen > 5) {
            stopWatch.stop();
            System.out.println("Bra samlat! Din tid blev: " + pantModel.pantTimePassed);
        } else {
            // Change from ms to seconds
            pantModel.pantTimePassed += (double) delta / 1000;
            // round to two decimals
            pantModel.pantTimePassed = (float) (Math.round(pantModel.pantTimePassed * 100) / 100);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (isRunning) {
            checkPant();
        } else {

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
