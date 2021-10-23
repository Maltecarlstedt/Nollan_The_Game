package Tasks.taskModel;

import Tasks.Highscores;
import model.MapStates.Ekak;
import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Model for the beer chugging task
 */
public class BeerChuggingModel {

    private Highscores hs = new Highscores("data/highscore.txt", true); // TODO kommentera
    private final int greenThingyHeight = 64, greenThingyWidth = 30;
    private final int jumpingBeerHeight = 24, jumpingBeerWidth = 30;

    /** Invisible rectangle for the jumping beer and green indicator location.
     * Using a rectangle to make calculate when the two are intersecting
     */
    public Rectangle jumpingBeerRect;
    public Rectangle greenThingyReact;
    /** Where the indicator bar is to be drawn */
    private Point indicatorLocation;
    public Image inidcatorImage;
    public Image greenThingy;
    public Image jumpingBeer;
    public Image timerBox;
    public Image highScoreBox;

    public ArrayList<Double> beerChuggingHighScore; //todo kommentera

    public TrueTypeFont trueTypePixelFont;

    /** Variable for time that has passed since the task started */
    public float timePassed;

    /** Boolean for if the jumping beer is inside the green indicator */
    public boolean inside;

    public SpriteSheet chuggingAnimation;
    public Image currentChugAnimation;

    public boolean isTaskFinished = false;
    public boolean isTaskRunning;

    private TiledMap background;
    /**
     * A constructor that initiates all resources needed for this task when created.
     * @throws SlickException Generic exception
     */
    public BeerChuggingModel() throws SlickException{
        // TODO: Make this prettier if possible.
        //TODO: Sätt ihop dom här till en lol
        isTaskRunning = true;
        initBeerChuggingIndicator();
        initGreenThingy();
        initJumpingBeer();
        initChuggingAnimation();
        fontLoader();
        initTimerSetup();
        initHighScoreBox();
        readHighScoreList();
        background = Ekak.EKAK.loadMap();
    }

    /**
     * Function for fetching and loading a custom pixel font for the timer.
     */
    public void fontLoader(){
        //TODO: Make a font loading class on its own since it's not really makes sense having here.

        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("/data/slkscr.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            font = font.deriveFont(32f); // set font size
            trueTypePixelFont = new TrueTypeFont(font, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Fetches the image for the box where the timer will be placed inside
     * @throws SlickException Generic exception
     */
    public void initTimerSetup() throws SlickException {
        timerBox = new Image("data/timerBox.png");
    }

    /**
     * Fetches the image for the jumping beer and sets it's starting location.
     * @throws SlickException Generic exception
     */
    public void initJumpingBeer() throws SlickException{
        jumpingBeer = new Image("data/beerChugging/jumpingBeer_V2.png");
        jumpingBeerRect = new Rectangle(160, 665, greenThingyWidth, greenThingyHeight);
    }

    /**
     * Fetches the image for the jumping beer and sets it's starting location.
     * @throws SlickException Generic exception
     */
    public void initGreenThingy() throws SlickException{
        greenThingy = new Image("data/beerChugging/green_thingy_V2.png");
        greenThingyReact = new Rectangle(158, 630, jumpingBeerWidth, jumpingBeerHeight);
    }

    /**
     * Fetches the image for the jumping beer and sets it's starting location.
     * @throws SlickException Generic exception
     */
    public void initBeerChuggingIndicator() throws SlickException {
        inidcatorImage = new Image("data/beerChugging/Bar_Indicator_v3.png");
        indicatorLocation = new Point(100, 300);
    }

    /**
     * Fetches the image for the jumping beer and sets it's starting image.
     * @throws SlickException Generic exception
     */
    public void initChuggingAnimation() throws SlickException {
        chuggingAnimation = new SpriteSheet("data/beerChugging/beerchugging_mini_V3.png", 64,64);
        currentChugAnimation = chuggingAnimation.getSubImage(0,0);
    }

    public void initHighScoreBox() throws SlickException {
        highScoreBox = new Image("data/highScoreBox.png");

    }

    public void readHighScoreList(){
        //Read the top 5 score from our save
        beerChuggingHighScore = hs.readHighScore();
        hs.trimHighscore(beerChuggingHighScore);
    }

    public void addHighScore(){
        // Try to add our score we just got.
        String time = String.valueOf(timePassed);
        try {
            hs.writeHighScore(time);
        }catch (IOException e){
            e.printStackTrace();
        }
        // Even though the player might not be top 5 we add his or hers score either way.
        beerChuggingHighScore.add(Double.parseDouble(time));
        Collections.sort(beerChuggingHighScore);
    }

    /** Changes sprite image to be drawn */
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

    public TiledMap getBackground() {
        return background;
    }

    public void setJumpingBeerLocationY(int jumpingBeerLocation) {
        this.jumpingBeerRect.y = jumpingBeerLocation;
    }
}
