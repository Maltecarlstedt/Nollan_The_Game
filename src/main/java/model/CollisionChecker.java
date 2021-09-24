package model;

import org.newdawn.slick.SlickException;

public class CollisionChecker {

    private MapModel currentMap;
    private int collisionLayer;

    public CollisionChecker(){
    }

    public boolean colliding(PlayerModel player) throws SlickException {
        collisionLayer = currentMap.getTiledMap().getLayerIndex("collision");
        try{
            return topLeft(player) && topRight(player)
                    && bottomRight(player) && bottomLeft(player);
        }catch (IndexOutOfBoundsException e){ //ny map här i think?
            currentMap.checkState();
            return true;
        }
    }

    public boolean topLeft(PlayerModel player){
        return currentMap.getTiledMap().getTileId( player.newX() / currentMap.getTiledMap().getTileWidth(),
                player.newY() / currentMap.getTiledMap().getTileHeight(), currentMap.getCollisionLayer()) == 0;
    }

    public boolean topRight(PlayerModel player){
        return currentMap.getTiledMap().getTileId( (player.newX() + player.getWidth())/ currentMap.getTiledMap().getTileWidth(),
                player.newY() / currentMap.getTiledMap().getTileHeight(), currentMap.getCollisionLayer()) == 0;
    }

    public boolean bottomRight(PlayerModel player){
        return currentMap.getTiledMap().getTileId( (player.newX() + player.getWidth()) / currentMap.getTiledMap().getTileWidth(),
                (player.newY() + player.getHeight()) / currentMap.getTiledMap().getTileHeight(), currentMap.getCollisionLayer()) == 0;
    }

    public boolean bottomLeft(PlayerModel player){
        return currentMap.getTiledMap().getTileId( player.newX() / currentMap.getTiledMap().getTileWidth(),
                (player.newY() + player.getHeight()) / currentMap.getTiledMap().getTileHeight(), currentMap.getCollisionLayer()) == 0;
    }

    public void setCurrentMap(MapModel currentMap) {
        this.currentMap = currentMap;
    }
}
