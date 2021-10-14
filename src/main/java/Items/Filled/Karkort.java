package Items.Filled;

import Items.Item;
import model.MapStates.Dammen;
import model.MapStates.Ekak;
import model.MapStates.Karhuset;
import model.MapStates.MapState;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class Karkort extends Item {

    public Karkort() throws SlickException {
        img = new Image("data/material/karkortet.png");
        location = new Rectangle(250,250,32,32);
        currentMap = Ekak.EKAK;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, location.x, location.y);
    }

    @Override
    public void setShowing(boolean isItShowing) {
        isShowing = isItShowing;
    }

    @Override
    public MapState getCurrentMap() {
        return currentMap;
    }
}
