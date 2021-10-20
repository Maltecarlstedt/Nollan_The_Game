package TextBoxes;

import model.MapStates.Karhuset;
import model.MapStates.MapState;
import model.MapStates.Markena;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class MarkenaTextBox extends AbstractTextBox {

    public MarkenaTextBox() throws SlickException{
        mapState = Markena.MARKENA;
        location = new Point(600, 600);
        SpriteSetup();
    }
    @Override
    public void SpriteSetup() throws SlickException {
        backgroundBox = new SpriteSheet("data/Text-related/nollkittext.png", 400, 106);
        textAnim = new Animation();
        textAnim.addFrame(backgroundBox, 1);
    }

    //TODO: Om vi vill avsluta spelet med att gå till Kårhuset förbi NollKIT, skriv denna kod
   // public void SpriteSetupDone(){}

  //  public void initSprite(){ }

    @Override
    public MapState getCurrent() {
        return mapState;
    }

    @Override
    Point getLocation() {
        return location;
    }

    @Override
    void setShowing(boolean isItShowing) {
        isShowing = isItShowing;
    }



}
