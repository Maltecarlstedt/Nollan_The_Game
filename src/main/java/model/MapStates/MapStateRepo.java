package model.MapStates;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

// Look up: "singleton java enum"
public enum MapStateRepo {
    CHALMERSPLATSEN("data/maps/chalmershallplatsen.tmx"),
    DAMMEN("data/maps/aDammen.tmx");
    ;

    private final TiledMap instance;

    private MapStateRepo(String path) {
        try {
            this.instance = new TiledMap(path);
        } catch (SlickException e) {
            throw new RuntimeException(e);
        }
    }

    public TiledMap getInstance() {
        return this.instance;
    }
}
