package TextBoxes;

import model.MapModel;

import java.util.ArrayList;

public class TextFieldModel {

    ArrayList<AbstractTextBox> textboxes;

    public TextFieldModel(){
        textboxes = new ArrayList<>();
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
