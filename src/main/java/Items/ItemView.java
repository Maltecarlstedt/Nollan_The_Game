package Items;


import model.MapModel;
import model.MapStates.MapState;
import org.newdawn.slick.Graphics;

import java.util.Map;

/**
 * The class that render all items on the canvas
 *
 * @author Clara
 */
public class ItemView {
    MapState currentMap;
    /**
     * Draws all the items that are not found yet. The item is a cut-out/frame of the item to be found
     * @param g - The graphics context to be used for rendering
     * @param im - the items
     */
    public void renderUnfilledItems(Graphics g, ItemModel im) {
        for (Item item : im.getItemsUf().values()){
            item.render(g);
        }
    }

    /**
     * Draw all the items that are going to be found on the maps
     * @param g The graphics context to be used for rendering
     * @param im - the items
     * @param mm - the map
     */
    public void renderItemsToFind(Graphics g, ItemModel im, MapModel mm) {
        currentMap = mm.getCurrentMap();
        for (Map.Entry<String, Item> material : im.getItemsToFind().entrySet()) {
            Item value = material.getValue();
            if (value.getCurrentMap().equals(currentMap) && (!mm.hasTask() || mm.taskDone)){
                value.render(g);
            }
        }
    }
}
