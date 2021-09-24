package controller;

import model.MapModel;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import view.MapView;
import view.PlayerView;

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
