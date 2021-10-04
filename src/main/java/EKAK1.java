import model.MapStates.Chalmersplatsen;
import model.MapStates.Ekak;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
            initNPC();
        }

        @Override
        void spriteSetup() throws SlickException {
            character = new SpriteSheet("data/NPC/ekak_TASK_128x115.png", 64, 115);
            animation = new Animation();
            animation.addFrame(character.getSubImage(0, 0), 200);
            animation.addFrame(character.getSubImage(1, 0), 200);

        }

        @Override
        void initNPC() throws SlickException {
            spriteSetup();
        }

        @Override
        void render(GameContainer gc, Graphics g) {
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
        Point getLocation() {
            return location;
        }

        @Override
        void setShowing(boolean isItShowing) {
            isShowing = isItShowing;
        }
    }


