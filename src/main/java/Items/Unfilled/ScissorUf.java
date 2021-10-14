package Items.Unfilled;

import Items.Item;
import model.MapStates.Karhuset;
import model.MapStates.MapState;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class ScissorUf extends Item {

    public ScissorUf() throws SlickException {
        img = new Image("data/material/scissor_uf.png");
        location = new Rectangle(getStartX(),getStartY(),32,32);
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
