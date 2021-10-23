package Items.Filled;

import Items.Item;
import model.MapStates.Karhuset;

import java.awt.*;

/**
 * @author Clara
 */
public class Rope extends Item {

    public Rope(){
        filePathToItem = "data/material/rope.png";
        location = new Rectangle(350,350,32,32);
        currentMap = Karhuset.INSTANCE;//Rannan.RANNAN;
    }
}
