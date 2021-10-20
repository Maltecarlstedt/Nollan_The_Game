package controller;

import model.MapModel;
import org.newdawn.slick.GameContainer;
import view.MapView;

/**
 * Place holder for map
 * @author Clara
 */
public class MapController {
    MapModel mapModel;
    MapView mapView;

    public MapController(MapModel mapModel, MapView mapView) {
        this.mapModel = mapModel;
        this.mapView = mapView;
    }

    public void update(GameContainer gc, int delta){

    }



}
