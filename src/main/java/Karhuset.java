import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class Karhuset extends MapState {

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
}
