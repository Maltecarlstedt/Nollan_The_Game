package Items.Unfilled;

import Items.Item;

import java.awt.*;

/**
 * @author Clara
 */
public class BlackColorUf extends Item {

    public BlackColorUf(){
        str = "data/material/black_color_uf.png";
        location = new Rectangle(getStartX() + 200,getStartY(),32,32);
    }
}
