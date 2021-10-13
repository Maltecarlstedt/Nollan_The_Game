package NPC;

import model.MapStates.MapState;
import model.MapStates.Markena;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class Bieber extends NPC{
    public Bieber() throws SlickException {
        width = 64;
        height = 90;
        //state = 0;
        current = Markena.MARKENA;
        location = new Point(760, 179);
        //initNPC();
        spriteSetup();
    }

    @Override
    void spriteSetup() throws SlickException {
        character = new SpriteSheet("data/NPC/Bieber64x90.png", 64, 90);
        animation = new Animation();
        animation.addFrame(character.getSubImage(0, 0), 200);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        if(isShowing) {
            g.drawAnimation(animation, getLocation().x, getLocation().y);
        }
    }

    @Override
    void setLocation(int x, int y) {
        location.x = x;
        location.y = y;
    }

    @Override
    public MapState getCurrent() {
        return current;
    }

    @Override
    Point getLocation() {
        return location;
    }

    @Override
    public void setShowing(boolean isItShowing) {
        isShowing = isItShowing;
    }
}


