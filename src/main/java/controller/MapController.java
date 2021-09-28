package controller;

import model.MapModel;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import view.MapView;
import view.PlayerView;

public class MapController {
    MapModel mapModel;
    MapView mapView;

    public MapController(MapModel mapModel, MapView mapView) {
        this.mapModel = mapModel;
        this.mapView = mapView;
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        /*
        if (mapModel.mapChanged()){
            sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
        }

         */

    }



}
