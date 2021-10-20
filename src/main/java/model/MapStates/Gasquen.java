package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * @author Clara
 */
public enum Gasquen implements MapState{
    GASQUEN;

    private String dPath = "data/maps/gasquen.tmx";

    @Override
    public MapState nextMap(PlayerModel playerModel) throws SlickException {
        return Gasquen.GASQUEN;
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
        return 0;
    }
}
