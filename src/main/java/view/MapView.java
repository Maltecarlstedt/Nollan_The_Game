package view;

import model.MapModel;
import model.MapStates.MapState;
import model.TileSetup;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * A class that keeps the render methods for the map
 * Uses: MapModel, TiledMap, MapState, ViewTranslator
 * Used by: MapController
 * @author Alexander Brunnegård
 * @co-author Clara Simonsson
 */
public class MapView{

    private TiledMap tiledMap;
    private MapState currentState;

    public MapView(MapModel mapModel) throws SlickException {
        initMapView(mapModel);
    }

    /**
     * Sets the first map of the MapView instance
     * @param mapModel - the MapModel.
     * @throws SlickException - if the tiledmap file is not found
     */
    private void initMapView(MapModel mapModel) throws SlickException {
        currentState = mapModel.getCurrentMap();
        loadTiledMap(mapModel);
    }

    /**
     * Loads the tiledMap of the current mapState via the mapModel.
     * Uses the viewTranslator the check which map to be loaded.
     * @param mapModel the map
     * @throws SlickException - throws an exception if a filepath to the image or map is not found
     */
    public void loadTiledMap(MapModel mapModel) throws SlickException {
        tiledMap = ViewTranslator.translateToView(mapModel.getCurrentMap());
        currentState = mapModel.getCurrentMap();
        TileSetup.setUpCollisionTiles(tiledMap);
    }

    /**
     * Renders the entire map except the toplayers
     * (those who are rendered after the player)
     * @param mapModel - the current map
     */
    public void render(MapModel mapModel){
        for(int i=0; i < tiledMap.getLayerCount() - mapModel.getCurrentTopLayers(); i++) {
            tiledMap.render(0, 0, i);
        }
    }

    /**
     * Renders only the top layers, which are the layers that should be rendered after the player, so that it looks like
     * the player is behind these layers. The for-loop makes it possible to have any number of top layers.
     * The top layer(s) is made so that it always has the highest layer ID.
     * @param mapModel - the current map
     */
    public void renderTopLayer(MapModel mapModel){
        for(int i=0; i < mapModel.getCurrentTopLayers(); i++){
            tiledMap.render(0, 0, tiledMap.getLayerCount() - currentState.getTopLayers() + (i));
        }
    }
}
