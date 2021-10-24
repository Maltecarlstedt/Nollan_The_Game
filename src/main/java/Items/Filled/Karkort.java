package Items.Filled;

import Items.Item;
import model.MapStates.Ekak;
import model.MapStates.Karhuset;
import model.MapStates.MapState;

import java.awt.*;

/**
 * @author Clara
 */
public class Karkort extends Item {

    public Karkort(){
        filePathToItem = "data/material/karkortet.png";
        location = new Rectangle(250,250,32,32);
    }


    @Override
    public MapState getMap(){return Karhuset.INSTANCE;}
}
