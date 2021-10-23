package Items.Filled;

import Items.Item;
import model.MapStates.Ekak;
import model.MapStates.Karhuset;

import java.awt.*;

/**
 * @author Clara
 */
public class Scissor extends Item {

    public Scissor(){
        filePathToItem = "data/material/scissor.png";
        location = new Rectangle(400,200,32,32);
        currentMap = Ekak.INSTANCE;
    }


}
