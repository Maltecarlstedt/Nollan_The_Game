package TextBoxes;

import model.MapModel;
import org.newdawn.slick.*;

import java.util.ArrayList;

/**
 * @author Julia Böckert
 */

public class TextBoxView {

    public TextBoxView(ArrayList<TextBox> tbs) throws SlickException {
        SpriteSetup(tbs);
    }


    public void render(ArrayList<TextBox> tbs, TextBoxModel model, MapModel mp) throws SlickException {
        model.showTextBoxes(mp);
        drawTextBox(tbs);
    }

    void drawTextBox(ArrayList<TextBox> tbs){
        for (TextBox tb : tbs) {
            if (tb.isShowing) {
                tb.backgroundBox.startUse();
                tb.backgroundBox.drawEmbedded(tb.getLocation().x, tb.getLocation().y, tb.width, tb.height);
                tb.backgroundBox.endUse();
            }
        }
    }

    void SpriteSetup (ArrayList<TextBox> tbs) throws SlickException {
        for(TextBox tb : tbs) {
            tb.backgroundBox = new Image(tb.textBoxFile);

        }
    }


}
