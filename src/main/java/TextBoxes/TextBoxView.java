package TextBoxes;

import model.MapModel;
import org.newdawn.slick.*;
import java.util.ArrayList;

/**
 * @author Julia Böckert
 * Draws the TextBoxes.
 * Used by MainGame
 * Uses TextBox, MapModel, TextBoxModel
 */

public class TextBoxView {

    public TextBoxView(ArrayList<TextBox> tbs) throws SlickException {
        ImageSetup(tbs);
    }

    /**
     * Renders the NPCs on the map. depending on the boolean isShowing.
     * @param model a TextBoxModel
     * @param tbs an arraylist of all initialized textboxes
     * @param mp, a MapModel
     */

    public void render(ArrayList<TextBox> tbs, TextBoxModel model, MapModel mp){
        model.showTextBoxes(mp);
        drawTextBox(tbs);
    }

    /**
     * Displays the textboxes if it should be visible
     * @param tbs - the ArrayList with all textboxes
     */

    void drawTextBox(ArrayList<TextBox> tbs){
        for (TextBox tb : tbs) {
            if (tb.isShowing) {
                tb.backgroundBox.startUse();
                tb.backgroundBox.drawEmbedded(tb.getLocation().x, tb.getLocation().y, tb.width, tb.height);
                tb.backgroundBox.endUse();
            }
        }
    }

    /**
     * Sets the image for the textbox
     * @param tbs - the ArrayList with all textboxes
     */

    void ImageSetup (ArrayList<TextBox> tbs) throws SlickException {
        for(TextBox tb : tbs) {
            tb.backgroundBox = new Image(tb.textBoxFile);

        }
    }


}
