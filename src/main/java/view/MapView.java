package view;

import model.MapModel;

/**
 * A class that keeps the render methods for the map
 * @author Alexander
 */
public class MapView {

    /**
     * Renders the entire map, i.e every single layer of the tiled map
     * @param mapModel - the current map
     */
    public void render(MapModel mapModel){
        for(int i=0; i < mapModel.getTiledMap().getLayerCount() - mapModel.getCurrentTopLayers(); i++) {
            mapModel.getTiledMap().render(0, 0, i);
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
            mapModel.getTiledMap().render(0, 0, mapModel.getTiledMap().getLayerCount()- mapModel.getCurrentTopLayers() + (i));
        }
    }
}
