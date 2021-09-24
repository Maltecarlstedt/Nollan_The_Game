package controller;

import model.CollisionChecker;
import model.MapModel;
import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import view.PlayerView;

import java.awt.*;

public class PlayerController {

    PlayerModel playerModel;
    PlayerView playerView;
    CollisionChecker collisionChecker;


    public PlayerController(PlayerModel playerModel, PlayerView playerView, CollisionChecker collisionChecker) {
        this.playerModel = playerModel;
        this.playerView = playerView;
        this.collisionChecker = collisionChecker;
    }

    public void update(GameContainer gc, int delta) throws SlickException {

        // TODO: Ha någon annanstans?
        playerModel.MoveRightAni.update(delta); // these line makes sure the speed of the Animation is true
        playerModel.MoveUpAni.update(delta);
        playerModel.MoveLeftAni.update(delta);
        playerModel.MoveDownAni.update(delta);

        // TODO: Egen funk?
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_UP)) {
            if (!collisionChecker.isColliding(playerModel)) {
                if (collisionChecker.isNextUpOutside(playerModel)) {
                    collisionChecker.changeMap(playerModel);
                } else {
                    playerModel.moveUp();
                }
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            if (!collisionChecker.isColliding(playerModel)) {
                if (collisionChecker.isNextLeftOutside(playerModel)) {
                    collisionChecker.changeMap(playerModel);
                } else {
                    playerModel.moveLeft();
                }
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            if (!collisionChecker.isColliding(playerModel)) {
                if (collisionChecker.isNextRightOutside(playerModel)) {
                    collisionChecker.changeMap(playerModel);
                } else {
                    playerModel.moveRight();
                }
            }
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            if (!collisionChecker.isColliding(playerModel)) {
                if (collisionChecker.isNextDownOutside(playerModel)) {
                    collisionChecker.changeMap(playerModel);
                } else {
                    playerModel.moveDown();
                }
            }
        }else
                playerModel.idlePlayer();
    }
}