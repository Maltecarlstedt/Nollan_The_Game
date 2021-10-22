package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Kårhuset.
 *
 * @author Clara
 */
public enum Karhuset implements MapState{
    KARHUSET;
    private String dPath = "data/maps/karhuset.tmx";

    @Override
    public MapState nextMap(PlayerModel playerModel){

        switch (playerModel.getOrientation()){
            case DOWN:
                playerModel.setNewPlayerTile(200, 50);
                return Chalmersplatsen.CHALMERSPLATSEN;
            case UP:
                playerModel.setNewPlayerTile(220, 700);
                return Dammen.ADAMMEN;
            case LEFT:
                playerModel.setNewPlayerTile(956, 360);
                return Markena.MARKENA;
            default:
                return Karhuset.KARHUSET;
        }
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap("data/maps/karhuset.tmx");
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
        return 2;
    }
}
