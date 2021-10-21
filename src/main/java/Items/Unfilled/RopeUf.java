package Items.Unfilled;

import Items.Item;

import java.awt.*;

/**
 * @author Clara
 */
public class RopeUf extends Item {

    public RopeUf(){
        str = "data/material/rope_uf.png";
        location = new Rectangle(getStartX() + 150,getStartY(),32,32);
    }
}
