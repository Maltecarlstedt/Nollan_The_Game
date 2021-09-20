import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;

public class Map {

    private TiledMap tiledMap;
    private int mapState;
    int collisionLayer;
    private Rectangle tile = new Rectangle(0,0,32,32);



    public void initMap() throws SlickException {
        tiledMap = new TiledMap("data/maps/karhuset.tmx");
        mapState = 0;
        //tiledMap = new TiledMap("data/maps/chalmershallplatsen.tmx");

        tiledMap.getWidth();
        collisionLayer = tiledMap.getLayerIndex("collision");
    }

    public void render(){
        tiledMap.render(0,0);
    }


    public void isOutside(Player player) throws SlickException {
        if (!player.checkBorder()){
            checkState(mapState, player);
            mapState = newState(mapState);
        }
    }

    private void checkState(int mapState, Player player) throws SlickException {
        if (mapState == 0) {
            tiledMap = new TiledMap("data/maps/chalmershallplatsen.tmx");
            player.setLocation(150, 0);

        }
        else {
            tiledMap = new TiledMap("data/maps/karhuset.tmx");
            player.setLocation(150, 700);
        }
    }
    private int newState(int oldState){
        if (oldState == 1){
            return 0;
        }
        else
            return 1;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public boolean colliding(Player player) {
        try{
            return topLeft(player) && topRight(player)
                    && bottomRight(player) && bottomLeft(player);
        }catch (IndexOutOfBoundsException e){ //ny map här i think?
            return false;
        }
    }

    private boolean topLeft(Player player){
            return tiledMap.getTileId( player.newX() / tiledMap.getTileWidth(),
                player.newY() / tiledMap.getTileHeight(), collisionLayer) == 0;
    }

    private boolean bottomRight(Player player){
        return tiledMap.getTileId((player.newX() + player.getWidth()) / tiledMap.getTileWidth(),
                (player.newY()) / tiledMap.getTileHeight(), collisionLayer) == 0;
    }

    private boolean bottomLeft(Player player){
        return tiledMap.getTileId(player.newX()/ tiledMap.getTileWidth(),
                (player.newY() + player.getHeight()) / tiledMap.getTileHeight(), collisionLayer) == 0;
    }

    private boolean topRight(Player player){
        return tiledMap.getTileId((player.newX() + player.getWidth()) / tiledMap.getTileWidth(),
                (player.newY() + player.getHeight()) / tiledMap.getTileHeight(), collisionLayer) == 0;
    }

    public int getHeight(){
        return tiledMap.getHeight() * tiledMap.getTileHeight();
    }

    public int getWidth(){
        return tiledMap.getWidth() * tiledMap.getTileWidth();
    }

}
