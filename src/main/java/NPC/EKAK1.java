package NPC;

import model.MapModel;
import model.MapStates.Ekak;
import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class EKAK1 extends NPC {

        public EKAK1() throws SlickException {
            width = 64;
            height = 64;
            state = 0;
            current = Ekak.EKAK;
            location = new Point(480, 140);
            spriteSetupTask();
        }

        @Override
        void spriteSetup() throws SlickException {
            character = new SpriteSheet("data/NPC/ekak_TASK_128x115.png", 64, 115);
            animation = new Animation();
            animation.addFrame(character.getSubImage(0, 0), 1);
        }

        @Override
        void spriteSetupTask() throws SlickException{
            taskCharacter = new SpriteSheet("data/NPC/ekak_TASK_128x115.png", 64, 115);
            animation = new Animation();
            animation.addFrame(taskCharacter.getSubImage(0, 0), 200);
            animation.addFrame(taskCharacter.getSubImage(1, 0), 200);


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
     public void setShowing(boolean isItShowing) { isShowing = isItShowing;
        }


}



