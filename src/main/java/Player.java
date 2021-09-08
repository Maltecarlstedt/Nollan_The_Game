import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class Player {
    private Point location;
    private int width, height;
    private Orientation orientation;

    public SpriteSheet MoveRight; // initate a SpriteSheet
    public Animation MoveRightAni; // initate an Animation

    public SpriteSheet MoveLeft; // initate a SpriteSheet
    public Animation MoveLeftAni; // initate an Animation

    public SpriteSheet MoveUp; // initate a SpriteSheet
    public Animation MoveUpAni; // initate an Animation

    public SpriteSheet MoveDown; // initate a SpriteSheet
    public Animation MoveDownAni; // initate an Animation

    public Image currentImage;

    public Animation currentAnimation;

    private int state = 0;

    public Player(){
        location = new Point(1024/2, 768/2);
        width = 64;
        height = 64;
        orientation = Orientation.IDLE;

    }

    public void animationSetup(){
        MoveDownAni = new Animation();
        MoveLeftAni = new Animation();
        MoveRightAni = new Animation();
        MoveUpAni = new Animation();

        for(int i = 0; i <= 3; i++){
            MoveDownAni.addFrame(MoveDown.getSubImage(i, 0), 200);
        }
        for(int i = 0; i <= 3; i++){
            MoveRightAni.addFrame(MoveRight.getSubImage(i, 0), 200);
        }
        for(int i = 0; i <= 3; i++){
            MoveLeftAni.addFrame(MoveLeft.getSubImage(i, 0), 200);
        }
        for(int i = 0; i <= 3; i++){
            MoveUpAni.addFrame(MoveUp.getSubImage(i, 0), 200);
        }
    }

    public void spriteSetup() throws SlickException {
        MoveRight = new SpriteSheet("data/playerAnimation/gubbeRIGHT.spritesheet.png",1841/4,600); // declare a SpriteSheet and load it into java with its dimentions
        MoveLeft = new SpriteSheet("data/playerAnimation/gubbeLEFT.spritesheet.png",1841/4,600); // declare a SpriteSheet and load it into java with its dimentions
        MoveUp = new SpriteSheet("data/playerAnimation/gubbeUP.spritesheet.png",1841/4,600); // declare a SpriteSheet and load it into java with its dimentions
        MoveDown = new SpriteSheet("data/playerAnimation/gubbeDOWN.spritesheet.png",1841/4,600); // declare a SpriteSheet and load it into java with its dimentions

    }

    public void initPlayer() throws SlickException {
        spriteSetup();
        animationSetup();

        currentImage = MoveDownAni.getImage(1);

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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
        this.location = location;
    }

    public void move() {
        location.x += orientation.deltaX * 2;
        location.y += orientation.deltaY * 2;
    }

    public void moveUp() {
        setOrientation(Orientation.UP);
        move();
        currentAnimation = MoveUpAni;
        state = 3;
    }

    public void moveLeft() {
        setOrientation(Orientation.LEFT);
        move();
        currentAnimation = MoveLeftAni;
        state = 2;
    }

    public void moveRight() {
        setOrientation(Orientation.RIGHT);
        move();
        currentAnimation = MoveRightAni;
        state = 1;
    }

    public void moveDown() {
        setOrientation(Orientation.DOWN);
        move();
        currentAnimation = MoveDownAni;
        state = 0;
    }

    public void idlePlayer() {

        switch (state){
            case 0:
                this.setOrientation(Orientation.IDLE);
                currentImage = MoveDownAni.getImage(1);
                break;
            case 1:
                this.setOrientation(Orientation.IDLE);
                currentImage = MoveRightAni.getImage(1);
                break;
            case 2:
                this.setOrientation(Orientation.IDLE);
                currentImage = MoveLeftAni.getImage(0);
                break;
            case 3:
                this.setOrientation(Orientation.IDLE);
                currentImage = MoveUpAni.getImage(1);
                break;
                //TODO: DEFAULT STATE FÖR IDLE, NER?
        }

    }
}