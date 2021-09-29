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
    public TiledMap nextMap(Orientation orientation) throws SlickException {
        switch (orientation){
            case DOWN:
                return Karhuset.KARHUSET.loadMap();
            case UP:
                return Rannan.RANNAN.loadMap();

        }
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
