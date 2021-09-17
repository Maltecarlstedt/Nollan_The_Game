import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public enum Chalmersplatsen implements MapState {
    CHALMERSPLATSEN;
    @Override
    public void nextState(Map input) {
        input.setTiledMap(Karhuset.KARHUSET);
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(("data/maps/chalmershallplatsen.tmx"));

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

