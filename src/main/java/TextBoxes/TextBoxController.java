package TextBoxes;

import model.MapModel;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

/**
 * @author Julia Böckert
 */

public class TextBoxController {



    public TextBoxController() throws SlickException {

    }

    public void update(MapModel mp, ArrayList<TextBox> tbs){
        tbs.forEach(textBox -> {
            if ((textBox.getCurrent().equals(mp.getCurrentMap()))) {
                textBox.setShowing(true);
            }
            if ((textBox.getCurrent() != mp.getCurrentMap())) {
                textBox.setShowing(false);
            }
        });
    }
    }




    /*void showTextBox(MapModel mapModel, ArrayList<TextBox> tbs) {
        tbs.forEach(textBox -> {
            if (!mapModel.taskDone) {
                textBox.setShowing(true);
            }
            if (mapModel.taskDone) {
                textBox.setShowing(false);
            }
        });
    }

     */



