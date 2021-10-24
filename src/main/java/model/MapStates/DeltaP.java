package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *  Creates a class for one map piece which holds the specific methods for just that map.
 *  This map is for the tile map Delta parken.
 *  @author Clara Simonsson
 */
public class DeltaP extends TiledMapFactory implements MapState{
    public static final DeltaP INSTANCE = new DeltaP();
    private static final String DPATH = "data/maps/deltaP.tmx";

    /**
     * Creates a tile map for Delta parken
     */
    private DeltaP() {
        super(DPATH);
    }

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case DOWN:
                playerModel.setNewPlayerTile(600, 4);
                return Rannan.INSTANCE;
            case RIGHT:
                playerModel.setNewPlayerTile(4, 340);
                return Dammen.INSTANCE;
            case LEFT:
                playerModel.setNewPlayerTile(396, 4);
                playerModel.moveDown();
                return Sandladan.INSTANCE;
            default:
                return DeltaP.INSTANCE;
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
