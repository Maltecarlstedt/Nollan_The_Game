package model.MapStates;

import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Chalmershållplatsen.
 *
 * @author Clara
 */
public class Chalmersplatsen extends TiledMapFactory implements MapState {
    public static final Chalmersplatsen INSTANCE = new Chalmersplatsen();
    private static final String DPATH = "data/maps/chalmershallplatsen.tmx";

    private Chalmersplatsen() {
        super(DPATH);
    }

    @Override
    public MapState nextMap(PlayerModel playerModel){
        switch (playerModel.getOrientation()){
            case UP:
                playerModel.setNewPlayerTile(440, 700);
                return Karhuset.INSTANCE;
            default:
                return Chalmersplatsen.INSTANCE;
        }
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return getMap();
    }

    @Override
    public int getTopLayers(){
        return 2;
    }

}

