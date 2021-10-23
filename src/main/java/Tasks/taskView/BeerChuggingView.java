package Tasks.taskView;

import Tasks.taskModel.BeerChuggingModel;
import model.MapStates.Ekak;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

/**
 * @author Malte Carlstedt
 */
public class BeerChuggingView {

    private static Image barIndicatorImage;
    /** Where the indicator bar is to be drawn */
    //private final Point barIndicatorLocation = (100,300);
    private static Image greenIndicatorImage;
    private static Image jumpingBeer;
    private static Image timerBox;
    private static Image highScoreBox;
    public static SpriteSheet chuggingAnimation;
    public static Image currentChugAnimation;

    private TiledMap background;

    public BeerChuggingView() throws SlickException {
        initImage();
    }

    /**
     * Draws everything to the canvas
     * @param g The grapchics context to be used for rendering
     * @param bcm The model where we collect what is to be drawn.
     */
    public void render(Graphics g, BeerChuggingModel bcm){
        background.render(0,0);
        if(bcm.isTaskRunning){
            // Renders the brown bar
            g.drawImage(barIndicatorImage, 100, 300);
            // Renders the green indicator.
            g.drawImage(greenIndicatorImage, bcm.getGreenIndicatorLocation().x, bcm.getGreenIndicatorLocation().y);

           //TODO: Make a method so that we do NOT have logic inside our render method.
           if (bcm.beerInside){
               // Draw a flash variant of the image to indicate that the jumping beer is inside.
               jumpingBeer.drawFlash(bcm.getJumpingBeerLocationX(), bcm.getJumpingBeerLocationY());
           }else{
               // Renders the regular beer if it's not inside.
               g.drawImage(jumpingBeer, bcm.getJumpingBeerLocationX(), bcm.getJumpingBeerLocationY());
           }
        }

        // Draw the player chugging beer.
        currentChugAnimation.startUse();
        currentChugAnimation.drawEmbedded(1024/2, 720/2, 64,64);
        currentChugAnimation.endUse();

        // Render our box that will have the timer inside of it.
        timerBox.startUse();
        timerBox.drawEmbedded(820, 40, 128, 64);
        timerBox.endUse();

        highScoreBox.startUse();
        highScoreBox.drawEmbedded(820, 140, 128, 195);
        highScoreBox.endUse();


        g.drawString("Your score: ", 820, 20);
        g.drawString("Highscore: ", 820, 120);


        // TODO: Make a method so that the string is always centered.
        // Render the timer.
        g.drawString(String.valueOf(bcm.timePassed), 835,55);

        for(int i = 0; i < bcm.beerChuggingHighScore.size(); i++){
            g.drawString(String.valueOf(bcm.beerChuggingHighScore.get(i)), 835, 150 + i*35 );
        }
        if(bcm.isTaskFinished){
            g.drawString("Bra supit, Din tid blev " + bcm.timePassed, 200, 768/2);
            g.drawString("Tryck på 'f' för att fortsätta ", 200, 600);
        }
    }

    /**
     * Fetches the image for the jumping beer and sets it's starting image.
     * @throws SlickException Generic exception
     */
    public void initChuggingAnimation() throws SlickException {
        chuggingAnimation = new SpriteSheet("data/beerChugging/beerchugging_mini_V3.png", 64,64);
        currentChugAnimation = chuggingAnimation.getSubImage(0,0);
    }
    /**
     * Fetches the image for the jumping beer and sets it's starting location.
     * @throws SlickException Generic exception
     */

    public void initBeerChuggingIndicator() throws SlickException {
        barIndicatorImage = new Image("data/beerChugging/Bar_Indicator_v3.png");
    }
    /**
     * Fetches the image for the jumping beer and sets it's starting location.
     * @throws SlickException Generic exception
     */
    public void initGreenIndicator() throws SlickException{
        greenIndicatorImage = new Image("data/beerChugging/green_thingy_V2.png");
    }
    /**
     * Fetches the image for the jumping beer and sets it's starting location.
     * @throws SlickException Generic exception
     */
    public void initJumpingBeer() throws SlickException{
        jumpingBeer = new Image("data/beerChugging/jumpingBeer_V2.png");
    }

    /**
     * Fetches the image for the box where the timer will be placed inside
     * @throws SlickException Generic exception
     */
    public void initTimerSetup() throws SlickException {
        timerBox = new Image("data/boxes/timerBox.png");
    }

    /**
     * Fetches the image for the box where the highscore will be displayed upon.
     * @throws SlickException Generic exception
     */
    public void initHighScoreBox() throws SlickException {
        highScoreBox = new Image("data/boxes/highScoreBox_V2.png");
    }

    private void initImage() throws SlickException {
        initBeerChuggingIndicator();
        initGreenIndicator();
        initJumpingBeer();
        initHighScoreBox();
        initTimerSetup();
        initChuggingAnimation();
        background = Ekak.INSTANCE.loadMap();
    }
}
