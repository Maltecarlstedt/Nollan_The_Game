package model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class beerChugging {

    private Point location;
    private int width, height;
    public SpriteSheet beer; // initate a SpriteSheet
    public Animation beerAni; // initate an Animation
    public Image currentBeerImage;
    public int numberOfChugs = 0  ;
    public int chugCount = 0;


    public beerChugging() {
        location = new Point(1024 / 2, 768 / 2);
        height = 64;
        width = 64;
    }

    public void initBeerChugging() throws SlickException {//TODO: Borde skala vår gubbe här direkt till 64x64?
        beer = new SpriteSheet("data/model.beerChugging/beerchugging_mini_V2.png", 17, 17);

        currentBeerImage = beer.getSubImage(0,0);
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

    public void updateChug(){

        if(chugCount > 8){
            chugCount = 0;
            currentBeerImage = beer.getSubImage(chugCount,0);
        }
        currentBeerImage = beer.getSubImage(chugCount,0);
        chugCount++;

    }


    public void chug() {
        if (numberOfChugs >=  1){
            updateChug();
            numberOfChugs = 0;

        }

    }

}
