package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map märkena.
 *
 * @author Clara
 */
public class Markena extends TiledMapFactory implements MapState{
    public static final Markena INSTANCE = new Markena();
    private static final String DPATH = "data/maps/markena.tmx";

    private Markena(){ super(DPATH);}

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case RIGHT:
                playerModel.setNewPlayerTile(180, 344);
                return Karhuset.INSTANCE;
            case LEFT:
                playerModel.setNewPlayerTile(956, 424);
                return Maskin.INSTANCE;
            case UP:
                playerModel.setNewPlayerTile(540, 700);
                return Rannan.INSTANCE;
            default:
                return Markena.INSTANCE;
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
