package model;

import controller.MapController;
import model.MapStates.Chalmersplatsen;
import org.lwjgl.Sys;
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
    private ArrayList<Integer> collisionLayer = new ArrayList<>();
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
        //System.out.println(tiledMap.toString());
    }

    public void setTiledMap(MapState current){ this.current = current;}

    public void updateCollisionLayer(){
        collisionLayer.clear();
        collisionLayer.add(tiledMap.getLayerIndex("collision"));
        int x = tiledMap.getLayerIndex("collision");



    }

    public TiledMap getTiledMap(){
        return tiledMap;
    }

    public void checkState(Orientation orientation) throws SlickException {
        current = current.nextMap(orientation);
        tiledMap = current.loadMap();
        updateCollisionLayer();
        tileSetup();
    }



    private void tileSetup(){
        // This will create an Array with all the Tiles in your map. When set to true, it means that Tile is blocked.
        blocked = new boolean[tiledMap.getWidth()][tiledMap.getHeight()];
        //clear the arraylist everytime you want to change map so
        blocks.clear();

        // Loop through the Tiles and read their Properties

        // Set here the Layer you want to Read. In your case, it'll be layer 1,
        // since the objects are on the second layer.
        for(int i = 0; i < tiledMap.getWidth(); i++) {
            for(int j = 0; j < tiledMap.getHeight(); j++) {

                String value;
                // Read the specific tile at place [i][j] in the array of the tiledmap
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

    public ArrayList<Integer> getCollisionLayer() {
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

    public int getCurrentTopLayers(){
        return current.getTopLayers();
    }


}