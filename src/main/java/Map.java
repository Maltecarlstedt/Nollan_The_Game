import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;

/**
 * Have the information about which map the Player is in and where it should go next.
 */
public class Map {
    /**
     * MapState current knows which map the player is in.
     * TiledMap tiledMap makes it possible to show the map on the screen
     */
    private MapState current;
    public TiledMap tiledMap;

    /**
     * Sets the map to the MapState Kårhuset, which is the one the player will start in.
     */
    public Map(){
        current = Karhuset.KARHUSET;
    }

    /**
     * Loads the map for Kårhuset
     * @throws SlickException throws an exception if the file for the TiledMap is not found.
     */
    public void initMap() throws SlickException {tiledMap = current.loadMap();}

    /**
     * Sets the tiled map to the current state map.
     * @param current the current state
     */
    public void setTiledMap(MapState current){this.current = current;}

    /**
     *
     * @return the current state
     */
    public MapState getCurrentState(){return current;}

    /**
     * Checks if the player has gone outside the frame and should be moved to a new map
     * and the state would be updated.
     * @param player check if its ouside the frame.
     * @throws SlickException throws an exception if the file for the TiledMap is not found.
     */
    public void isOutside(Player player) throws SlickException {
        if (!player.checkBorder()) {
            current.nextState(this, player);
            //current.setPosition(player);
            tiledMap = current.loadMap();
        }
    }

    /**
     * Gets the orientation of the player to check in which direction
     * the player had walked outside the frame.
     * @param player gets the direction of the player
     * @return the direction of the player
     */
    public Orientation getPOrientation(Player player){
        return player.getOrientation();
    }
}
