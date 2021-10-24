package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Interface which holds the common methods for the different map classes.
 * Used by: All MapState classes
 * All the MapState classes are used by MapModel, ItemView, NPC and textBoxes
 * @author Clara Simonsson & Alexander Brunnegård
 */
public interface MapState {

    /**
     * Decides the next map depending on the orientation of the player and the current map.
     * @param playerModel the player's orientation
     * @return the next map
     */
    MapState nextMap(PlayerModel playerModel);

    /**
     * Makes the right tiled map come in frame when it's supposed to be used.
     * @return the right tiled map for this state.
     * @throws SlickException throws an exception if the file for the TiledMap is not found.
     */
    TiledMap loadMap() throws SlickException;

    /**
     * The top layers are those layers that should be rendered after the player so that it looks like
     * the player is behind the object. Most of the maps only have 1 top layer, but some need 2 (might be even more)
     * to render everything properly.
     * @return the number of top layers
     */
    int getTopLayers();
}
