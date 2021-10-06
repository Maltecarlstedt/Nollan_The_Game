package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Rännan.
 */
public enum Rannan implements MapState{
    RANNAN;

    private String dPath = "data/maps/rannan.tmx";

    @Override
    public MapState nextMap(PlayerModel playerModel) throws SlickException {
        switch (playerModel.getOrientation()){
            case DOWN:
                playerModel.setNewPlayerTile(60, 4);
                return Markena.MARKENA;
            case UP:
                playerModel.setNewPlayerTile(940, 700);
                return DeltaP.DELTAP;
            case LEFT:
                playerModel.setNewPlayerTile(956, 360);
                return Ekak.EKAK;
            default:
                return Rannan.RANNAN;
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
        return 2;
    }
}
