package Tasks.taskModel;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import java.util.Random;

/** Creates the basics behind a can for the task "Gathering can" with image and coordinates.
 * @author Steffanie Kristiansson
 * @author Alexander Brunnegård
 */
public class Cans {

    /** Creates a rectangle as the location for the can, with height and width as big as a tile.
     */
    private Rectangle canLocation = new Rectangle(0, 0, 32, 32);

    private Random random = new Random();

    /** The specific image of the can.
     */
    Image image = new Image("data/maps/images/pripps_can.png");


    /** Initiating the can.
     * @throws SlickException if file not found, slick-exception.
     */
    public Cans() throws SlickException {
        init();
    }


    /** Initialize Can to create a new can.
     */
    private void init(){
        newCan();
    }


    /** Create new can randomly on the screen.
     */
    public void newCan() {
        canLocation.setX(random.nextInt((int)(1024/32))*32); // can on a square 32x32
        canLocation.setY(random.nextInt((int)(768/32))*32); // can on a square 32x32
    }


    /** Gets the image of the can.
     * @return an image representing the can-image.
     */
    public Image getImage() {
        return image;
    }


    /** Gets the location of a can.
     * @return a rectangle representing the location of a can.
     */
    public Rectangle getCanLocation() {
        return canLocation;
    }
}
