package model.MapStates;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * An abstract class which creates the tiledMaps of the different mapStates
 * Used by: All MapState classes
 * Uses: TiledMap
 * @author Clara Simonsson & Alexander Brunnegård
 */
public abstract class TiledMapFactory {
    private final TiledMap map;

    /**
     * Called by all the mapState classes, creates the actual tiledMap
     * @param path The file path to the specific map
     */
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
