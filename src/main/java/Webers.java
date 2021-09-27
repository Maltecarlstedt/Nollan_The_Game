import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class Webers extends NPC {

    //TODO: Gör till singleton

    public Webers() throws SlickException {
        width = 64;
        height = 128;
        state = 0;
        location = new Point(700, 200);
        //NPCLocation = new Rectangle(500, 380, width, height);
        initNPC();
    }

    @Override
    public void spriteSetup() throws SlickException {
        task = new SpriteSheet("data/NPC/webersTASK128x128_NOBLINK.png", 64, 128);
        animation = new Animation();
        animation.addFrame(task.getSubImage(0, 0), 200);
        animation.addFrame(task.getSubImage(1, 0), 200);

    }

    //onödig?
    @Override
    public void initNPC() throws SlickException {
        spriteSetup();
    }

    @Override
    public void render(GameContainer gc, Graphics g){
        g.drawAnimation(animation, getLocation().x, getLocation().y);
    }

    @Override
    public void setLocation(int x, int y) {
        location.x = x;
        location.y = y;
    }

    @Override
    public Point getLocation(){
        return location;
    }

}



