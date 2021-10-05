package NPCs;

import model.MapStates.Chalmersplatsen;
import model.MapStates.Karhuset;
import model.MapStates.MapState;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.awt.*;

public class Tango extends NPC {

public Tango() throws SlickException {
    width = 64;
    height = 64;
    state = 0;
    //isShowing = true;
    current = Chalmersplatsen.CHALMERSPLATSEN;
    location = new Point(700, 200);
    initNPC();
}

    @Override
    void spriteSetup() throws SlickException {
        //character = new SpriteSheet("data/NPC/tangoPRIT64x64.png", 64, 64);
        character = new SpriteSheet("data/NPC/tangoPRIT64x64.png",64,64,64);
        animation = new Animation();
        animation.addFrame(character.getSubImage(0, 0), 200);
    }

    @Override
    void initNPC() throws SlickException {
        spriteSetup();
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        if(isShowing) {
            g.drawAnimation(animation, getLocation().x, getLocation().y);
        }
    }

    @Override
    void setLocation(int x, int y) {

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
