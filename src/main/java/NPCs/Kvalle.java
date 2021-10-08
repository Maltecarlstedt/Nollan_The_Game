package NPCs;

import model.MapStates.MapState;
import model.MapStates.Markena;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.awt.*;

public class Kvalle extends NPC {

    public Kvalle() throws SlickException{
    width = 64;
    height = 64;
    //state = 0;
    current = Markena.MARKENA;
    location = new Point(700, 200);
    spriteSetup();
}

    @Override
    void spriteSetup() throws SlickException {
        character = new SpriteSheet("data/NPC/kvalle64x64.png", 64, 64);
        animation = new Animation();
        animation.addFrame(character.getSubImage(0, 0), 200);
    }

    /*@Override
    void initNPC() throws SlickException {
        spriteSetup();
    }

     */

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




