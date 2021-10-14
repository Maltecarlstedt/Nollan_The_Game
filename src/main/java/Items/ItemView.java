package Items;


import model.MapModel;
import model.MapStates.MapState;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.*;
import java.util.Map;

public class ItemView {

    public MapState currentMap;

    public void renderUnfilledItems(Graphics g, ItemModel mm) {
        for (Item item : mm.getItemsUf().values()){
            item.render(g);
        }
    }

    public void renderItemsToFind(Graphics g, ItemModel im, MapModel mm) {
        currentMap = mm.getCurrentMap();
        for (Map.Entry<String, Item> material : im.getItemsToFind().entrySet()) {
            Item value = material.getValue();
            if (value.getCurrentMap().equals(currentMap) && !mm.hasTask()){
                value.render(g);
            }
        }
    }

}
