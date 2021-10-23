package Tasks.taskView;

import Tasks.taskModel.GatheringCansModel;
import model.MapStates.DeltaP;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;

/** The view of Gathering Cans printing the high-scores and time passed. Uses Gathering Cans Model.
 * @author Steffanie Kristiansson
 * @author Alexander Brunnegård
 */
public class GatheringCansView {

    public Image timerBox;
    public Image highScoreBox;
    private TiledMap background;

    public GatheringCansView() throws SlickException {
        init();
    }

    public void init() throws SlickException {
        background = DeltaP.DELTAP.loadMap();
        initHighScoreBox();
        initTimerSetup();
    }

    /** Method to draw each can and the timer box.
     * @param g represents the graphics context to be used for rendering.
     * @param gcm representing the model to get data from it.
     */
    public void render (Graphics g, GatheringCansModel gcm) throws SlickException {
        getBackground().render(0,0);

        g.drawImage(timerBox,820, 40);

        g.drawImage(highScoreBox, 820, 140);

        g.drawString("Your score: ", 820, 20);
        g.drawString("Highscore: ", 820, 120);

        // Render the timer.
        g.drawString(String.valueOf(gcm.getTaskTimer()), 835,55);
        g.drawString(String.valueOf(gcm.getScore()), 835,75);
        for(int i = 0; i < gcm.getCanHighscore().size(); i++){
            int number = gcm.getCanHighscore().get(i).intValue();
            g.drawString(String.valueOf(number), 835, 155 + i*35);
        }

        // the mouse
        if(gcm.isRunning){
            g.setColor(Color.cyan);
            g.fill(gcm.mouseBall);

            g.setColor(Color.white);

            // Render our box that will have the timer inside of it.

        } else{
            g.drawString("Bra plockat!", 400, 400);
            g.drawString("Tryck F för att avsluta uppdraget.", 400, 440);
        }

        for(Rectangle cans : gcm.getCans()){
            g.drawImage(getImage(), cans.getX(), cans.getY());

        }
    }


    /**
     * Fetches the image for the box where the timer will be placed inside
     * @throws SlickException Generic exception
     */
    public void initTimerSetup() throws SlickException {
        timerBox = new Image("data/boxes/timerBox.png");
    }

    /** Initialize the high-score box.
     * @throws SlickException if file not found, slick-exception.
     */
    public void initHighScoreBox() throws SlickException {
        highScoreBox = new Image("data/boxes/highScoreBox_V2.png");
    }

    public TiledMap getBackground() {
        return background;
    }

    /** The specific image of the can.
     */
    Image image = new Image("data/maps/images/pripps_can.png");

    /** Gets the image of the can.
     * @return an image representing the can-image.
     */
    public Image getImage() {
        return image;
    }

}
