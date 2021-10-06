package model.MapStates;

import model.MapModel;
import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Interface which holds the common methods for the different map enums.
 */
public interface MapState {

    /**
     * Decides the next map depending on the orientation of the player and the current map.
     * @param orientation the player's orientation
     * @return the next map
     * @throws SlickException - if the filepath to the next map is not found.
     */
    MapState nextMap(Orientation orientation) throws SlickException;

    /**
     * Sets the position in this map.
     * @param player possible to change its location. (old, will probably be deleted)
     */
    void setPosition(PlayerModel player);

    /**
     * Makes the right tiled map come in frame when it's supposed to be used.
     * @return the right tiled map for this state.
     * @throws SlickException throws an exception if the file for the TiledMap is not found.
     */
    TiledMap loadMap() throws SlickException;

    /**
     * @return the current MapState
     */
    MapState map();

    /**
     * The top layers are those layers that should be rendered after the player so that it looks like
     * the player is behind the object. Most of the maps only have 1 top layer, but some need 2 (might be even more)
     * to render everything properly.
     * @return the number of top layers
     */
    int getTopLayers();
}
