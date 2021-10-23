package model;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;
import java.util.ArrayList;

public class TileSetup {
    /** For collision detection, we have a list of Rectangles that contains all the collisions of the map */
    private static ArrayList<Rectangle> blocks = new ArrayList<>();
    /** Constants for the ID of the collision tiles */
    private static final int THIN_TREE_TRUNK_ID = 190, HALF_RIGHT_COLLISION_ID = 191,
            HALF_LEFT_COLLISION_ID = 192;

    /** The width and height of every tile of the map */
    private static final int tileWidth = 32, tileHeight = 32;



    /**
     * The method that actually creates the collision tiles of the map
     * (may be some redundant code, the body of the method is taken from the internet.
     * Some slight changes made to adapt to our specific case)
     */
    public static void tileSetup(TiledMap tiledMap) {
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
                    //Create the specific collisions for tiles that behaves differently than a perfect square.
                    //E.G. tileID = 190 is the specific collision for a thin treetrunk
                    if(tileID == THIN_TREE_TRUNK_ID) {
                        blocks.add(new Rectangle((i * tileWidth) + 25, ((j) * tileHeight), 8, tileHeight - 28));
                    }else if(tileID == HALF_RIGHT_COLLISION_ID) {
                        blocks.add(new Rectangle((i * tileWidth) + 16, ((j) * tileHeight), 16, tileHeight - 28));
                    }else if(tileID == HALF_LEFT_COLLISION_ID){
                        blocks.add(new Rectangle((i * tileWidth), ((j) * tileHeight), 8, tileHeight - 28));
                    }else{
                        blocks.add(new Rectangle((i * tileWidth), ((j) * tileHeight), tileWidth, tileHeight-28));
                    }
                }
            }
        }
        CollisionChecker.setCollisionTiles(blocks);
    }

}
