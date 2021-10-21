package Items.Unfilled;

import Items.Item;

import java.awt.*;

/**
 * @author Clara
 */
public class CardboardUf extends Item{

    public CardboardUf(){
        str = "data/material/cardboard_uf.png";
        location = new Rectangle(getStartX() + 100,getStartY(),32,32);
    }
}
