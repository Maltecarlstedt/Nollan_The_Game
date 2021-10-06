package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map märkena.
 */
public enum Markena implements MapState{
    MARKENA;

    private String dPath = "data/maps/markena.tmx";

    @Override
    public MapState nextMap(Orientation orientation) throws SlickException {
        switch (orientation){
            case RIGHT:
                return Karhuset.KARHUSET;
            case LEFT:
                return Maskin.MASKIN;
            default:
                return Markena.MARKENA;
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
