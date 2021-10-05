package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public enum Maskin implements MapState{
    MASKIN;

    private String dPath = "data/maps/maskin.tmx";

    @Override
    public MapState nextMap(Orientation orientation) throws SlickException {
        switch (orientation){
            case RIGHT:
                return Markena.MARKENA;
            case UP:
                return Sandladan.SANDLADAN;
            default:
                return Maskin.MASKIN;

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
