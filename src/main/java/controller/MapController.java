package controller;

import model.MapModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import view.MapView;

/**
 * Place holder for map
 * @author Clara Simonsson
 */
public class MapController {
    MapModel mapModel;
    MapView mapView;

    public MapController(MapModel mapModel, MapView mapView) {
        this.mapModel = mapModel;
        this.mapView = mapView;
    }

    public void update(GameContainer gc, int delta, MapModel mapModel) throws SlickException {
        if (mapModel.getCurrentMap() != mapModel.oldState){
            mapModel.oldState = mapModel.getCurrentMap();
            mapView.loadTiledMap(mapModel);
        }
    }
}
