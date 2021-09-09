import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;

public class Player {

    /**
     * Creates variables for a player object
     * Spritesheets are Images that we split up to create our animations of walking
     * currentImage has the current image when the player is IDLE
     * currentAnimation is an animation that changes depending on which orientation the player has
     * State gives the state that the player is in. I.E which way the player is facing
     */
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


    /**
     * Creates an idle, basic player in the center of our window
     */
    public Player(){
        location = new Point(1024/2, 768/2);
        width = 64;
        height = 64;
        orientation = Orientation.IDLE;
    }

    /**
     * Sets up our animation that we use for walking in game
     */
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

    /**
     * Creates all of our sprites, which basically is an image that we split up into 4 different subimages.
     * Reason being that we use these 4 subimages to create an animation.
     * @throws SlickException throws an exception if the file for the SpriteSheet is not found.
     */
    public void spriteSetup() throws SlickException {//TODO: Borde skala vår gubbe här direkt till 64x64?
        MoveRight = new SpriteSheet("data/playerAnimation/gubbeRIGHT.spritesheet.png",1841/4,600); // declare a SpriteSheet and load it into java with its dimentions
        MoveLeft = new SpriteSheet("data/playerAnimation/gubbeLEFT.spritesheet.png",1841/4,600); // declare a SpriteSheet and load it into java with its dimentions
        MoveUp = new SpriteSheet("data/playerAnimation/gubbeUP.spritesheet.png",1841/4,600); // declare a SpriteSheet and load it into java with its dimentions
        MoveDown = new SpriteSheet("data/playerAnimation/gubbeDOWN.spritesheet.png",1841/4,600); // declare a SpriteSheet and load it into java with its dimentions

    }

    /**
     * Initiates all the attributes for our player.
     * @throws SlickException throws an exception if the file for the SpriteSheet is not found.
     */
    public void initPlayer() throws SlickException {
        spriteSetup();
        animationSetup();

        currentImage = MoveDownAni.getImage(1);

    }

    /**
     * @return player's height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return player's width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return player's location
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Set player's coordinates
     * @param x player's x coordinate
     * @param y player's y coordinate
     */
    public void setLocation(int x, int y) {
        location.x = x;
        location.y = y;
    }

    /**
     * Set player's orientation
     * @param orientation player's orientation
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * @return player's orientation as the enum we created
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * set player's location
     * @param location player's location as a Point
     */
    public void setLocation(Point location) {
        this.location = location;
    }

    /**
     * Moves our player depending on the orientation. Our delta-values changes depending on the orientation
     * (check the Orientation enum for more precise explanation)
     */
    public void move() {
        location.x += orientation.deltaX * 2;
        location.y += orientation.deltaY * 2;
    }

    /**
     * Moves the character up, changes state so that if the player is IDLE, the player will use the right IDLE state
     * (I.E it will stand still in state UP)
     */
    public void moveUp() {
        setOrientation(Orientation.UP);
        move();
        currentAnimation = MoveUpAni;
        state = 3;
    }

    /**
     * Moves the character to the left, changes state so that if the player is IDLE, the player will use the right IDLE state
     */
    public void moveLeft() {
        setOrientation(Orientation.LEFT);
        move();
        currentAnimation = MoveLeftAni;
        state = 2;
    }

    /**
     * Moves the character to the right, changes state so that if the player is IDLE, the player will use the right IDLE state
     */
    public void moveRight() {
        setOrientation(Orientation.RIGHT);
        move();
        currentAnimation = MoveRightAni;
        state = 1;
    }

    /**
     * Moves the character down, changes state so that if the player is IDLE, the player will use the right IDLE state
     */
    public void moveDown() {
        setOrientation(Orientation.DOWN);
        move();
        currentAnimation = MoveDownAni;
        state = 0;
    }

    /**
     * Sets the still image so that the player just stops in its track. Depending on which state is set,
     * which is given by which key was most lately pressed down.
     */
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