package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public enum Ekak implements MapState{
    EKAK;

    private final int topLayers = 1;
    private String dPath = "data/maps/ekak.tmx";

    @Override
    public MapState nextMap(Orientation orientation) throws SlickException {
        switch (orientation){
            case RIGHT:
                return Rannan.RANNAN;
            case LEFT:
                return Sandladan.SANDLADAN;
            default:
                return Ekak.EKAK;

        }
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

    @Override
    public int getTopLayers(){
        return 1;
    }
}
