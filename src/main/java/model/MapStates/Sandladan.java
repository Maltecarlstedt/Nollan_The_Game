package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Sandlådan.
 *
 * @author Clara
 */
public enum Sandladan implements MapState{
    SANDLADAN;

    private String dPath = "data/maps/sandladan.tmx";

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case RIGHT:
                playerModel.setNewPlayerTile(4, 360);
                return Ekak.EKAK;
            case DOWN:
                playerModel.setNewPlayerTile(300, 4);
                return Maskin.MASKIN;
            case UP:
                playerModel.setNewPlayerTile(4, 580);
                playerModel.moveRight();
                return DeltaP.DELTAP;
            default:
                return Sandladan.SANDLADAN;
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
