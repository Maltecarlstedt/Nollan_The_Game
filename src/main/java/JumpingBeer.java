import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.xml.GameData;


import java.awt.*;

public class JumpingBeer{


    public Point location;
    public int height;
    public int width;
    public boolean onGround = true;


   
    public double prevTime = 0;

    //public double  currentTime = gameState.getCurrentTime();
    public double dt;



    public Image jumpingBeer;

    public JumpingBeer(){



        location = new Point(136, 635);
        width = 48;
        height = 48;
    }

    public void initJumpingBeer() throws SlickException {
        jumpingBeer = new Image("data/beerChugging/beerImage.png");
    }
    
    public Point getLocation() {
        return location;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
