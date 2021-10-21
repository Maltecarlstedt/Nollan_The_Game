package TextBoxes;

import model.MapModel;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

/**
 * @author Julia
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



    }

    public void initTextBoxes(){
        textboxes.add(delta);
        textboxes.add(chalmers);
        textboxes.add(ekak);
        textboxes.add(karhuset);
        textboxes.add(markena);



    }

    public void render(Graphics g){
        g.drawAnimation(markena.textAnim, markena.getLocation().x, markena.getLocation().y);
    }


}
