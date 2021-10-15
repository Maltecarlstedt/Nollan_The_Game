package TextBoxes;

import model.MapStates.DeltaP;
import model.MapStates.Karhuset;
import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class DeltaTextBox extends AbstractTextBox {


    public DeltaTextBox() throws SlickException{
        mapState = DeltaP.DELTAP;
        location = new Point(600, 600);
        SpriteSetup();

    }
    @Override
    public void SpriteSetup() throws SlickException {
        backgroundBox = new SpriteSheet("data/Text-related/pritbox.png", 400, 106);
        textAnim = new Animation();
        textAnim.addFrame(backgroundBox, 1);
    }

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
