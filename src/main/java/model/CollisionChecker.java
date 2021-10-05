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

public class CollisionChecker {

    private MapModel currentMap;
    private MapState oldState;

    public CollisionChecker(){
    }

    public boolean isColliding(PlayerModel playerModel){
        boolean isInCollision = false;
        for(Rectangle ret : currentMap.getBlocks()) {
            if(playerModel.getNextLocation().intersects(ret)) {
                isInCollision = true;
            }
        }

        return isInCollision;
    }




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

    public void changeMap(PlayerModel player, StateBasedGame sbg) throws SlickException {
        oldState = currentMap.getCurrentMap();
        currentMap.checkState(player.getOrientation());
        if (currentMap.getCurrentMap() != oldState){
            fadeOut(sbg);
            player.setNewPlayerTile(200, 200);
            fadeIn(sbg);
        }
    }

    public void fadeOut(StateBasedGame sbg){
        sbg.enterState(1,new FadeOutTransition(org.newdawn.slick.Color.black, 2000), new EmptyTransition());
    }
    public void fadeIn(StateBasedGame sbg){
        sbg.enterState(1, new EmptyTransition(), new FadeInTransition(Color.black, 1000));
    }

    /* Should not be used
    public boolean colliding(PlayerModel player) throws SlickException {
        try {
            return topLeft(player) && topRight(player)
                    && bottomRight(player) && bottomLeft(player);
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        return true;



    }
    public boolean topLeft(PlayerModel player){
        return currentMap.getTiledMap().getTileId( player.nextX() / currentMap.getTiledMap().getTileWidth(),
                player.nextY() / currentMap.getTiledMap().getTileHeight(), currentMap.getCollisionLayer()) == 0;
    }

    public boolean topRight(PlayerModel player){
        return currentMap.getTiledMap().getTileId( (player.nextX() + player.getWidth())/ currentMap.getTiledMap().getTileWidth(),
                player.nextY() / currentMap.getTiledMap().getTileHeight(), currentMap.getCollisionLayer()) == 0;
    }

    public boolean bottomRight(PlayerModel player){
        return currentMap.getTiledMap().getTileId( (player.nextX() + player.getWidth()) / currentMap.getTiledMap().getTileWidth(),
                (player.nextY() + player.getHeight()) / currentMap.getTiledMap().getTileHeight(), currentMap.getCollisionLayer()) == 0;
    }

    public boolean bottomLeft(PlayerModel player){
        return currentMap.getTiledMap().getTileId( player.nextX() / currentMap.getTiledMap().getTileWidth(),
                (player.nextY() + player.getHeight()) / currentMap.getTiledMap().getTileHeight(), currentMap.getCollisionLayer()) == 0;
    }
    */

    public void setCurrentMap(MapModel currentMap) {
        this.currentMap = currentMap;
    }
}
