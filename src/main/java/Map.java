import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;

public class Map {

    private TiledMap tiledMap;
    private int mapState;
    int collisionLayer;
    private Rectangle tile = new Rectangle(0,0,32,32);



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
     * Loads the map for Kårhuset
     * @throws SlickException throws an exception if the file for the TiledMap is not found.
     */
    public void initMap() throws SlickException {
        tiledMap = current.loadMap();
        mapState = 0;
        //tiledMap = new TiledMap("data/maps/chalmershallplatsen.tmx");

        tiledMap.getWidth();
        collisionLayer = tiledMap.getLayerIndex("collision");
    }

    /**
     * Sets the map to the MapState Kårhuset, which is the one the player will start in.
     */
    public Map(){
        current = Karhuset.KARHUSET;

    }


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

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public boolean colliding(Player player) {
        try{
            return topLeft(player) && topRight(player)
                    && bottomRight(player) && bottomLeft(player);
        }catch (IndexOutOfBoundsException e){ //ny map här i think?
            return false;
        }
    }

    private boolean topLeft(Player player){
            return tiledMap.getTileId( player.newX() / tiledMap.getTileWidth(),
                player.newY() / tiledMap.getTileHeight(), collisionLayer) == 0;
    }

    private boolean bottomRight(Player player){
        return tiledMap.getTileId((player.newX() + player.getWidth()) / tiledMap.getTileWidth(),
                (player.newY()) / tiledMap.getTileHeight(), collisionLayer) == 0;
    }

    private boolean bottomLeft(Player player){
        return tiledMap.getTileId(player.newX()/ tiledMap.getTileWidth(),
                (player.newY() + player.getHeight()) / tiledMap.getTileHeight(), collisionLayer) == 0;
    }

    private boolean topRight(Player player){
        return tiledMap.getTileId((player.newX() + player.getWidth()) / tiledMap.getTileWidth(),
                (player.newY() + player.getHeight()) / tiledMap.getTileHeight(), collisionLayer) == 0;
    }

    public int getHeight(){
        return tiledMap.getHeight() * tiledMap.getTileHeight();
    }

    public int getWidth(){
        return tiledMap.getWidth() * tiledMap.getTileWidth();
    }

}
