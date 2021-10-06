package model.MapStates;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map deltaP.
 */
public enum DeltaP implements MapState{
    DELTAP;

    private String dPath = "data/maps/deltaP.tmx";

    @Override
    public MapState nextMap(PlayerModel playerModel) throws SlickException {
        switch (playerModel.getOrientation()){
            case DOWN:
                playerModel.setNewPlayerTile(600, 4);
                return Rannan.RANNAN;
            case RIGHT:
                playerModel.setNewPlayerTile(4, 340);
                return Dammen.ADAMMEN;
            case LEFT:
                playerModel.setNewPlayerTile(396, 4);
                playerModel.moveDown();
                return Sandladan.SANDLADAN;
            default:
                return DeltaP.DELTAP;
        }
    }

    @Override
    public void setPosition(PlayerModel player) {

    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(dPath);
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
