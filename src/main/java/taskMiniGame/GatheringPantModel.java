package taskMiniGame;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class GatheringPantModel {

    /**
     * GatheringPantModel should handle the logic behind the "task":
     *          - Keep track of score and time
     *          -
     *          -
     */

    public float pantTimePassed;

    ArrayList<Pant> pants = new ArrayList<>();


    public ArrayList<Pant> getPants() {
        return pants;
    }

    public void addPant() throws SlickException {
        pants.add(new Pant());
    }
}
