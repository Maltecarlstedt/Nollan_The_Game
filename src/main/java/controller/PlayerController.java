package controller;

import model.CollisionChecker;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import view.PlayerView;

/**
 * @author Malte Carlstedt
 * @author Alexander Brunnegård
 * The class that dictates the updates of the player.
 *
 * Uses PlayerModel, PlayerView.
 */
public class PlayerController {
    /** Declarations of all the parameters that will be initiated in the constructor. */
    PlayerModel playerModel;
    PlayerView playerView;
    CollisionChecker collisionChecker;
    boolean animationUpdateIsSet = false;

     /**
     * The constructor that initiates our player controller
     * @param playerModel - the player
     * @param playerView - our view of the player
     * @param collisionChecker - the collisionChecker
     */
    public PlayerController(PlayerModel playerModel, PlayerView playerView, CollisionChecker collisionChecker) {
        this.playerModel = playerModel;
        this.playerView = playerView;
        this.collisionChecker = collisionChecker;
    }

    /**
     * Updates the player accordingly, depending on input. Primarily movement of the character.
     * Also makes sure that the player is eligible to move the way it wants to move.
     * @param gc - the game container, i.e the entire application
     * @param sbg - the canvas
     * @param delta - the update frequency
     * @throws SlickException - if the filepath of deeply inbedded in changeMap is not found.
     */
    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        if(!animationUpdateIsSet)
            animationUpdate(delta);

        playerModel.getOrientation();
        Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_LSHIFT)){
            playerModel.speed = 6;
        }else{
            playerModel.speed = 3;
        }
        if (input.isKeyDown(Input.KEY_UP)) {
            checkMoveUp(sbg);
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            checkMoveLeft(sbg);
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            checkMoveRight(sbg);
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            checkMoveDown(sbg);
        }else {
            playerView.idlePlayer();
            playerModel.idlePlayer();
        }
    }

    /**
     * Make sure that the animation matches with the update of the game so that they do not interfere with each other.
     * @param delta time in ms since last game update
     */
    private void animationUpdate(int delta){
        PlayerView.moveRightAni.update(delta); // these line makes sure the speed of the Animation is true
        PlayerView.moveUpAni.update(delta);
        PlayerView.moveLeftAni.update(delta);
        PlayerView.moveDownAni.update(delta);
        animationUpdateIsSet = true;
    }

    /**
     * Checks if a players is able to move up
     * @param sbg State of the game
     */
    private void checkMoveUp(StateBasedGame sbg){
        if (!collisionChecker.isColliding(playerModel)) {
            if (collisionChecker.isNextOutside(playerModel)) {
                collisionChecker.checkMapState(playerModel, sbg);
            } else {
                playerView.movingUp();
                playerModel.moveUp();
            }
        }
    }
    /**
     * Checks if a players is able to move down
     * @param sbg State of the game
     */
    private void checkMoveDown(StateBasedGame sbg){
        if (!collisionChecker.isColliding(playerModel)) {
            if (collisionChecker.isNextOutside(playerModel)) {
                collisionChecker.checkMapState(playerModel, sbg);
            } else {
                playerView.movingDown();
                playerModel.moveDown();
            }
        }
    }
    /**
     * Checks if a players is able to move left
     * @param sbg State of the game
     */
    private void checkMoveLeft(StateBasedGame sbg){
        if (!collisionChecker.isColliding(playerModel)) {
            if (collisionChecker.isNextOutside(playerModel)) {
                collisionChecker.checkMapState(playerModel, sbg);
            } else {
                playerView.movingLeft();
                playerModel.moveLeft();
            }
        }
    }
    /**
     * Checks if a players is able to move right
     * @param sbg State of the game
     */
    private void checkMoveRight(StateBasedGame sbg){
        if (!collisionChecker.isColliding(playerModel)) {
            if (collisionChecker.isNextOutside(playerModel)) {
                collisionChecker.checkMapState(playerModel, sbg);
            } else {
                playerView.movingRight();
                playerModel.moveRight();
            }
        }
    }

}