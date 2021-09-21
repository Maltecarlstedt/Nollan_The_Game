package Tasks.taskModel;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public class BeerChuggingModel {

    private int height;
    private int width;
    private Point location;
    public Image inidcatorImage;
    public Image scaledInidcatorImage;

    public BeerChuggingModel() throws SlickException {
        initBeerChuggingIndicator();


    }

    public void initBeerChuggingIndicator() throws SlickException {
        inidcatorImage = new Image("data/beerChugging/Bar_Indicator_v2.png");
        location = new Point(100, 300);
        height = 400;
        width = 128;
        scaledInidcatorImage = inidcatorImage.getScaledCopy(148,420);
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public Point getLocation() {
        return location;
    }
}
