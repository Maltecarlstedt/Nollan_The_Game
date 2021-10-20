package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map märkena.
 *
 * @author Clara
 */
public enum Markena implements MapState{
    MARKENA;

    private String dPath = "data/maps/markena.tmx";

    @Override
    public MapState nextMap(PlayerModel playerModel) throws SlickException {
        switch (playerModel.getOrientation()){
            case RIGHT:
                playerModel.setNewPlayerTile(180, 344);
                return Karhuset.KARHUSET;
            case LEFT:
                playerModel.setNewPlayerTile(956, 424);
                return Maskin.MASKIN;
            case UP:
                playerModel.setNewPlayerTile(540, 700);
                return Rannan.RANNAN;
            default:
                return Markena.MARKENA;
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
