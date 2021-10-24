package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates a class for one map piece which holds the specific methods for just that map.
 * This map is for the tile map Rännan.
 * @author Clara Simonsson
 */
public class Rannan extends TiledMapFactory implements MapState{
    public static final Rannan INSTANCE = new Rannan();
    private static final String DPATH = "data/maps/rannan.tmx";

    /**
     * Creates a tile map for Rännan
     */
    private Rannan(){ super(DPATH);}

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case DOWN:
                playerModel.setNewPlayerTile(60, 4);
                return Markena.INSTANCE;
            case UP:
                playerModel.setNewPlayerTile(940, 700);
                return DeltaP.INSTANCE;
            case LEFT:
                playerModel.setNewPlayerTile(956, 360);
                return Ekak.INSTANCE;
            default:
                return Rannan.INSTANCE;
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
