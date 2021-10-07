package model;

import model.MapStates.MapState;
import org.lwjgl.Sys;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.awt.*;

/**
 * This class works as a mediator between the map and the player
 * Checks if the player is colliding with anything on said map
 */
public class CollisionChecker {

    private MapModel currentMap;
    private MapState oldState;

    public CollisionChecker(){
    }

    /**
     * Method that checks collisions between the collision tiles on the map and the player's hitbox.
     * @param playerModel - the player
     * @return true if it collides, otherwise false
     */
    public boolean isColliding(PlayerModel playerModel){
        boolean isInCollision = false;
        for(Rectangle ret : currentMap.getBlocks()) {
            if(playerModel.getNextLocation().intersects(ret)) {
                isInCollision = true;
            }
        }
        return isInCollision;
    }

    /**
     * All of these methods checks if the player's next location is outside the map
     * @param player - the player
     * @return true if outside, else false
     */

    public boolean isNextRightOutside(PlayerModel player){
        return (player.nextX() + player.getWidth() > currentMap.getWidth());
    }
    public boolean isNextLeftOutside(PlayerModel player){
        return (player.nextX() < 0);
    }
    public boolean isNextUpOutside(PlayerModel player){
        return (player.nextY() < 0);
    }
    public boolean isNextDownOutside(PlayerModel player){
        return (player.nextY() + player.getHeight() > currentMap.getHeight());
    }

    /**
     * Changes the map depending on which way the player is moving and which map it already is on.
     * @param player - the player
     * @param sbg - the current state of the game
     * @throws SlickException - if the filepath to the next map is not found.
     */
    public void changeMap(PlayerModel player, StateBasedGame sbg) throws SlickException {
        oldState = currentMap.getCurrentMap();
        currentMap.checkState(player);
        if (currentMap.getCurrentMap() != oldState){
            fadeOut(sbg);
            fadeIn(sbg);
        }
    }

    /**
     * These methods make the transitions when the map is changed
     * @param sbg - the current state of the game
     */
    public void fadeOut(StateBasedGame sbg){
        sbg.enterState(1,new FadeOutTransition(org.newdawn.slick.Color.black, 2000), new EmptyTransition());
    }
    public void fadeIn(StateBasedGame sbg){
        sbg.enterState(1, new EmptyTransition(), new FadeInTransition(Color.black, 1000));
    }

    public void setCurrentMap(MapModel currentMap) {
        this.currentMap = currentMap;
    }
}
