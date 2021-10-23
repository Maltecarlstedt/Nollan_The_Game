package Items.Filled;

import Items.Item;
import model.MapStates.Karhuset;
import model.MapStates.Maskin;

import java.awt.*;

/**
 * @author Clara
 */
public class TurquoiseColor extends Item {

    public TurquoiseColor(){
        filePathToItem = "data/material/turqoise_color.png";
        location = new Rectangle(450,450,32,32);
        currentMap = Maskin.INSTANCE;
    }
}
