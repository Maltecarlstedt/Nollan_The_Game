package TextBoxes;

import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public abstract class AbstractTextBox {

    Point location;
    MapState mapState;
    Animation textAnim;
    SpriteSheet backgroundBox;
    boolean isShowing;

    public abstract void SpriteSetup() throws SlickException;

    /**
     * Gets the current map so that the correlated TextBox can be drawn.
     * @return current map
     */
    public abstract MapState getCurrent();

    /**
     * Gets the location of the textBox
     * @return x and y of the textBox
     */
    abstract Point getLocation();

    abstract void setShowing(boolean isItShowing);
}
