package Tasks.taskModel;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

import java.util.ArrayList;

/** Model of the task "Gathering pant".
 * @auther Steffanie Kristiansson
 */
public class GatheringPantModel {

    /** Represents time passed on pant-task.
     */
    public float pantTimePassed = 10;
    public float pantSpawnerTimer = 3;
    public Circle mouseBall;
    public Image timerBox;


    /** An ArrayList of all the pant.
     */
    ArrayList<Pant> pants = new ArrayList<>();


    /** Gets the list of all the pant.
     * @return An array-list of all the pant.
     */
    public ArrayList<Pant> getPants() {
        return pants;
    }


    public GatheringPantModel() throws SlickException {
        init();
        initTimerSetup();
    }

    /** Creates a new pant.
     * @throws SlickException if file not found, slick-exception.
     */
    public void addPant() throws SlickException {
        pants.add(new Pant());
    }


    /** Initiate the mouse-"ball"
     */
    public void init(){
        // the mouse with a circle and radius
        mouseBall = new Circle(0,0,10);

    }

    /**
     * Fetches the image for the box where the timer will be placed inside
     * @throws SlickException Generic exception
     */
    public void initTimerSetup() throws SlickException {
        timerBox = new Image("data/timerBox.png");
    }


    // TODO: create some kind of database (or such) to save the score for each completed task.
}
