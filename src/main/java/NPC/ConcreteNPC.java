package NPC;

import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

/**
 * @author Julia
 */


public class ConcreteNPC {
    /**
     * @author Julia Böckert
     */

    boolean isShowing;
    int width;
    int height;
    int taskHeight;
    int state;
    MapState current;
    Point location;
    String characterString;
    String taskString;
    public SpriteSheet character;
    public Animation animation;

    public ConcreteNPC(MapState current, int width, int height, int taskHeight, int state, int x, int y,
                       String characterString, String taskString, boolean isShowing) throws SlickException {
        this.current = current;
        this.width = width;
        this.height = height;
        location = new Point (x, y);
        this.taskHeight = taskHeight;
        this.state = state;
        this.characterString = characterString;
        this.taskString = taskString;
        this.isShowing = isShowing;
        spriteSetup();

    }

    /**
     * Fetches correct Sprite and creates the animation
     * @throws SlickException Generic Exception
     */
    void spriteSetup() throws SlickException {
        animation = new Animation();
        if (state == 0) {
            character = new SpriteSheet(taskString, width, taskHeight);
            animation.addFrame(character.getSubImage(0, 0), 200);
            animation.addFrame(character.getSubImage(1, 0), 200);
        } else if (state == 1){
            character = new SpriteSheet(characterString, width, height);
            animation.addFrame(character.getSubImage(0, 0), 200);
        }

    }


    /**
     * Gets the current map so that the correlated NPC can be drawn.
     * @return current map
     */
    public MapState getCurrent(){
        return current;
    }

    Point getLocation(){
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


