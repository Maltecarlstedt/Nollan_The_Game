package taskMiniGame;


import javafx.scene.image.Image;
import org.newdawn.slick.SlickException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GatheringPantModel {

    /**
     * GatheringPantModel should handle the logic behind the "task":
     *          - Keep track of score and time
     *          -
     *          -
     */

    public float pantTimePassed;

    ArrayList<Image> pants = new ArrayList<>(5);

    public void initPant() {
        for (int i = 0; i < pants.size(); i++) {
            pants.add(new Image("data/maps/images/pripps_pant.png"));
        }
    }

    public GatheringPantModel() throws SlickException {

    }

}
