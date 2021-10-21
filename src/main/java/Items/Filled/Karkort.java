package Items.Filled;

import Items.Item;
import model.MapStates.Karhuset;

import java.awt.*;

/**
 * @author Clara
 */
public class Karkort extends Item {

    public Karkort(){
        str = "data/material/karkortet.png";
        location = new Rectangle(250,250,32,32);
        currentMap = Karhuset.KARHUSET;
    }
}
