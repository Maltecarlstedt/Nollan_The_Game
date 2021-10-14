package Items;

import model.MapStates.MapState;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public abstract class Item {
    public boolean isShowing;
    public MapState currentMap;
    public Rectangle location;
    public Image img;

    public abstract void render(Graphics g);

    public abstract void setShowing(boolean isItShowing);

    public MapState getCurrentMap(){return currentMap;}

    public int getStartX(){ return 710;}
    public int getStartY(){ return 725;}

}
