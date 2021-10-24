package TextBoxes;

import model.MapModel;
import org.newdawn.slick.Graphics;
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

    public void initTextBoxes() {
        textboxes.add(delta);
        textboxes.add(chalmers);
        textboxes.add(ekak);
        textboxes.add(karhuset);
        textboxes.add(markena);
    }

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
