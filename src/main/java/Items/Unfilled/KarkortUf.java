package Items.Unfilled;

import Items.Item;

import java.awt.*;

/**
 * @author Clara
 */
public class KarkortUf extends Item {

    public KarkortUf(){
        filePathToItem = "data/material/karkortet_uf.png";
        location = new Rectangle(getStartX() + 50,getStartY(),32,32);
    }
}
