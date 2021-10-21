package Items.Filled;

import Items.Item;
import model.MapStates.Karhuset;
import model.MapStates.Rannan;

import java.awt.*;

/**
 * @author Clara
 */
public class Rope extends Item {

    public Rope(){
        str = "data/material/rope.png";
        location = new Rectangle(350,350,32,32);
        currentMap = Karhuset.KARHUSET;//Rannan.RANNAN;
    }
}
