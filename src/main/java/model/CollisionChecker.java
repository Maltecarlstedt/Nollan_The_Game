package model;

import org.newdawn.slick.SlickException;

import java.awt.*;

public class CollisionChecker {

    private MapModel currentMap;

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

    public void changeMap(PlayerModel player) throws SlickException {
        currentMap.checkState(player.getOrientation());
        player.setNewPlayerTile(200, 200);

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
