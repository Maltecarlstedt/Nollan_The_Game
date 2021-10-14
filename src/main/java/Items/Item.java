package Items;

import model.MapStates.MapState;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;

public abstract class Item {
    boolean isShowing;
    MapState currentMap;
    Rectangle location;
    public Image img;

    public abstract void render(Graphics g);

    public abstract void setShowing(boolean isItShowing);

    public abstract MapState getCurrentMap();

    private int getStartX(){ return 710;}
    private int getStartY(){ return 725;}

}
