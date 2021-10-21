package Items.Filled;

import Items.Item;
import model.MapStates.Dammen;
import model.MapStates.Karhuset;

import java.awt.*;

/**
 * @author Clara
 */
public class Cardboard extends Item {

    public Cardboard(){
        str = "data/material/cardboard.png";
        location = new Rectangle(300,300,32,32);
        currentMap = Karhuset.KARHUSET;//Dammen.ADAMMEN;
    }
}
