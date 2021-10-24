package TextBoxes;

import model.MapModel;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

/**
 * @author Julia Böckert
 */

public class TextBoxModel {

    TextBoxFactory factory;

    TextBox delta;
    TextBox chalmers;
    TextBox ekak;
    TextBox karhuset;
    TextBox markena;


    public ArrayList<TextBox> textboxes;

    public TextBoxModel() throws SlickException {
        textboxes = new ArrayList<>();
        factory = new TextBoxFactory();
        delta = factory.createDeltaTextBox();
        chalmers = factory.createChalmersText();
        ekak = factory.createEkakTextBox();
        karhuset = factory.createKarhusetTextBox();
        markena = factory.createMarkenaTextBox();
        initTextBoxes();
    }

    /**
     * Initializes the list of NPCs
     */

    private void initTextBoxes() {
        textboxes.add(delta);
        textboxes.add(chalmers);
        textboxes.add(ekak);
        textboxes.add(karhuset);
        textboxes.add(markena);
    }

    /**
     * Displays the textboxes on the map that they belong to.
     *
     * @param mp A MapModel
     */

    void showTextBoxes(MapModel mp) {
     textboxes.forEach(textBox ->
    {
        if ((textBox.getCurrent().equals(mp.getCurrentMap()))) {
            textBox.setShowing(true);
        }
        if ((textBox.getCurrent() != mp.getCurrentMap())) {
            textBox.setShowing(false);
        }
    });
}
}
