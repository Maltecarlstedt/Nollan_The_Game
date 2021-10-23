package TextBoxes;

import model.MapModel;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.ArrayList;

/**
 * @author Julia Böckert
 */

public class TextBoxView {


    public void render(Graphics g, ArrayList<TextBox> tbs, MapModel mp) throws SlickException {
        SpriteSetup(tbs);
        drawTextBox(g, tbs);
        showTextBox(mp, tbs);
    }

    void drawTextBox(Graphics g, ArrayList<TextBox> tbs){
        for (TextBox tb : tbs) {
            if (tb.isShowing) {
                g.drawAnimation(tb.textAnim, tb.getLocation().x, tb.getLocation().y);
            }
        }
    }

    void SpriteSetup (ArrayList<TextBox> tbs) throws SlickException {
        for(TextBox tb : tbs) {
            tb.backgroundBox = new SpriteSheet(tb.textBoxFile, tb.width, tb.height);
            tb.textAnim.addFrame(tb.backgroundBox.getSubImage(0, 0), 1);

        }
    }

    void showTextBox(MapModel mapModel, ArrayList<TextBox> tbs) {
        tbs.forEach(textBox -> {
            if (textBox.getCurrent().equals(mapModel.getCurrentMap())) {
                textBox.setShowing(true);
            }
            if ((textBox.getCurrent() != mapModel.getCurrentMap())) {
                textBox.setShowing(false);
            }
        });
    }
}
