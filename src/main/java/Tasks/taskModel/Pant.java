package Tasks.taskModel;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import java.util.Random;

/** Creates the basics behind a pant for the task "Gathering pant".
 * @auther Steffanie Kristiansson
 */
public class Pant {

    /** Creates a rectangle as the location for the pant, with height and width as big as a tile.
     */
    private Rectangle pantLocation = new Rectangle(0, 0, 32, 32);

    private Random random = new Random();

    /** The specific image of the pant.
     */
    Image image = new Image("data/maps/images/pripps_pant.png");


    /** Initiating the pant.
     * @throws SlickException if file not found, slick-exception.
     */
    public Pant() throws SlickException {
        init();
    }


    /** Method-call to create a new pant.
     */
    private void init(){
        newPant();
    }


    /** Create new pant randomly on the screen.
     */
    public void newPant() {
        pantLocation.setX(random.nextInt((int)(1024/32))*32); // pant på en ruta som är 32x32
        pantLocation.setY(random.nextInt((int)(768/32))*32); // pant på en ruta som är 32x32
    }


    /** Gets the image of the pant.
     * @return an image representing the pant-image.
     */
    public Image getImage() {
        return image;
    }


    /** Gets the location of a pant.
     * @return a rectangle representing the location of a pant.
     */
    public Rectangle getPantLocation() {
        return pantLocation;
    }
}
