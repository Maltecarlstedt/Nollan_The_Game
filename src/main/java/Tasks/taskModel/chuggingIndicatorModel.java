package Tasks.taskModel;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class chuggingIndicatorModel {

    private int height;
    private int width;
    private Point location;
    private Image inidcatorImage;

    public chuggingIndicatorModel() throws SlickException {
        inidcatorImage = new Image("data/beerChugging/Bar_Indicator_v2.png");
        height = 400;
        width = 128;
    }


}
