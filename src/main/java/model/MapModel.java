package model;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;


// TODO:: TA REDA PÅ IFALL VI VILL EXTENDA TILED MAPS??
public class MapModel{
    private TiledMap tiledMap;
    private int mapState;
    private int collisionLayer;
    private Rectangle tile = new Rectangle(0,0,32,32);

    public MapModel() throws SlickException {
        initMap();
    }
    public MapModel(CollisionChecker collisionChecker) throws SlickException {
        initMap();
        collisionChecker.setCurrentMap(this);
    }

    private void initMap() throws SlickException {
        tiledMap = new TiledMap("data/maps/karhuset.tmx");
        mapState = 0;
        collisionLayer = tiledMap.getLayerIndex("collision");
    }

    public TiledMap getTiledMap(){
        return tiledMap;
    }


    private void checkState(int mapState) throws SlickException {
        if (mapState == 0) {
            tiledMap = new TiledMap("data/maps/chalmershallplatsen.tmx");
        }
        else {
            tiledMap = new TiledMap("data/maps/karhuset.tmx");
        }
    }
    private int newState(int oldState){
        if (oldState == 1){
            return 0;
        }
        else
            return 1;
    }

    public int getHeight(){
        return tiledMap.getHeight() * tiledMap.getTileHeight();
    }

    public int getWidth(){
        return tiledMap.getWidth() * tiledMap.getTileWidth();
    }

    public int getCollisionLayer() {
        return collisionLayer;
    }

}