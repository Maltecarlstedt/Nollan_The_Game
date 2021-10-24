package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates a class for one map piece which holds the specific methods for just that map.
 * This map is for the tile map Sandlådan.
 * @author Clara Simonsson
 */
public class Sandladan extends TiledMapFactory implements MapState{
    public static final Sandladan INSTANCE = new Sandladan();
    private static final String DPATH = "data/maps/sandladan.tmx";

    /**
     * Creates a tile map for sandlådan
     */
    private Sandladan(){ super(DPATH);}

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case RIGHT:
                playerModel.setNewPlayerTile(4, 360);
                return Ekak.INSTANCE;
            case DOWN:
                playerModel.setNewPlayerTile(300, 4);
                return Maskin.INSTANCE;
            case UP:
                playerModel.setNewPlayerTile(4, 580);
                playerModel.moveRight();
                return DeltaP.INSTANCE;
            default:
                return Sandladan.INSTANCE;
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
