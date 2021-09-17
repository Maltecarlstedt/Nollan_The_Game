import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public enum Karhuset implements MapState {
    KARHUSET;
    @Override
    public void nextState(Map input) {
        input.setTiledMap(Chalmersplatsen.CHALMERSPLATSEN);
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(("data/maps/karhuset.tmx"));

    }

    /*
    TiledMap tiledMap;

    @Override
    public void nextState(Player player) throws SlickException {
        if (!player.checkBorder()){
            tiledMap = new TiledMap("data/maps/chalmershallplatsen.tmx");
        }
    }

    @Override
    public void startPosition() {
    }

     */
}
