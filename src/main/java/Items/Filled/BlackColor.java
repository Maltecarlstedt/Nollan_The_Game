package Items.Filled;

import Items.Item;
import model.MapStates.DeltaP;
import model.MapStates.Karhuset;

import java.awt.*;

/**
 * @author Clara
 */
public class BlackColor extends Item {

    public BlackColor() {
        str = "data/material/black_color.png";
        location = new Rectangle(400, 400, 32, 32);
        currentMap = Karhuset.KARHUSET;//DeltaP.DELTAP;
    }
}
