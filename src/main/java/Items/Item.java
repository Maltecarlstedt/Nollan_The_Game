package Items;

import model.MapStates.MapState;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.*;

/**
 * Abstract method that holds the common methods for the items
 *
 * @author Clara Simonsson
 */
public abstract class Item {
    /**
     * The variables that are needed to get an item connected to a map
     * and to get the specific item
     */
    public boolean isShowing;
    public MapState currentMap;
    public Rectangle location;
    public Image img;

    /**
     * Draws the item on the canvas
     * @param g - The grapchic context to be used for rendering
     */
    public abstract void render(Graphics g);

    /**
     * Gets the map that the player is on now
     * @return a specific map
     */
    MapState getCurrentMap(){return currentMap;}

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
