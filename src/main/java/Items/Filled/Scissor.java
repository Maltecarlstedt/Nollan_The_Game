package Items.Filled;

import Items.Item;
import model.MapStates.Ekak;
import model.MapStates.Karhuset;
import model.MapStates.MapState;

import java.awt.*;

/**
 * @author Clara
 */
public class Scissor extends Item {

    public Scissor(){
        filePathToItem = "data/material/scissor.png";
        location = new Rectangle(400,400,32,32);
    }

    @Override
    public MapState getMap(){return Ekak.INSTANCE;}

}
