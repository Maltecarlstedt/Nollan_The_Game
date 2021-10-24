package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates a class for one map piece which holds the specific methods for just that map.
 *  * This map is for the tile map A-dammen.
 *  * @author Clara Simonsson
 */
public class Dammen extends TiledMapFactory implements MapState{
    public static final Dammen INSTANCE = new Dammen();
    private static final String DPATH = "data/maps/aDammen.tmx";

    /**
     * Creates a tile map for A-dammen
     */
    private Dammen() {
        super(DPATH);
    }

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case DOWN:
                playerModel.setNewPlayerTile(360, 4);
                return Karhuset.INSTANCE;
            case UP:
                playerModel.setNewPlayerTile(900, 90);
                playerModel.moveDown();
                return DeltaP.INSTANCE;
            case LEFT:
                playerModel.setNewPlayerTile(956, 460);
                return DeltaP.INSTANCE;
            default:
                return Dammen.INSTANCE;

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
