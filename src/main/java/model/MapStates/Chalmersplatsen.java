package model.MapStates;

import model.MapModel;
import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Chalmershållplatsen.
 */
public enum Chalmersplatsen implements MapState {
    CHALMERSPLATSEN;

    private String dPath = "data/maps/chalmershallplatsen.tmx";

    @Override
    public MapState nextMap(Orientation orientation) throws SlickException{
        switch (orientation){
            case UP:
                return Karhuset.KARHUSET;
            default:
                return Chalmersplatsen.CHALMERSPLATSEN;
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
}

