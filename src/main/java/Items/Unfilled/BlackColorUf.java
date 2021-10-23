package Items.Unfilled;

import Items.Item;
import model.MapStates.Karhuset;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

/**
 * @author Clara
 */
public class BlackColorUf extends Item {

    public BlackColorUf() throws SlickException {
        img = new Image("data/material/black_color_uf.png");
        location = new Rectangle(getStartX() + 200,getStartY(),32,32);
        currentMap = Karhuset.KARHUSET;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, location.x, location.y);
    }
}
