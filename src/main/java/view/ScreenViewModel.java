package view;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public interface ScreenViewModel {
    TiledMap loadMap() throws SlickException;
}
