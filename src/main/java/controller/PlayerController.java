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
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        // TODO: Ha någon annanstans?
        if(!animationUpdateIsSet)
            animationUpdate(delta);

        // TODO: Egen funk?
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_UP)) {
            checkMoveUp(sbg);
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            checkMoveLeft(sbg);
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            checkMoveRight(sbg);
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            checkMoveDown(sbg);
        }else
            playerModel.idlePlayer();
    }

    private void animationUpdate(int delta){
        playerModel.MoveRightAni.update(delta); // these line makes sure the speed of the Animation is true
        playerModel.MoveUpAni.update(delta);
        playerModel.MoveLeftAni.update(delta);
        playerModel.MoveDownAni.update(delta);
        animationUpdateIsSet = true;

    }

    private void checkMoveUp(StateBasedGame sbg) throws SlickException {
        if (!collisionChecker.isColliding(playerModel)) {
            if (collisionChecker.isNextOutside(playerModel)) {
                collisionChecker.checkMapState(playerModel, sbg);
            } else {
                playerModel.moveUp();
            }
        }
    }
    private void checkMoveDown(StateBasedGame sbg) throws SlickException {
        if (!collisionChecker.isColliding(playerModel)) {
            if (collisionChecker.isNextOutside(playerModel)) {
                collisionChecker.checkMapState(playerModel, sbg);
            } else {
                playerModel.moveDown();
            }
        }
    }
    private void checkMoveLeft(StateBasedGame sbg) throws SlickException {
        if (!collisionChecker.isColliding(playerModel)) {
            if (collisionChecker.isNextOutside(playerModel)) {
                collisionChecker.checkMapState(playerModel, sbg);
            } else {
                playerModel.moveLeft();
            }
        }
    }
    private void checkMoveRight(StateBasedGame sbg) throws SlickException {
        if (!collisionChecker.isColliding(playerModel)) {
            if (collisionChecker.isNextOutside(playerModel)) {
                collisionChecker.checkMapState(playerModel, sbg);
            } else {
                playerModel.moveRight();
            }
        }
    }

}