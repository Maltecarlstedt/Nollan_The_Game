package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


/**
 *  Creates a class for one map piece which holds the specific methods for just that map.
 *  This map is for the tile map Kårhuset.
 *  @author Clara Simonsson
 */
public class Karhuset extends TiledMapFactory implements MapState{
    public static final Karhuset INSTANCE = new Karhuset();
    private static final String DPATH = "data/maps/karhuset.tmx";

    /**
     * Creates a tile map for Kårhuset
     */
    private Karhuset(){ super(DPATH);}

    @Override
    public MapState nextMap(PlayerModel playerModel){

        switch (playerModel.getOrientation()){
            case DOWN:
                playerModel.setNewPlayerTile(200, 50);
                return Chalmersplatsen.INSTANCE;
            case UP:
                playerModel.setNewPlayerTile(220, 700);
                return Dammen.INSTANCE;
            case LEFT:
                playerModel.setNewPlayerTile(956, 360);
                return Markena.INSTANCE;
            default:
                return Karhuset.INSTANCE;
        }
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return getMap();
    }

    @Override
    public int getTopLayers(){
        return 2;
    }
}
