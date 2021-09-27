package Tasks.taskModel;

import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.awt.Font;
import java.io.InputStream;

public class BeerChuggingModel {

    private final int greenThingyHeight = 64, greenThingyWidth = 30;
    private final int jumpingBeerHeight = 24, jumpingBeerWidth = 30;
    public Rectangle jumpingBeerRect;
    public Rectangle greenThingyReact;
    private Point indicatorLocation;
    public Image inidcatorImage;
    public Image greenThingy;
    public Image jumpingBeer;

    public Image timerBox;

    public TrueTypeFont trueTypePixelFont;

    public float timePassed;

    public SpriteSheet chuggingAnimation;
    public Image currentChugAnimation;

    // TODO: Snygga till detta lol
    public BeerChuggingModel() throws SlickException {
        initBeerChuggingIndicator();
        initGreenThingy();
        initJumpingBeer();
        initChuggingAnimation();
        fontLoader();
        initTimerSetup();
    }

    //TODO: Gör en egen fontLoader klass mby? 
    public void fontLoader(){
        // load font from a .ttf file
        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("/data/slkscr.ttf");

            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            font = font.deriveFont(32f); // set font size
            trueTypePixelFont = new TrueTypeFont(font, false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initTimerSetup() throws SlickException {
        timerBox = new Image("data/timerBox.png");
    }

    public void initJumpingBeer() throws SlickException{
        jumpingBeer = new Image("data/beerChugging/jumpingBeer_V2.png");
        jumpingBeerRect = new Rectangle(160, 665, greenThingyWidth, greenThingyHeight);
    }

    public void initGreenThingy() throws SlickException{
        greenThingy = new Image("data/beerChugging/green_thingy_V2.png");
        greenThingyReact = new Rectangle(158, 630, jumpingBeerWidth, jumpingBeerHeight);
    }

    public void initBeerChuggingIndicator() throws SlickException {
        inidcatorImage = new Image("data/beerChugging/Bar_Indicator_v3.png");
        indicatorLocation = new Point(100, 300);
    }

    public void initChuggingAnimation() throws SlickException {
        chuggingAnimation = new SpriteSheet("data/beerChugging/beerchugging_mini_V3.png", 64,64);
        currentChugAnimation = chuggingAnimation.getSubImage(0,0);
    }

    public void updateChug(int index){

        currentChugAnimation = chuggingAnimation.getSubImage(index, 0);
    }

    public Point getIndicatorLocation() {
        return indicatorLocation;
    }

    public Rectangle getGreenThingyLocation(){
        return greenThingyReact;
    }

    public void setGreenThingyLocation(int greenThingyReactLocation) {
        this.greenThingyReact.y = greenThingyReactLocation;
    }

    public int getJumpingBeerLocationY() {
        return jumpingBeerRect.y;
    }

    public int getJumpingBeerLocationX(){
        return jumpingBeerRect.x;
    }

    public void setJumpingBeerLocationY(int jumpingBeerLocation) {
        this.jumpingBeerRect.y = jumpingBeerLocation;
    }
}
