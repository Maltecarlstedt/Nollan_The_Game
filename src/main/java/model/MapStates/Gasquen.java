package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *  Creates a class for one map piece which holds the specific methods for just that map.
 *  This map is for the tile map Gasquen.
 *  @author Clara Simonsson
 */
public class Gasquen extends TiledMapFactory implements MapState{
    public static final Gasquen INSTANCE = new Gasquen();
    private static final String DPATH = "data/maps/gasquen.tmx";

    /**
     * Creates a tile map for Gasquen
     */
    private Gasquen() {
        super(DPATH);
    }

    @Override
    public MapState nextMap(PlayerModel playerModel){
        return Gasquen.INSTANCE;
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return getMap();
    }

    @Override
    public int getTopLayers(){
        return 0;
    }
}
