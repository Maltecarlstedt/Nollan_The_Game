package Items.Filled;

import Items.Item;
import model.MapStates.Dammen;
import model.MapStates.DeltaP;
import model.MapStates.Karhuset;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class Cardboard extends Item {

    public Cardboard() throws SlickException {
        img = new Image("data/material/cardboard.png");
        location = new Rectangle(300,300,32,32);
        currentMap = Dammen.ADAMMEN;
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
