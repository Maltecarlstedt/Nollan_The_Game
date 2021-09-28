package model.MapStates;

import model.MapModel;
import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Kårhuset.
 */
public enum Karhuset implements MapState{
    KARHUSET;

    @Override
    public void setPosition(PlayerModel player) {

    }


    @Override
    public void nextState(MapModel input, PlayerModel player, int state) throws SlickException {
        switch (state){
            case (0):
                input.setTiledMap(Chalmersplatsen.CHALMERSPLATSEN);
                break;
            case (1):
                input.setTiledMap(Karhuset.KARHUSET);
                break;
        }

        /*
        switch (input.getPOrientation(player)) {
            case LEFT:
                input.setTiledMap(Karhuset.KARHUSET);
                player.setLocation(650,650);
                break;
            case DOWN:
                input.setTiledMap(Chalmersplatsen.CHALMERSPLATSEN);
                player.setLocation(200,75);
                break;
        }

         */


    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap("data/maps/karhuset.tmx");
    }
}
