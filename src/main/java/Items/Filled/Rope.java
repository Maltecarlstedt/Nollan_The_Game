package Items.Filled;

import Items.Item;
import model.MapStates.Ekak;
import model.MapStates.Karhuset;
import model.MapStates.MapState;
import model.MapStates.Rannan;

import java.awt.*;

/**
 * @author Clara
 */
public class Rope extends Item {

    public Rope(){
        filePathToItem = "data/material/rope.png";
        location = new Rectangle(350,350,32,32);
    }


    @Override
    public MapState getMap(){return Rannan.INSTANCE;}
}
