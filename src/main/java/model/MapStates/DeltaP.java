package model.MapStates;

import model.MapModel;
import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map deltaP.
 */
public enum DeltaP implements MapState{
    DELTAP;

    private String dPath = "data/maps/deltaP.tmx";

    @Override
    public MapState nextMap(Orientation orientation) throws SlickException {
        switch (orientation){
            case DOWN:
                return Rannan.RANNAN;
            default:
                return DeltaP.DELTAP;
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
