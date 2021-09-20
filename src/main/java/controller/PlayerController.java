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

        // TODO: Egen funk?
        Input input = gc.getInput();
        if(input.isKeyDown(Input.KEY_UP)){
            moveUp();
        }else if(input.isKeyDown(Input.KEY_LEFT)){
            moveLeft();
        }else if(input.isKeyDown(Input.KEY_RIGHT)){
            moveRight();
        }else if(input.isKeyDown(Input.KEY_DOWN)) {
            moveDown();
        }else {
            idlePlayer();
        }

        // TODO: Egen funk?
        if(playerModel.getOrientation() == Orientation.IDLE){
            playerView.drawIdlePlayer(playerModel);
        }else{
            playerView.drawRunningPlayer(playerModel);
        }
    }

    /**
     * Moves our player depending on the orientation. Our delta-values changes depending on the orientation
     * (check the model.Orientation enum for more precise explanation)
     */
    public void move() {
        playerModel.getLocation().x += playerModel.getOrientation().deltaX;
        playerModel.getLocation().y += playerModel.getOrientation().deltaY;
    }

    /**
     * Moves the character up, changes state so that if the player is IDLE, the player will use the right IDLE state
     * (I.E it will stand still in state UP)
     */
    public void moveUp() {
        playerModel.setOrientation(Orientation.UP);
        move();
        playerModel.currentAnimation = playerModel.MoveUpAni;
        playerModel.setState(3);
    }

    /**
     * Moves the character to the left, changes state so that if the player is IDLE, the player will use the right IDLE state
     */
    public void moveLeft() {
        playerModel.setOrientation(Orientation.LEFT);
        move();
        playerModel.currentAnimation = playerModel.MoveLeftAni;
        playerModel.setState(2);
    }

    /**
     * Moves the character to the right, changes state so that if the player is IDLE, the player will use the right IDLE state
     */
    public void moveRight() {
        playerModel.setOrientation(Orientation.RIGHT);
        move();
        playerModel.currentAnimation = playerModel.MoveRightAni;
        playerModel.setState(1);
    }

    /**
     * Moves the character down, changes state so that if the player is IDLE, the player will use the right IDLE state
     */
    public void moveDown() {
        playerModel.setOrientation(Orientation.DOWN);
        move();
        playerModel.currentAnimation = playerModel.MoveDownAni;
        playerModel.setState(0);
    }

    /**
     * Sets the still image so that the player just stops in its track. Depending on which state is set,
     * which is given by which key was most lately pressed down.
     * @return
     */
    public void idlePlayer() {

        switch (playerModel.getState()) {
            case 0:
                playerModel.setOrientation(Orientation.IDLE);
                playerModel.currentImage = playerModel.MoveDownAni.getImage(1);
                break;
            case 1:
                playerModel.setOrientation(Orientation.IDLE);
                playerModel.currentImage = playerModel.MoveRightAni.getImage(1);
                break;
            case 2:
                playerModel.setOrientation(Orientation.IDLE);
                playerModel.currentImage = playerModel.MoveLeftAni.getImage(0);
                break;
            case 3:
                playerModel.setOrientation(Orientation.IDLE);
                playerModel.currentImage = playerModel.MoveUpAni.getImage(1);
                break;
            //TODO: DEFAULT STATE FÖR IDLE, NER?
        }

    }

}
