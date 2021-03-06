package Items;

import model.MapStates.MapState;

import java.awt.*;

/**
 * Abstract method that holds the common methods for the items
 * Used by: ItemModel
 * Uses: MapState
 * @author Clara Simonsson
 */
public abstract class Item {
    /**
     * The variables that are needed to get an item connected to a map
     * and to get the specific item
     */
    public MapState map;
    public Rectangle location;
    /**
     * To separate the different file paths of the items.
     * It will be used to find the right image in the view.
     */
    public String filePathToItem;

    /**
     * Gets the map that the player is on now
     * @return a specific map
     */
    public MapState getMap(){ return map;}

    /**
     * Gets the start index for the x-position for the items that are unfilled and needs to be collected
     * @return the x-position
     */
    public int getStartX(){ return 20;}

    /**
     * Gets the y-position for the items that are unfilled and needs to be collected
     * @return the y-position
     */
    public int getStartY(){ return 20;}

}
