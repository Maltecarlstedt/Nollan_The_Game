package NPC;

import model.MapStates.Chalmersplatsen;
import model.MapStates.MapState;
import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;

import java.awt.*;

public class Kritan extends NPC {

    public Kritan() throws SlickException{
        width = 64;
        height = 64;
        current = Chalmersplatsen.CHALMERSPLATSEN;
        location = new Point(400, 200);
        spriteSetup();
    }

    @Override
    void spriteSetup() throws SlickException {
        character = new SpriteSheet("data/NPC/kritanPRIT64x64.png", 64, 64);
        animation = new Animation();
        animation.addFrame(character.getSubImage(0, 0), 200);

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
