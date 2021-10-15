package Items.Filled;

import Items.Item;
import model.MapStates.Karhuset;
import model.MapStates.Rannan;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class Rope extends Item {

    public Rope() throws SlickException {
        img = new Image("data/material/rope.png");
        location = new Rectangle(350,350,32,32);
        currentMap = Karhuset.KARHUSET;//Rannan.RANNAN;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, location.x, location.y);
    }

    @Override
    public void setShowing(boolean isItShowing) {
        isShowing = isItShowing;
    }
}
