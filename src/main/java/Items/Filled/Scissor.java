package Items.Filled;

import Items.Item;
import model.MapStates.Ekak;
import model.MapStates.Karhuset;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class Scissor extends Item {

    public Scissor() throws SlickException {
        img = new Image("data/material/scissor.png");
        location = new Rectangle(400,200,32,32);
        currentMap = Karhuset.KARHUSET;//Ekak.EKAK;
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
