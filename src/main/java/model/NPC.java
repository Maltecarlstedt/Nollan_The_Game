package model;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class NPC {
    private int width, height;

    //state 1 elr 0, task complete eller inte, alternerar bild med/utan utroptecken
    private int state;
    private Point location;

    public SpriteSheet task;
    public SpriteSheet taskComplete;
    public Animation animation;

    public NPC() {
        width = 64;
        height = 64;
    }

    public void spriteSetup() throws SlickException {
        //task = new SpriteSheet("data/NPC/webersTASK36x40.png", 18, 40);
        animation = new Animation();
        animation.addFrame(task.getSubImage(0, 0), 200);
        animation.addFrame(task.getSubImage(1, 0), 200);

    }

    public void NPCsetup() throws SlickException {
        spriteSetup();
    }

    public void setLocation(int x, int y) {
        location.x = x;
        location.y = y;
    }
}
