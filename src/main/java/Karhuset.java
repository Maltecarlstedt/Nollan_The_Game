import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public enum Karhuset implements MapState {
    KARHUSET;
    @Override
    public void nextState(Map input) {
        input.setTiledMap(Chalmersplatsen.CHALMERSPLATSEN);
    }

    @Override
    public void setPosition(Player player) {
        player.setLocation(150,200);
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(("data/maps/karhuset.tmx"));

    }
}
