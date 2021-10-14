package TextBoxes;

import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class TextBoxView {

    public void render(Graphics g, ArrayList<AbstractTextBox> atbs) {
        for (AbstractTextBox atb : atbs) {
            if (atb.isShowing) {
                g.drawAnimation(atb.textAnim, atb.getLocation().x, atb.getLocation().y);
            }
        }
    }
}
