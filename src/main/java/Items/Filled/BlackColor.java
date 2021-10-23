package Items.Filled;

import Items.Item;
import model.MapStates.Karhuset;

import java.awt.*;

/**
 * @author Clara
 */
public class BlackColor extends Item {

    public BlackColor() {
        filePathToItem = "data/material/black_color.png";
        location = new Rectangle(400, 400, 32, 32);
        currentMap = Karhuset.INSTANCE;//DeltaP.DELTAP;
    }
}
