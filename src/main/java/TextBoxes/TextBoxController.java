package TextBoxes;

import model.MapModel;
import org.newdawn.slick.SlickException;

public class TextBoxController {

    TextBoxModel model;

    public TextBoxController() throws SlickException {
        model = new TextBoxModel();
    }

    public void update(MapModel mp){
        for(AbstractTextBox tb : model.textboxes){
            if(!mp.taskDone){
                tb.setShowing(false);
            }
            else{
                tb.setShowing(true);
            }
        }


    }
}