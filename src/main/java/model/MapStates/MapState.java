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
     * Decides which map that would come next depending on which direction the player goes out of frame.
     * @param input the current map state.
     * @param player to get the player´s direction and coordinates.
     */
    void nextState(MapModel input, PlayerModel player, int state) throws SlickException;

    TiledMap nextMap(Orientation orientation) throws SlickException;

    /**
     * Sets the position in this map.
     * @param player possible to change its location.
     */
    void setPosition(PlayerModel player);

    /**
     * Makes the right tiled map come in frame when it's supposed to be used.
     * @return the right tiled map for this state.
     * @throws SlickException throws an exception if the file for the TiledMap is not found.
     */
    TiledMap loadMap() throws SlickException;

    MapState map();
}
