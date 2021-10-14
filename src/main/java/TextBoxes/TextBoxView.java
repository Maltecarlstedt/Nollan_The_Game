package TextBoxes;

import org.newdawn.slick.Graphics;

import java.awt.*;

public class TextBoxView {

    public void render(Graphics g, TextFieldModel tfm){
        for(AbstractTextBox atb : tfm.textboxes)
        g.drawAnimation(atb.textAnim, atb.getLocation().x, atb.getLocation().y);

    }
}
