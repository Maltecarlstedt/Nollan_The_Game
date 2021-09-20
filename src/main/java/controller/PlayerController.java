package controller;

import model.Orientation;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import view.PlayerView;

public class PlayerController{

    PlayerModel playerModel;
    PlayerView playerView;

    public PlayerController(PlayerModel playerModel, PlayerView playerView) {
        this.playerModel = playerModel;
        this.playerView = playerView;

    }

    public void update(GameContainer gc, int delta) {

        // TODO: Ha någon annanstans?
        playerModel.MoveRightAni.update(delta); // these line makes sure the speed of the Animation is true
        playerModel.MoveUpAni.update(delta);
        playerModel.MoveLeftAni.update(delta);
        playerModel.MoveDownAni.update(delta);

        // TODO: Egen funk?
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_UP)){
            playerModel.moveUp();
        }else if(input.isKeyDown(Input.KEY_LEFT)){
            playerModel.moveLeft();
        }else if(input.isKeyDown(Input.KEY_RIGHT)){
            playerModel.moveRight();
        }else if(input.isKeyDown(Input.KEY_DOWN)) {
            playerModel.moveDown();
        }else {
            playerModel.idlePlayer();
        }

    }



}
