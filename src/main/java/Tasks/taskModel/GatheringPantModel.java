package Tasks.taskModel;


import Tasks.taskModel.Pant;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

/** Model of the task "Gathering pant".
 * @auther Steffanie Kristiansson
 */
public class GatheringPantModel {

    /** Represents time passed on pant-task.
     */
    public float pantTimePassed;


    /** An ArrayList of all the pant.
     */
    ArrayList<Pant> pants = new ArrayList<>();


    /** Gets the list of all the pant.
     * @return An array-list of all the pant.
     */
    public ArrayList<Pant> getPants() {
        return pants;
    }


    /** Creates a new pant.
     * @throws SlickException if file not found, slick-exception.
     */
    public void addPant() throws SlickException {
        pants.add(new Pant());
    }

    // TODO: create some kind of database (or such) to save the score for each completed task.
}
