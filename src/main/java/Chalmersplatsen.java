import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Chalmershållplatsen.
 */
public enum Chalmersplatsen implements MapState {
    CHALMERSPLATSEN;

    @Override
    public void nextState(Map input, Player player){
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
    }

    @Override
    public void setPosition(Player player) {
        player.setLocation(200,75);
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(("data/maps/chalmershallplatsen.tmx"));
    }
}

