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

    public Image currentImage;

    public Animation currentAnimation;

    private int state = 0;


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
        Image down = new Image("data/playerAnimation/gubbeDOWN.spritesheet_V3.png").getScaledCopy(width*4,height);
        MoveRight = new SpriteSheet("data/playerAnimation/gubbeRIGHT.spritesheet_V2.png",18,18); // declare a SpriteSheet and load it into java with its dimentions
        MoveLeft = new SpriteSheet("data/playerAnimation/gubbeLEFT.spritesheet_V2.png",18,18); // declare a SpriteSheet and load it into java with its dimentions
        MoveUp = new SpriteSheet("data/playerAnimation/gubbeUP.spritesheet_V2.png",17,17); // declare a SpriteSheet and load it into java with its dimentions
        // TODO: This is fucked. :D 
        MoveDown = new SpriteSheet(down, width, height);
        // MoveDown = new SpriteSheet("data/playerAnimation/gubbeDOWN.spritesheet_V3.png",17,17); // declare a SpriteSheet and load it into java with its dimentions



    }

    /**
     * Initiates all the attributes for our player.
     * @throws SlickException throws an exception if the file for the SpriteSheet is not found.
     */
    public void initPlayer() throws SlickException {
        spriteSetup();
        animationSetup();

        currentAnimation = MoveDownAni;
        currentAnimation.stopAt(1);

        currentImage = MoveDownAni.getImage(1);

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

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public int getHeight() {
        return height;
    }


}
