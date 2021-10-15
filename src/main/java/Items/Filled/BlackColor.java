package Items.Filled;

import Items.Item;
import model.MapStates.DeltaP;
import model.MapStates.Karhuset;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class BlackColor extends Item {

    public BlackColor() throws SlickException {
        img = new Image("data/material/black_color.png");
        location = new Rectangle(400,400,32,32);
        currentMap = Karhuset.KARHUSET;//DeltaP.DELTAP;
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
