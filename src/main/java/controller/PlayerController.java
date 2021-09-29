package controller;

import model.CollisionChecker;
import model.MapModel;
import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;
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

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

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
                    fadeOut(sbg);
                    collisionChecker.changeMap(playerModel);
                    fadeIn(sbg);
                } else {
                    playerModel.moveUp();
                }
            }
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            if (!collisionChecker.isColliding(playerModel)) {
                if (collisionChecker.isNextLeftOutside(playerModel)) {
                    fadeOut(sbg);
                    collisionChecker.changeMap(playerModel);
                    fadeIn(sbg);
                } else {
                    playerModel.moveLeft();
                }
            }
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            if (!collisionChecker.isColliding(playerModel)) {
                if (collisionChecker.isNextRightOutside(playerModel)) {
                    fadeOut(sbg);
                    collisionChecker.changeMap(playerModel);
                    fadeIn(sbg);
                } else {
                    playerModel.moveRight();
                }
            }
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            if (!collisionChecker.isColliding(playerModel)) {
                if (collisionChecker.isNextDownOutside(playerModel)) {
                    fadeOut(sbg);
                    collisionChecker.changeMap(playerModel);
                    fadeIn(sbg);
                } else {
                    playerModel.moveDown();
                }
            }
        }else
                playerModel.idlePlayer();
    }

    public void fadeOut(StateBasedGame sbg){
        sbg.enterState(1,new FadeOutTransition(Color.black, 2000), new EmptyTransition());
    }
    public void fadeIn(StateBasedGame sbg){
        sbg.enterState(1, new EmptyTransition(), new FadeInTransition(Color.black, 1000));
    }
}