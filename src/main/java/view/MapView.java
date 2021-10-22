package view;

import model.MapModel;
import model.MapStates.MapState;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * A class that keeps the render methods for the map
 * @author Alexander Brunnegård
 */
public class MapView{

    public TiledMap tiledMap;
    MapState currentState;

    public MapView(MapModel mapModel) throws SlickException {
        initMapView(mapModel);
    }

    public void initMapView(MapModel mapModel) throws SlickException {
        currentState = mapModel.getCurrentMap();
        loadTiledMap(mapModel);
        //mapModel.tileSetup(tiledMap);
    }

    public void loadTiledMap(MapModel mapModel) throws SlickException {
        tiledMap = mapModel.getCurrentMap().loadMap();
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
            tiledMap.render(0, 0, tiledMap.getLayerCount()- mapModel.getCurrentTopLayers() + (i));
        }
    }
}
