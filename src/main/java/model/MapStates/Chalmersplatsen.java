package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Chalmershållplatsen.
 */
public enum Chalmersplatsen implements MapState {
    CHALMERSPLATSEN;

    private String dPath = "data/maps/chalmershallplatsen.tmx";

    @Override
    public MapState nextMap(PlayerModel playerModel) throws SlickException{
        switch (playerModel.getOrientation()){
            case UP:
                playerModel.setNewPlayerTile(440, 700);
                return Karhuset.KARHUSET;
            default:
                return Chalmersplatsen.CHALMERSPLATSEN;
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

