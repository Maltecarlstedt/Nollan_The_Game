import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates an enum for one map piece which holds the specific methods for just that map.
 * This map is for the tiled map Kårhuset.
 */
public enum Karhuset implements MapState {
    KARHUSET;

    @Override
    public void nextState(Map input, Player player){
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
    }

    @Override
    public void setPosition(Player player) {
        player.setLocation(450,700);
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(("data/maps/karhuset.tmx"));

    }
}
