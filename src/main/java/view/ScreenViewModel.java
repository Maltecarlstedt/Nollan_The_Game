package view;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Holds the common methods for the ViewModels
 * Used by: ViewTranslator
 * @author Clara Simonsson & Alexander Brunnegård
 */
public interface ScreenViewModel {
    TiledMap loadMap() throws SlickException;
}
