package NPCs;

import model.MapStates.Ekak;
import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class EKAK2 extends NPC {

    public EKAK2() throws SlickException {
        width = 64;
        height = 64;
        state = 0;
        current = Ekak.EKAK;
        location = new Point(420, 180);
        initNPC();
    }

    @Override
    void spriteSetup() throws SlickException {
        character = new SpriteSheet("data/NPC/ekak64x72.png", 64, 72);
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




