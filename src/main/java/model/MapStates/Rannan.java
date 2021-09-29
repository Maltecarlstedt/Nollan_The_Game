package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public enum Rannan implements MapState{
    RANNAN;

    private String dPath = "data/maps/rannan.tmx";

    @Override
    public TiledMap nextMap(Orientation orientation) throws SlickException {
        switch (orientation){
            case DOWN:
                return Dammen.ADAMMEN.loadMap();
            case UP:
                return DeltaP.DELTAP.loadMap();
            case LEFT:
                return Ekak.EKAK.loadMap();
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
