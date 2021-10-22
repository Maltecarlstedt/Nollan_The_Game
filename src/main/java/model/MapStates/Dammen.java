package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map aDammen.
 *
 * @author Clara
 */
public enum Dammen implements MapState{
    ADAMMEN;

    private String dPath = "data/maps/aDammen.tmx";

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case DOWN:
                playerModel.setNewPlayerTile(360, 4);
                return Karhuset.KARHUSET;
            case UP:
                playerModel.setNewPlayerTile(900, 90);
                playerModel.moveDown();
                return DeltaP.DELTAP;
            case LEFT:
                playerModel.setNewPlayerTile(956, 460);
                return DeltaP.DELTAP;
            default:
                return Dammen.ADAMMEN;

        }
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(dPath);
    }

    @Override
    public String getDPath() {
        return dPath;
    }

    @Override
    public MapState map(){
        return this;
    }

    @Override
    public int getTopLayers(){
        return 1;
    }
}
