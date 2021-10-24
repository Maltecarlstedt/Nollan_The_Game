package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates a class for one map piece which holds the specific methods for just that map.
 * This map is for the tile map Ekak.
 * @author Clara Simonsson
 */
public class Ekak extends TiledMapFactory implements MapState{
    public static final Ekak INSTANCE = new Ekak();
    private static final String DPATH = "data/maps/ekak.tmx";

    /**
     * Creates a tile map for Ekak
     */
    private Ekak(){ super(DPATH);}

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case RIGHT:
                playerModel.setNewPlayerTile(4, 440);
                return Rannan.INSTANCE;
            case LEFT:
                playerModel.setNewPlayerTile(956, 240);
                return Sandladan.INSTANCE;
            default:
                return Ekak.INSTANCE;

        }
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return getMap();
    }

    @Override
    public int getTopLayers(){
        return 1;
    }
}
