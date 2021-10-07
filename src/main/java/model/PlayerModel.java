package model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * A class that holds all the data on our player
 */
public class PlayerModel {

    private final int width = 64, height = 64;
    private Orientation orientation;
    /** The location stored as a rectangle so we can use the "intercepts(Shape s)"-method in CollisionChecker */
    private Rectangle playerLocation = new Rectangle(512, 384, width, height);

    /** The different sprites (an image that can be split up into multiple images) and animations
     * depending on the orientation the player moves in */
    public SpriteSheet MoveRight; // initate a SpriteSheet
    public Animation MoveRightAni; // initate an Animation

    public SpriteSheet MoveLeft; // initate a SpriteSheet
    public Animation MoveLeftAni; // initate an Animation

    public SpriteSheet MoveUp; // initate a SpriteSheet
    public Animation MoveUpAni; // initate an Animation

    public SpriteSheet MoveDown; // initate a SpriteSheet
    public Animation MoveDownAni; // initate an Animation

    /** The current animation, this changes depending on which direction the player is moving in */
    public Animation currentAnimation;



    /**
     * Creates an idle, basic player in the center of our window
     */
    public PlayerModel() throws SlickException {
        //TODO: Gör en try catch här för att slippa throwa slickException i playerController?
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

    /**
     * Starts the walking animation if it is stopped (it gets stopped when the player has been idle)
     */
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
        System.out.println(playerLocation);
        setNewPlayerTile(nextX(), nextY());
    }

    /**
     * sets the location of the player
     * @param x - the value of x
     * @param y - the value of y
     */
    public void setNewPlayerTile(int x, int y) {
        playerLocation.setRect(x, y, width, height);

    }

    /**
     * Moves the character up and changes the current animation accordingly
     */
    public void moveUp() {
        move();
        orientation = Orientation.UP;
        currentAnimation = MoveUpAni;
    }

    /**
     * Moves the character left and changes the current animation accordingly
     */
    public void moveLeft() {
        move();
        orientation = Orientation.LEFT;
        currentAnimation = MoveLeftAni;
    }

    /**
     * Moves the character right and changes the current animation accordingly
     */
    public void moveRight() {
        move();
        orientation = Orientation.RIGHT;
        currentAnimation = MoveRightAni;
    }

    /**
     * Moves the character down and changes the current animation accordingly
     */
    public void moveDown() {
        move();
        orientation = Orientation.DOWN;
        currentAnimation = MoveDownAni;
    }

    /**
     * Stops the walking animation and makes the player idle.
     */
    public void idlePlayer() {
        currentAnimation.stop();
        currentAnimation.setCurrentFrame(1);

        orientation = Orientation.IDLE;
    }

    /**
     * Set player's orientation
     * @param orientation player's orientation
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * @return the next X position for the player
     */
    public int nextX(){
        return playerLocation.x + orientation.deltaX;
    }

    /**
     * @return the next Y position for the player
     */
    public int nextY(){
        return playerLocation.y + orientation.deltaY;
    }

    /**
     * @return the player's next location tile
     */
    public Rectangle getNextLocation(){
        return new Rectangle(nextX(), nextY(), width, height);
    }

    public Rectangle2D getPlayerLocation() {
        return playerLocation;
    }
}