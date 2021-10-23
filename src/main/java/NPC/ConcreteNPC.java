package NPC;

import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

/**
 * @author Julia Böckert
 */

public class ConcreteNPC {

    boolean isShowing;
    int width;
    int height;
    int taskHeight;
    int state;
    MapState current;
    Point location;
    String characterString;
    String taskString;
    SpriteSheet character;
    SpriteSheet taskCharacter;
    Animation animation;
    Animation taskAnimation;


    public ConcreteNPC(MapState current, int width, int height, int taskHeight, int state, int x, int y,
                       String characterString, String taskString, boolean isShowing)  {
        this.current = current;
        this.width = width;
        this.height = height;
        location = new Point (x, y);
        this.taskHeight = taskHeight;
        this.state = state;
        this.characterString = characterString;
        this.taskString = taskString;
        this.isShowing = isShowing;
        animation = new Animation();
        taskAnimation = new Animation();


    }

    /**
     * Gets the current map so that the correlated NPC can be drawn.
     * @return current map
     */
    public MapState getCurrent(){
        return current;
    }

    public Point getLocation(){
        return location;
    }

    /**
     * Sets visibility.
     * @param isItShowing boolean for false or true regarding if its to be shown or not
     */
    public void setShowing(boolean isItShowing){
        isShowing = isItShowing;
    }


}


