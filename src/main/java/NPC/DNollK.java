package NPC;

import model.MapModel;
import model.MapStates.DeltaP;
import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class DNollK extends NPC {
    public DNollK() throws SlickException {
        width = 64;
        height = 128;
        state = 0;
        current = DeltaP.DELTAP;
        location = new Point(500, 179);
        spriteSetupTask();
    }

    @Override
    void spriteSetupTask() throws SlickException {
        taskCharacter = new SpriteSheet("data/NPC/dnollk128x128TASK.png", 64, 128);
        animation = new Animation();
        animation.addFrame(taskCharacter.getSubImage(0, 0), 200);
        animation.addFrame(taskCharacter.getSubImage(1, 0), 200);
    }

    @Override
    void spriteSetup() throws SlickException{
        character = new SpriteSheet("data/NPC/dnollk64x64.png", 64, 64);
        animation = new Animation();
        animation.addFrame(character.getSubImage(0, 0), 1);
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
