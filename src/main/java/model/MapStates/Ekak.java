package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Ekak.
 *
 * @author Clara
 */
public class Ekak extends TiledMapFactory implements MapState{
    public static final Ekak INSTANCE = new Ekak();
    private static final String DPATH = "data/maps/ekak.tmx";

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
