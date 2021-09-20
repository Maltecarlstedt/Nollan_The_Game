package model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class PlayerModel {

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

    public Animation currentAnimation;

    /**
     * Creates an idle, basic player in the center of our window
     */
    public PlayerModel() throws SlickException {

        //TODO: Gör en try catch här för att slippa throwa slickException i playerController
        location = new Point(1024/2, 768/2);
        width = 64;
        height = 64;
        orientation = Orientation.IDLE;
        initPlayer();

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
            MoveRightAni.addFrame(MoveRight.getSubImage(i, 0), 200);
            MoveLeftAni.addFrame(MoveLeft.getSubImage(i, 0), 200);
            MoveUpAni.addFrame(MoveUp.getSubImage(i, 0), 200);

        }
    }

    /**
     * Creates all of our sprites, which basically is an image that we split up into 4 different subimages.
     * Reason being that we use these 4 subimages to create an animation.
     * @throws SlickException throws an exception if the file for the SpriteSheet is not found.
     */
    public void spriteSetup() throws SlickException {

        MoveRight = new SpriteSheet("data/playerAnimation/gubbeRIGHT.spritesheet_V3.png",64,64); // declare a SpriteSheet and load it into java with its dimentions
        MoveLeft = new SpriteSheet("data/playerAnimation/gubbeLEFT.spritesheet_V4.png",64,64); // declare a SpriteSheet and load it into java with its dimentions
        MoveUp = new SpriteSheet("data/playerAnimation/gubbeUP.spritesheet_V3.png",64,64); // declare a SpriteSheet and load it into java with its dimentions
        MoveDown = new SpriteSheet("data/playerAnimation/gubbeDOWN.spritesheet_V5.png",64,64); // declare a SpriteSheet and load it into java with its dimentions
    }

    /**
     * Initiates all the attributes for our player.
     * @throws SlickException throws an exception if the file for the SpriteSheet is not found.
     */
    public void initPlayer() throws SlickException {
        spriteSetup();
        animationSetup();
        currentAnimation = MoveDownAni;
    }

    public void startAnimation(){
        if(currentAnimation.isStopped()){
            currentAnimation.start();
        }

    }

    /**
     * Moves our player depending on the orientation. Our delta-values changes depending on the orientation
     * (check the model.Orientation enum for more precise explanation)
     */
    public void move() {
        startAnimation();
        location.x += orientation.deltaX;
        location.y += orientation.deltaY;
    }

    /**
     * Moves the character up, changes state so that if the player is IDLE, the player will use the right IDLE state
     * (I.E it will stand still in state UP)
     */
    public void moveUp() {
        orientation = Orientation.UP;
        move();
        currentAnimation = MoveUpAni;
    }

    /**
     * Moves the character to the left, changes state so that if the player is IDLE, the player will use the right IDLE state
     */
    public void moveLeft() {
        orientation = Orientation.LEFT;
        move();
        currentAnimation = MoveLeftAni;
    }

    /**
     * Moves the character to the right, changes state so that if the player is IDLE, the player will use the right IDLE state
     */
    public void moveRight() {
        orientation = Orientation.RIGHT;
        move();
        currentAnimation = MoveRightAni;
    }

    /**
     * Moves the character down, changes state so that if the player is IDLE, the player will use the right IDLE state
     */
    public void moveDown() {
        orientation = Orientation.DOWN;
        move();
        currentAnimation = MoveDownAni;
    }

    /**
     * Sets the still image so that the player just stops in its track. Depending on which state is set,
     * which is given by which key was most lately pressed down.
     * @return
     */
    public void idlePlayer() {
        currentAnimation.stop();
        currentAnimation.setCurrentFrame(1);
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
