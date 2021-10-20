package TextBoxes;

import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class TextBoxView {

    /**
     * @author Julia
     */

    public void render(Graphics g, ArrayList<TextBox> tbs) {
        for (TextBox tb : tbs) {
            if (tb.isShowing) {
                g.drawAnimation(tb.textAnim, tb.getLocation().x, tb.getLocation().y);
            }
        }
    }
}
