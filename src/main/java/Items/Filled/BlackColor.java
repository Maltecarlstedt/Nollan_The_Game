package Items.Filled;

import Items.Item;
import model.MapStates.DeltaP;
import model.MapStates.Ekak;
import model.MapStates.MapState;

import java.awt.*;

/**
 * @author Clara
 */
public class BlackColor extends Item {

    public BlackColor() {
        filePathToItem = "data/material/black_color.png";
        location = new Rectangle(400, 400, 32, 32);
    }

    @Override
    public MapState getMap(){return DeltaP.INSTANCE;}
}
