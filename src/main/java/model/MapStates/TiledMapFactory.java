package model.MapStates;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public abstract class TiledMapFactory {
    private final TiledMap map;

    protected TiledMapFactory(String path) {
        try {
            this.map = new TiledMap(path);
        } catch(SlickException e) {
            throw new RuntimeException(e);
        }
    }

    public TiledMap getMap() {
        return this.map;
    }
}
