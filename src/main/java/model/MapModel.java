package model;

import model.MapStates.*;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;
import java.util.ArrayList;


// TODO:: TA REDA PÅ IFALL VI VILL EXTENDA TILED MAPS??

/**
 * @author Clara Simonsson
 * @author Alexander Brunnegård
 * Holds all the information for the map
 */
public class MapModel{
    /** The current map in the form of a MapState (interface) */
    private MapState current;
    public MapState oldState;

    /** The width and height of every tile of the map */
    private static final int tileWidth = 32, tileHeight = 32;
    /** This will keep a list of Tiles that are blocked */
    private boolean blocked[][];
    /** For collision detection, we have a list of Rectangles that contains all the collisions of the map */
    private ArrayList<Rectangle> blocks = new ArrayList<>();

    public boolean taskDone = false;


    /**
     * The constructor that creates our map
     * @param collisionChecker - the collisionChecker that will make sure that the player cannot move to an obstructed tile
     */
    public MapModel(CollisionChecker collisionChecker){
        initMap();
        collisionChecker.setCurrentMap(this);
    }

    /**
     * Initiates our first map, which is "Chalmersplatsen", sets up all the collisions of the map with tileSetup
     */
    private void initMap(){
        current = Chalmersplatsen.INSTANCE;
        oldState = getCurrentMap();
    }

    public MapState getCurrentMap(){ return current; }

    public void setCurrentMap(MapState current){ this.current = current; }

    /*
    public TiledMap getTiledMap(){
        return tiledMap;
    }

    public void setTiledMap(TiledMap tiledMap) { this.tiledMap = tiledMap; }

     */

    /**
     * Changes the map
     */
    public void changeMap(PlayerModel playermodel){
        oldState = getCurrentMap();
        current = current.nextMap(playermodel);
        //tiledMap = current.loadMap();
        taskDone = false;
        //tileSetup();
    }

    /**
     * Checks if there is a task on the map
     * @return true if the map has a task
     */
    public boolean hasTask(){
        return getCurrentMap().equals(Ekak.INSTANCE) || getCurrentMap().equals(DeltaP.INSTANCE);
    }

    /**
     * The method that actually creates the collision tiles of the map
     * (may be some redundant code, the body of the method is taken from the internet.
     * Some slight changes made to adapt to our specific case)
     */
    public void tileSetup() throws SlickException { //TODO: ta bort onödig kod i denna metod (till exempel value? sätta in direkt i blocked arrayen istället?)
        TiledMap tiledMap = current.loadMap();
        // This will create an Array with all the Tiles in your map. When set to true, it means that Tile is blocked.
        blocked = new boolean[tiledMap.getWidth()][tiledMap.getHeight()];
        //clear the arraylist of collision tiles everytime you change map
        //(otherwise it will be adding the collision layer from multiple maps)
        blocks.clear();

        // Loop through the Tiles and read their Properties
        for(int i = 0; i < tiledMap.getWidth(); i++) {
            for(int j = 0; j < tiledMap.getHeight(); j++) {

                boolean isCollision;
                //Read the specific tile at place [i][j] in the array of the tiledmap

                //Read the tileID at place [i][j] from the collision layer of the tiled map.
                //each different type of tile have a specific tile ID.
                //If no tile is placed in this layer -> tileID = 0

                int tileID = tiledMap.getTileId(i, j, tiledMap.getLayerIndex("collision"));

                // Get the value of the Property named "blocked"
                if(tileID != 0){
                    isCollision = true;
                }else{
                    isCollision = false;
                }


                // If the tile is in the collision layer, then...
                if(isCollision) {
                    // We set that index of the TileMap as blocked
                    blocked[i][j] = true;

                    //Create the specific collisions for tiles that behaves differently than a perfect square.
                    //E.G. tileID = 190 is the specific collision for a thin treetrunk
                    if(tileID == 190) {
                        blocks.add(new Rectangle((i * tileWidth) + 25, ((j) * tileHeight), 8, tileHeight - 28));
                    }else if(tileID == 191) {
                        blocks.add(new Rectangle((i * tileWidth) + 16, ((j) * tileHeight), 16, tileHeight - 28));
                    }else if(tileID == 192){
                        blocks.add(new Rectangle((i * tileWidth), ((j) * tileHeight), 8, tileHeight - 28));
                    }else{
                        blocks.add(new Rectangle((i * tileWidth), ((j) * tileHeight), tileWidth, tileHeight-28));
                    }
                }
            }
        }
    }


    /*
    public int getHeight(){
        return tiledMap.getHeight() * tiledMap.getTileHeight();
    }

    public int getWidth(){
        return tiledMap.getWidth() * tiledMap.getTileWidth();
    }

     */

    public ArrayList<Rectangle> getBlocks() {
        return blocks;
    }

    public int getCurrentTopLayers(){
        return current.getTopLayers();
    }


}