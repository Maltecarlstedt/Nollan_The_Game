package Items.Unfilled;

import Items.Item;
import model.MapStates.Karhuset;
import model.MapStates.MapState;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class KarkortUf extends Item {

    public KarkortUf() throws SlickException {
        img = new Image("data/material/karkortet_uf.png");
        location = new Rectangle(getStartX() + 50,getStartY(),32,32);
        currentMap = Karhuset.KARHUSET;
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
