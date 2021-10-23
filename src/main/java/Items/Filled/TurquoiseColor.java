package Items.Filled;

import Items.Item;
import model.MapStates.Karhuset;
import model.MapStates.Maskin;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

/**
 * @author Clara
 */
public class TurquoiseColor extends Item {

    public TurquoiseColor() throws SlickException {
        img = new Image("data/material/turqoise_color.png");
        location = new Rectangle(450,450,32,32);
        currentMap = Karhuset.KARHUSET;//Maskin.MASKIN;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, location.x, location.y);
    }
}
