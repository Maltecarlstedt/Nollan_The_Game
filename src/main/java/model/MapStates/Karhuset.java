package model.MapStates;

import model.MapModel;
import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Kårhuset.
 */
public enum Karhuset implements MapState{
    KARHUSET;

    @Override
    public void setPosition(PlayerModel player) {

    }

    @Override
    public TiledMap nextMap(Orientation orientation) throws SlickException {

        switch (orientation){
            case DOWN:
                return Chalmersplatsen.CHALMERSPLATSEN.loadMap();
            case UP:
                return Dammen.ADAMMEN.loadMap();
            case LEFT:
                return Markena.MARKENA.loadMap();
        }
        return null;
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap("data/maps/karhuset.tmx");
    }

    @Override
    public MapState map(){
        return this;
    }
}
