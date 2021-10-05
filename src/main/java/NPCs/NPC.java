package NPCs;

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

    //state 1 elr 0, task complete eller inte, alternerar bild med/utan utroptecken
    int state;
    MapState current;

   // private static Point location = new Point(300, 500);
    Point location;
    protected Rectangle NPCLocation;

    public SpriteSheet character;
    public SpriteSheet taskComplete;
    public Animation animation;


    abstract void spriteSetup() throws SlickException;

    abstract void initNPC() throws SlickException;

    public abstract void render(GameContainer gc, Graphics g);

    abstract void setLocation(int x, int y);

    public abstract MapState getCurrent();

    abstract Point getLocation();

    public abstract void setShowing(boolean isItShowing);

}
