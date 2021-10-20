package TextBoxes;

import model.MapModel;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class TextBoxModel {

    DeltaTextBox delta = new DeltaTextBox();
    ChalmersTextBox chalmers = new ChalmersTextBox();
    EkakTextBox ekak = new EkakTextBox();
    KarhusetTextBox karhuset = new KarhusetTextBox();
    MarkenaTextBox markena = new MarkenaTextBox();


    public ArrayList<AbstractTextBox> textboxes;

    public TextBoxModel() throws SlickException {
        textboxes = new ArrayList<>();
    }

    public void initTextBoxes(){
        textboxes.add(delta);
        textboxes.add(chalmers);
        textboxes.add(ekak);
        textboxes.add(karhuset);
        textboxes.add(markena);


    }

    public void showTextBox(MapModel mapModel) {
        textboxes.forEach(textBox -> {
            if (textBox.getCurrent().equals(mapModel.getCurrentMap())) {
                textBox.setShowing(true);
            }
            if ((textBox.getCurrent() != mapModel.getCurrentMap())) {
                textBox.setShowing(false);
            }
        });
    }



}
