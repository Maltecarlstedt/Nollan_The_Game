package model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class ChugIndicator {

    public Point location;
    public int width;
    public int height;
    public Image bar_indicatorImage;
    public SpriteSheet bar_indicator;
    public Animation bar_inidcatorAni;

    public Image currentBarIndicatorImage;



    public ChugIndicator(){
        location = new Point(100, 300);
        width = 128;
        height = 400;
    }

    public void initChugIndicator() throws SlickException {
        bar_indicator = new SpriteSheet("data/model.beerChugging/Bar_Indicator.png", 16, 16);
        bar_inidcatorAni = new Animation(bar_indicator, 250);
        bar_inidcatorAni.setPingPong(true);

    }

    public Point getLocation() {
        return location;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
