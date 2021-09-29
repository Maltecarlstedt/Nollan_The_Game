package Tasks.taskModel;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import java.util.Random;

public class Pant {

    private Rectangle pantLocation = new Rectangle(0, 0, 32, 32);

    private Random random = new Random();

    Image image = new Image("data/maps/images/pripps_pant.png");

    public Pant() throws SlickException {
        init();
    }

    private void init(){
        newPant();
    }

    // Create new pant randomly on the screen to collect
    public void newPant() {
        pantLocation.setX(random.nextInt((int)(1024/32))*32); // pant på en ruta som är 32x32
        pantLocation.setY(random.nextInt((int)(768/32))*32); // pant på en ruta som är 32x32
    }

    public Image getImage() {
        return image;
    }

    public Rectangle getPantLocation() {
        return pantLocation;
    }
}
