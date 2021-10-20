package NPC;

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
    void spriteSetupTask() throws SlickException {
        character = new SpriteSheet("data/NPC/ekak64x72.png", 64, 64);
        animation = new Animation();
        animation.addFrame(character.getSubImage(0, 0), 200);
        //animation.addFrame(character.getSubImage(1, 0), 200);
    }

    @Override
    void spriteSetup() throws SlickException {
        character = new SpriteSheet("data/NPC/kvalle64x64.png", 64, 64);
        animation = new Animation();
        animation.addFrame(character.getSubImage(0, 0), 200);
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



