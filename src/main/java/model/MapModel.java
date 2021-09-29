package model;

import controller.MapController;
import model.MapStates.Chalmersplatsen;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;
import model.MapStates.Karhuset;
import model.MapStates.MapState;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;


// TODO:: TA REDA PÅ IFALL VI VILL EXTENDA TILED MAPS??
public class MapModel{
    private MapState current;
    private final int tileWidth = 32, tileHeight = 32;
    private TiledMap tiledMap;
    private int collisionLayer;
    private Rectangle tile = new Rectangle(0,0,tileWidth,tileHeight);
    private CollisionChecker collisionChecker;
    // This will keep a list of Tiles that are blocked
    private boolean blocked[][];

    // For collision detection, we have a list of Rectangles you can use to test against
    private ArrayList<Rectangle> blocks = new ArrayList<>();

    public MapModel() throws SlickException {
        initMap();
    }

    public MapModel(CollisionChecker collisionChecker) throws SlickException {
        initMap();
        this.collisionChecker = collisionChecker;
        collisionChecker.setCurrentMap(this);
    }

    private void initMap() throws SlickException {
        current = Karhuset.KARHUSET;
        tiledMap = current.loadMap();
        updateCollisionLayer();
        tileSetup();
    }

    public void setTiledMap(MapState current){ this.current = current;}

    public void updateCollisionLayer(){
        collisionLayer = tiledMap.getLayerIndex("collision");

    }

    public TiledMap getTiledMap(){
        return tiledMap;
    }

    public void checkState(Orientation orientation) throws SlickException {
        System.out.println(current.toString());
        System.out.println(orientation);
        tiledMap = current.nextMap(orientation);
        updateCollisionLayer();
        tileSetup();
    }

    private void tileSetup(){
        // This will create an Array with all the Tiles in your map. When set to true, it means that Tile is blocked.
        blocked = new boolean[this.getWidth()][this.getHeight()];


        int x = 0;

       // System.out.println(tiledMap.getHeight());

        // Loop through the Tiles and read their Properties

        // Set here the Layer you want to Read. In your case, it'll be layer 1,
        // since the objects are on the second layer.
        int layer = 1;
        for(int i = 0; i < tiledMap.getWidth(); i++) {
            for(int j = 0; j < tiledMap.getHeight(); j++) {

                String value;


                // Read a Tile
                int tileID = tiledMap.getTileId(i, j, collisionLayer);

               // System.out.println(tileID);

                // Get the value of the Property named "blocked"
                if(tileID != 0){
                    value = "true";
                }else{
                    value = "false";
                }
                //String value = tiledMap.getTileProperty(tileID, "collision", "false");


                // If the value of the Property is "true"...
                if(value.equals("true")) {

                   // System.out.println(x++);

                    // We set that index of the TileMap as blocked
                    blocked[i][j] = true;

                    // And create the collision Rectangle
                    blocks.add(new Rectangle((i * tile.width), (j * tile.height), (int)tile.getWidth(), (int)tile.getHeight()));


                    //System.out.println(blocks);
                }
            }
        }
        for(Rectangle block : blocks){
           // System.out.println(block.x + ", " + block.y);
        }
    }

    public int getHeight(){
        return tiledMap.getHeight() * tiledMap.getTileHeight();
    }

    public int getWidth(){
        return tiledMap.getWidth() * tiledMap.getTileWidth();
    }

    public int getCollisionLayer() {
        return collisionLayer;
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



}