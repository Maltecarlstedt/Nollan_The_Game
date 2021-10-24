package TextBoxes;
import model.MapStates.*;

/**
 * @author Julia Böckert
 * Initializes TextBox instances
 * Used by NPCModel
 * Uses TextBox
 */

public class TextBoxFactory {
    public TextBoxFactory(){
    }

    /**
     * Creates an TextBox-instance
     */

    public TextBox createChalmersText() {
        return new TextBox(Chalmersplatsen.INSTANCE, "data/Text-related/pritbox.png",
                400, 100, true, 400, 106);

    }

    public TextBox createKarhusetTextBox() {
        return new TextBox(Karhuset.INSTANCE, "data/Text-related/weberstext.png",
                500, 100, true, 400, 106);
    }

    public TextBox createEkakTextBox(){
        return new TextBox(Ekak.INSTANCE, "data/Text-related/ekaktext.png",
                300, 300, true, 400, 106);
    }

    public TextBox createMarkenaTextBox() {
        return new TextBox(Markena.INSTANCE, "data/Text-related/nollkittext.png",
                420, 100, true, 400, 106);
    }

    public TextBox createDeltaTextBox()  {
        return new TextBox(DeltaP.INSTANCE, "data/Text-related/datatext.png",
                90, 150, true, 400, 106);
    }

}
