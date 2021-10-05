package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public enum Sandladan implements MapState{
    SANDLADAN;

    private String dPath = "data/maps/sandladan.tmx";

    @Override
    public MapState nextMap(Orientation orientation) throws SlickException {
        switch (orientation){
            case RIGHT:
                return Ekak.EKAK;
            case DOWN:
                return Maskin.MASKIN;

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
