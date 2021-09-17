import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;

public interface MapState {
    void nextState(Map input);
    void setPosition(Player player);
    TiledMap loadMap() throws SlickException;

}
