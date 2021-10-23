package view;

import model.PlayerModel;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.util.ArrayList;


/**
 * Our view of the player. The class that draws the player.
 */
public class PlayerView {

    /** The different sprites (an image that can be split up into multiple images) and animations
     * depending on the orientation the player moves in */
    public static SpriteSheet moveRight;
    public static SpriteSheet moveDown;
    public static SpriteSheet moveLeft;
    public static SpriteSheet moveUp;

    public static Animation moveRightAni; // initiate an Animation
    public static Animation moveLeftAni; // initiate an Animation
    public static Animation moveUpAni; // initiate an Animation
    public static Animation moveDownAni; // initiate an Animation

    public static Animation currentAnimation;

    public PlayerView() throws SlickException {
        initView();
    }

    /**
     * Draws the player on the canvas
     * @param g The graphics context to be used for rendering
     * @param playerModel Model of the player that is to be rendered
     */
    public void render(Graphics g, PlayerModel playerModel){
        //g.drawAnimation(currentAnimation, (float)playerModel.getPlayerLocation().getX(), (float)playerModel.getPlayerLocation().getY());
        currentAnimation.draw((float)playerModel.getPlayerLocation().getX(), (float)playerModel.getPlayerLocation().getY(), playerModel.getWidth(), playerModel.getHeight());
    }

    private void initView() throws SlickException {
        spriteSetup();
        animationSetup();
    }

    /**
     * Creates all of our sprites, which basically is an image that we split up into 4 different subimages.
     * Reason being that we use these 4 subimages to create an animation.
     * @throws SlickException throws an exception if the file for the SpriteSheet is not found.
     */
    public void spriteSetup() throws SlickException {
        moveRight = new SpriteSheet("data/playerAnimation/gubbeRIGHT.spritesheet_V3.png",64,64); // declare a SpriteSheet and load it into java with its dimentions
        moveLeft = new SpriteSheet("data/playerAnimation/gubbeLEFT.spritesheet_V4.png",64,64); // declare a SpriteSheet and load it into java with its dimentions
        moveUp = new SpriteSheet("data/playerAnimation/gubbeUP.spritesheet_V3.png",64,64); // declare a SpriteSheet and load it into java with its dimentions
        moveDown = new SpriteSheet("data/playerAnimation/gubbeDOWN.spritesheet_V5.png",64,64); // declare a SpriteSheet and load it into java with its dimentions
    }

    /**
     * Sets up our animation that we use for walking in game
     */
    public void animationSetup(){
        moveDownAni = new Animation();
        moveLeftAni = new Animation();
        moveRightAni = new Animation();
        moveUpAni = new Animation();

        for(int i = 0; i <= 3; i++){
            moveDownAni.addFrame(moveDown.getSubImage(i, 0), 200);
            moveRightAni.addFrame(moveRight.getSubImage(i, 0), 200);
            moveLeftAni.addFrame(moveLeft.getSubImage(i, 0), 200);
            moveUpAni.addFrame(moveUp.getSubImage(i, 0), 200);
        }

        currentAnimation = moveDownAni;
    }
    public void movingDown() {
        startAnimation();
        currentAnimation = moveDownAni;
    }
    public void movingUp() {
        startAnimation();
        currentAnimation = moveUpAni;
    }
    public void movingLeft() {
        startAnimation();
        currentAnimation = moveLeftAni;
    }
    public void movingRight() {
        startAnimation();
        currentAnimation = moveRightAni;

    }

    public void idlePlayer(){
        currentAnimation.stop();
        currentAnimation.setCurrentFrame(1);
    }

    /**
     * Starts the walking animation if it is stopped (it gets stopped when the player has been idle)
     */
    public void startAnimation(){
        if(currentAnimation.isStopped()){
            currentAnimation.start();
        }
    }
}
