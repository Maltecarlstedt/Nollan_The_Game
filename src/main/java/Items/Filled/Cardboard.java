package Items.Filled;

import Items.Item;
import model.MapStates.Dammen;
import model.MapStates.Ekak;
import model.MapStates.MapState;

import java.awt.*;

/**
 * @author Clara
 */
public class Cardboard extends Item {

    public Cardboard(){
        filePathToItem = "data/material/cardboard.png";
        location = new Rectangle(300,300,32,32);
    }


    @Override
    public MapState getMap(){return Dammen.INSTANCE;}
}
