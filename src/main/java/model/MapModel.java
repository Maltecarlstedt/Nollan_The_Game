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
    /** The width and height of every tile of the map */
    private final int tileWidth = 32, tileHeight = 32;
    /** The actual map in form of a TiledMap. makes us able to interact with specific tiles */
    private TiledMap tiledMap;
    /** Makes a concrete size for our tiles in the form of a rectangle */
    private Rectangle tile = new Rectangle(0,0,tileWidth,tileHeight);
    /** This will keep a list of Tiles that are blocked */
    private boolean blocked[][];
    /** For collision detection, we have a list of Rectangles that contains all the collisions of the map */
    private ArrayList<Rectangle> blocks = new ArrayList<>();

    public boolean taskDone = false;


    /**
     * The constructor that creates our map
     * @param collisionChecker - the collisionChecker that will make sure that the player cannot move to an obstructed tile
     * @throws SlickException - throws an exception if a filepath is not found
     */
    public MapModel(CollisionChecker collisionChecker) throws SlickException {
        initMap();
        collisionChecker.setCurrentMap(this);
    }

    /**
     * Initiates our first map, which is "Chalmersplatsen", sets up all the collisions of the map with tileSetup
     * @throws SlickException - throws an exception if a filepath is not found
     */
    private void initMap() throws SlickException {
        current = Chalmersplatsen.CHALMERSPLATSEN;
        tiledMap = current.loadMap();
        tileSetup();
    }

    public void setTiledMap(MapState current){ this.current = current;}

    public TiledMap getTiledMap(){
        return tiledMap;
    }

    /**
     * Changes the map
     * @throws SlickException - if the filepath to the next map is not found.
     */
    public void changeMap(PlayerModel playermodel) throws SlickException { //TODO: byta namn?
        current = current.nextMap(playermodel);
        tiledMap = current.loadMap();
        taskDone = false;
        tileSetup();
    }

    /**
     * Checks if there is a task on the map
     * @return true if the map has a task
     */
    public boolean hasTask(){
        return getCurrentMap().equals(Ekak.EKAK) || getCurrentMap().equals(DeltaP.DELTAP);
    }


    /**
     * The method that actually creates the collision tiles of the map
     * (may be some redundant code, the body of the method is taken from the internet.
     * Some slight changes made to adapt to our specific case)
     */
    private void tileSetup(){ //TODO: ta bort onödig kod i denna metod (till exempel value? sätta in direkt i blocked arrayen istället?)
        // This will create an Array with all the Tiles in your map. When set to true, it means that Tile is blocked.
        blocked = new boolean[tiledMap.getWidth()][tiledMap.getHeight()];
        //clear the arraylist of collision tiles everytime you change map
        //(otherwise it will be adding the collision layer from multiple maps)
        blocks.clear();

        // Loop through the Tiles and read their Properties
        for(int i = 0; i < tiledMap.getWidth(); i++) {
            for(int j = 0; j < tiledMap.getHeight(); j++) {

                String value;
                //Read the specific tile at place [i][j] in the array of the tiledmap

                //Read the tileID at place [i][j] from the collision layer of the tiled map.
                //each different type of tile have a specific tile ID.
                //If no tile is placed in this layer -> tileID = 0
                int tileID = tiledMap.getTileId(i, j, tiledMap.getLayerIndex("collision"));

                // Get the value of the Property named "blocked"
                if(tileID != 0){
                    value = "true";
                }else{
                    value = "false";
                }


                // If the tile is in the collision layer, then...
                if(value.equals("true")) {
                    // We set that index of the TileMap as blocked
                    blocked[i][j] = true;

                    //Create the specific collisions for tiles that behaves differently than a perfect square.
                    //E.G. tileID = 190 is the specific collision for a thin treetrunk
                    if(tileID == 190) {
                        blocks.add(new Rectangle((i * tile.width) + 25, ((j) * tile.height), 8, (int) tile.getHeight() - 28));
                    }else if(tileID == 191) {
                        blocks.add(new Rectangle((i * tile.width) + 16, ((j) * tile.height), 16, (int) tile.getHeight() - 28));
                    }else if(tileID == 192){
                        blocks.add(new Rectangle((i * tile.width), ((j) * tile.height), 8, (int) tile.getHeight() - 28));
                    }else{
                        blocks.add(new Rectangle((i * tile.width), ((j) * tile.height), (int) tile.getWidth(), (int) tile.getHeight()-28));
                    }
                }
            }
        }
    }

    public int getHeight(){
        return tiledMap.getHeight() * tiledMap.getTileHeight();
    }

    public int getWidth(){
        return tiledMap.getWidth() * tiledMap.getTileWidth();
    }

    public void setTiledMap(TiledMap tiledMap) {
        this.tiledMap = tiledMap;
    }

    public ArrayList<Rectangle> getBlocks() {
        return blocks;
    }

    public MapState getCurrentMap(){
        return current;
    }

    public int getCurrentTopLayers(){
        return current.getTopLayers();
    }


}