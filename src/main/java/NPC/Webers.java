package NPC;

import model.MapStates.Karhuset;
import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class Webers extends TaskHoldingNPC {

    //TODO: Gör till singleton

    public Webers() throws SlickException {
        width = 64;
        height = 128;
        state = 0;
        current = Karhuset.KARHUSET;
        location = new Point(700, 255);
        initNPC();
    }

    @Override //för denna NPC ska det egentligen finnas ett task, och därför finns denna metoden kvar.
    public void spriteSetupTask() throws SlickException {
        character = new SpriteSheet("data/NPC/webers64x64.png", 64, 64);
        animation = new Animation();
        animation.addFrame(character.getSubImage(0, 0), 200);
        //animation.addFrame(character.getSubImage(1, 0), 200);

    }

    @Override
    void spriteSetup() throws SlickException{
        character = new SpriteSheet("data/NPC/webers64x64.png", 64, 128);
        animation = new Animation();
        animation.addFrame(character.getSubImage(0, 0), 1);
    }


    @Override
    public void initNPC() throws SlickException {
        if (state == 0) {
            spriteSetupTask();
        } else if (state == 1) {
            spriteSetup();

        }
    }

    @Override
    public void setLocation(int x, int y) {
        location.x = x;
        location.y = y;
    }

    @Override
    public MapState getCurrent() {
        return current;
    }

    @Override
    public Point getLocation(){
        return location;
    }

    @Override
    public void setShowing(boolean isItShowing){
        isShowing = isItShowing;
    }

}



