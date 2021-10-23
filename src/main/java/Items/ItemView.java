package Items;


import model.MapModel;
import model.MapStates.MapState;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.Map;

/**
 * The class that render all items on the canvas
 *
 * @author Clara Simonsson
 */
public class ItemView {
    MapState currentMap;
    /**
     * Draws all the items that are not found yet. The item is a cut-out/frame of the item to be found
     * @param g - The graphics context to be used for rendering
     * @param im - the items
     * @throws SlickException - throws an exception if a filepath to the image or map is not found
     */
    public void renderUnfilledItems(Graphics g, ItemModel im) throws SlickException {
        for (Item item : im.getItemsUf().values()){
            Image img = new Image(item.filePathToItem);
            g.drawImage(img, item.location.x, item.location.y);
        }
    }

    /**
     * Draw all the items that are going to be found on the maps
     * @param g The graphics context to be used for rendering
     * @param im - the items
     * @param mm - the map
     * @throws SlickException - throws an exception if a filepath to the image or map is not found
     */
    public void renderItemsToFind(Graphics g, ItemModel im, MapModel mm) throws SlickException {
        currentMap = mm.getCurrentMap();
        for (Map.Entry<String, Item> material : im.getItemsToFind().entrySet()) {
            Item value = material.getValue();
            if (value.getMap().equals(currentMap) && (!mm.hasTask() || mm.taskDone)){
                Image img = new Image(value.filePathToItem);
                g.drawImage(img, value.location.x, value.location.y);
            }
        }
    }
}
