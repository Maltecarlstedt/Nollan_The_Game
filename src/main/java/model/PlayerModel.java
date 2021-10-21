package model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import view.PlayerView;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @author Alexander Brunnegård
 * @author Malte Carlstedt
 * A class that holds all the data on our player
 */
public class PlayerModel {

    private static final int width = 64, height = 64;
    private Orientation orientation;
    public int speed = 3;
    /** The location stored as a rectangle so we can use the "intercepts(Shape s)"-method in CollisionChecker */
    private static Rectangle playerLocation = new Rectangle(250, 384, width, height);

    /**
     * Creates an idle, basic player in the center of our window
     */
    public PlayerModel() {
        //TODO: Gör en try catch här för att slippa throwa slickException i playerController?
        orientation = Orientation.IDLE;
    }

    /**
     * Moves our player depending on the orientation. Our delta-values changes depending on the orientation
     * (check the model.Orientation enum for more precise explanation)
     */
    public void move() {
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
        orientation = Orientation.UP;
        move();
    }

    /**
     * Moves the character left and changes the current animation accordingly
     */
    public void moveLeft() {
        orientation = Orientation.LEFT;
        move();
    }

    /**
     * Moves the character right and changes the current animation accordingly
     */
    public void moveRight() {
        orientation = Orientation.RIGHT;
        move();
    }

    /**
     * Moves the character down and changes the current animation accordingly
     */
    public void moveDown() {
        orientation = Orientation.DOWN;
        move();
    }

    /**
     * Stops the walking animation and makes the player idle.
     */
    public void idlePlayer() {
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
        return playerLocation.x + orientation.deltaX * speed;
    }

    /**
     * @return the next Y position for the player
     */
    public int nextY(){
        return playerLocation.y + orientation.deltaY * speed;
    }

    /**
     * @return the player's next location tile
     */
    public Rectangle getNextLocation(){
        return new Rectangle(nextX(), nextY(), width, height);
    }

    public Rectangle getPlayerLocation() {
        return playerLocation;
    }
}