package TextBoxes;

import model.MapStates.*;
import org.newdawn.slick.SlickException;

/**
 * @author Julia Böckert
 */

public class TextBoxFactory {

    public TextBoxFactory(){
    }

    public TextBox createChalmersText() throws SlickException {
        return new TextBox(Chalmersplatsen.INSTANCE, "data/Text-related/pritbox.png",
                400, 100, true, 400, 106);

    }

    public TextBox createKarhusetTextBox() throws SlickException {
        return new TextBox(Karhuset.INSTANCE, "data/Text-related/weberstext.png",
                500, 100, true, 400, 106);
    }

    public TextBox createEkakTextBox() throws SlickException {
        return new TextBox(Ekak.INSTANCE, "data/Text-related/ekaktext.png",
                300, 300, true, 400, 106);
    }

    public TextBox createMarkenaTextBox() throws SlickException {
        return new TextBox(Markena.INSTANCE, "data/Text-related/weberstext.png",
                420, 100, true, 400, 106);
    }

    public TextBox createDeltaTextBox() throws SlickException {
        return new TextBox(DeltaP.INSTANCE, "data/Text-related/datatext.png",
                90, 150, true, 400, 106);
    }

}
