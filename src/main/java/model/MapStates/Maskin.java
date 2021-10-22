package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Maskin.
 *
 * @author Clara
 */
public class Maskin extends TiledMapFactory implements MapState{
    public static final Maskin INSTANCE = new Maskin();
    private static final String DPATH = "data/maps/maskin.tmx";

    private Maskin(){ super(DPATH);}

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case RIGHT:
                playerModel.setNewPlayerTile(4, 364);
                return Markena.INSTANCE;
            case UP:
                playerModel.setNewPlayerTile(360, 700);
                return Sandladan.INSTANCE;
            default:
                return Maskin.INSTANCE;

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
