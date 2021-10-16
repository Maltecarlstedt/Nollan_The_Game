package NPC;

import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public abstract class NPC {

    boolean isShowing;
    int width;
    int height;

    MapState current;

    Point location;

    public SpriteSheet character;
    public Animation animation;


    /**
     * Fetches correct sprite and creates the animation
     * @throws SlickException Generic Exception
     */
    abstract void spriteSetup() throws SlickException;

    /**
     * Sets the x and y values where the NPC is to be drawn.
     * @param x x - coordinate
     * @param y y - coordinate
     */
    abstract void setLocation(int x, int y);

    /**
     * Gets the current map so that the correlated NPC can be drawn.
     * @return current map
     */
    public abstract MapState getCurrent();

    /**
     * Gets the location of the npc
     * @return x and y of the npc
     */
    abstract Point getLocation();

    /**
     * Sets visibility.
     * @param isItShowing boolean for false or true regarding if its to be shown or not
     */
    public abstract void setShowing(boolean isItShowing);


}
