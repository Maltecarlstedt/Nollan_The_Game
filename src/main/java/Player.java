import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class Player {
    private Point location;
    private int width, height;
    private Orientation orientation;

    public SpriteSheet MoveRight; // initate a SprtieSheet
    public Animation MoveRightAni; // initate a Animation

    public SpriteSheet MoveLeft; // initate a SprtieSheet
    public Animation MoveLeftAni; // initate a Animation

    public SpriteSheet MoveUp; // initate a SprtieSheet
    public Animation MoveUpAni; // initate a Animation

    public SpriteSheet MoveDown; // initate a SprtieSheet
    public Animation MoveDownAni; // initate a Animation

    public Animation currentImage = MoveRightAni;

    private int state;



    public float x = 0;
    public float y = 0;

    public Player(){
        location = new Point(1024/2, 768/2);
        width = 45;
        height = 60;
        orientation = Orientation.IDLE;

    }

    public void animationSetup(){
        MoveDownAni = new Animation();
        MoveLeftAni = new Animation();
        MoveRightAni = new Animation();
        MoveUpAni = new Animation();

        for(int i = 0; i <= 3; i++){
            walkDownAnimation.addFrame(player.getSubImage(i, 0), 200);
        }
        for(int i = 0; i <= 3; i++){
            walkRightAnimation.addFrame(player.getSubImage(i, 1), 200);
        }
        for(int i = 0; i <= 3; i++){
            walkLeftAnimation.addFrame(player.getSubImage(i, 2), 200);
        }
        for(int i = 0; i <= 3; i++){
            walkUpAnimation.addFrame(player.getSubImage(i, 3), 200);
        }
    }

    public void initPlayer() throws SlickException {



        MoveRight = new SpriteSheet("data/playerAnimation/gubbeRIGHT.spritesheet.png",21,24); // declare a SpriteSheet and load it into java with its dimentions
        MoveRightAni = new Animation(MoveRight, 400); // declare a Animation, loading the SpriteSheet and inputing the Animation Speed

        for(int i = 0; i <= 3; i++){
            MoveRightAni.addFrame(MoveRight.getSubImage(), 200);
        }

        MoveLeft = new SpriteSheet("data/playerAnimation/gubbeLEFT.spritesheet.png",21,24); // declare a SpriteSheet and load it into java with its dimentions
        MoveLeftAni = new Animation(MoveLeft, 400); // declare a Animation, loading the SpriteSheet and inputing the Animation Speed

        MoveUp = new SpriteSheet("data/playerAnimation/gubbeUP.spritesheet.png",21,24); // declare a SpriteSheet and load it into java with its dimentions
        MoveUpAni = new Animation(MoveUp, 400); // declare a Animation, loading the SpriteSheet and inputing the Animation Speed

        MoveDown = new SpriteSheet("data/playerAnimation/gubbeDOWN.spritesheet.png",21,24); // declare a SpriteSheet and load it into java with its dimentions
        MoveDownAni = new Animation(MoveDown, 400); // declare a Animation, loading the SpriteSheet and inputing the Animation Speed


    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(int x, int y) {
        location.x = x;
        location.y = y;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setLocation(Point location) {
        location = location;
    }

    public void move() {
        location.x += orientation.deltaX * 2;
        location.y += orientation.deltaY * 2;
    }

    public void moveUp() {
        setOrientation(Orientation.UP);
        move();
        MoveUpAni.draw((float).getLocation().getX(), (float) player1.getLocation().getY(), 45, 60);
        state = 3;
    }

    public void moveLeft() {
    }

    public void moveRight() {
    }

    public void moveDown() {
    }
}