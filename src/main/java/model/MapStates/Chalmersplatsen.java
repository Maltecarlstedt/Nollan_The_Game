package model.MapStates;

import model.MapModel;
import model.PlayerModel;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Chalmershållplatsen.
 */
public enum Chalmersplatsen implements MapState {
    CHALMERSPLATSEN;

    @Override
    public void nextState(MapModel input, PlayerModel player, int state) throws SlickException {
        /*
         switch (input.getPOrientation(player)) {
            case LEFT:
                input.setTiledMap(Chalmersplatsen.CHALMERSPLATSEN);
                player.setLocation(650,650);
                break;
            case UP:
                input.setTiledMap(Karhuset.KARHUSET);
                player.setLocation(350,700);
                break;
        }
         */
    }

    @Override
    public void setPosition(PlayerModel player) {

    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap("data/maps/chalmershallplatsen.tmx");
    }
}

