package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public enum Ekak implements MapState{
    EKAK;

    private String dPath = "data/maps/ekak.tmx";

    @Override
    public TiledMap nextMap(Orientation orientation) throws SlickException {
        switch (orientation){
            case RIGHT:
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
