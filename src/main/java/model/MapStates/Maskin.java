package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Maskin.
 *
 * @author Clara
 */
public enum Maskin implements MapState{
    MASKIN;

    private String dPath = "data/maps/maskin.tmx";

    @Override
    public MapState nextMap(PlayerModel playerModel) throws SlickException {
        switch (playerModel.getOrientation()){
            case RIGHT:
                playerModel.setNewPlayerTile(4, 364);
                return Markena.MARKENA;
            case UP:
                playerModel.setNewPlayerTile(360, 700);
                return Sandladan.SANDLADAN;
            default:
                return Maskin.MASKIN;

        }
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
