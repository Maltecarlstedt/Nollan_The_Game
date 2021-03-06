package controller;

import model.MapModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import view.MapView;

/**
 * Place holder for map
 * Uses: MapModel, MapView
 * Used by: MainGame
 * @author Clara Simonsson
 */
public class MapController {
    MapModel mapModel;
    MapView mapView;

    public MapController(MapModel mapModel, MapView mapView) {
        this.mapModel = mapModel;
        this.mapView = mapView;
    }

    public void update(MapModel mapModel) throws SlickException {
        if (mapModel.getCurrentMap() != mapModel.oldState){
            mapModel.oldState = mapModel.getCurrentMap();
            mapView.loadTiledMap(mapModel);
        }
    }
}
