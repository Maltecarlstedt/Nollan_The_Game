package model;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class NPC {

    private int width;
    private int height;
    //state 1 elr 0, task complete eller inte, alternerar bild med/utan utroptecken
    private int state;
   // private static Point location = new Point(300, 500);
    private Point location;
    protected Rectangle NPCLocation;

    public SpriteSheet task;
    public SpriteSheet taskComplete;
    public Animation animation;

    public NPC(int height, int width, int state, int y, int x) throws SlickException {
        this.width = width;
        this.height = height;
        this.state = state;
        location = new Point(x,y);


        //NPCLocation = new Rectangle(500, 380, width, height);
        initNPC();
    }

    public void spriteSetup() throws SlickException {
        task = new SpriteSheet("data/NPC/webersTASK128x128_NOBLINK.png", 64, 128);
        animation = new Animation();
        animation.addFrame(task.getSubImage(0, 0), 200);
        animation.addFrame(task.getSubImage(1, 0), 200);

    }

    public void initNPC() throws SlickException {
        spriteSetup();
    }

    public void render(GameContainer gc, Graphics g){
        g.drawAnimation(animation, getLocation().x, getLocation().y);
    }

    public void setLocation(int x, int y) {
        location.x = x;
        location.y = y;
    }

    public Point getLocation(){
        return location;
    }

}
