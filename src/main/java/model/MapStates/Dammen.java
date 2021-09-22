package model.MapStates;

import model.MapModel;
import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public enum Dammen implements MapState{
    ADAMMEN;


    private String dPath = "data/maps/aDammen.tmx";

    @Override
    public void nextState(MapModel input, PlayerModel player, int state) throws SlickException {

    }

    @Override
    public TiledMap nextMap(Orientation orientation) throws SlickException {
        return null;
    }

    @Override
    public void setPosition(PlayerModel player) {

    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(dPath);
    }

    @Override
    public MapState map(){
        return this;
    }
}
