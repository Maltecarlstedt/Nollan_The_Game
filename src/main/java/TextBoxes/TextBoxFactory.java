package TextBoxes;

import model.MapStates.*;
import org.newdawn.slick.SlickException;

/**
 * @author Julia
 */

public class TextBoxFactory {

    public TextBoxFactory(){
    }

    public TextBox createChalmersText() throws SlickException {
        return new TextBox(Chalmersplatsen.CHALMERSPLATSEN, "data/Text-related/pritbox.png",
                400, 100, true, 400, 106);

    }

    public TextBox createKarhusetTextBox() throws SlickException {
        return new TextBox(Karhuset.KARHUSET, "data/Text-related/weberstext.png",
                500, 100, true, 400, 106);
    }

    public TextBox createEkakTextBox() throws SlickException {
        return new TextBox(Ekak.EKAK, "data/Text-related/ekaktext.png",
                300, 300, true, 400, 106);
    }

    public TextBox createMarkenaTextBox() throws SlickException {
        return new TextBox(Markena.MARKENA, "data/Text-related/weberstext.png",
                420, 100, true, 400, 106);
    }

    public TextBox createDeltaTextBox() throws SlickException {
        return new TextBox(DeltaP.DELTAP, "data/Text-related/datatext.png",
                90, 150, true, 400, 106);
    }

}
