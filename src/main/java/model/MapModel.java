package model;

import model.MapStates.Chalmersplatsen;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;
import model.MapStates.Karhuset;
import model.MapStates.MapState;

import java.util.Map;


// TODO:: TA REDA PÅ IFALL VI VILL EXTENDA TILED MAPS??
public class MapModel{
    private MapState current;
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

        current = Karhuset.KARHUSET;
        tiledMap = current.loadMap();
        collisionLayer = tiledMap.getLayerIndex("collision");
    }

    public void setTiledMap(MapState current){ this.current = current;}

    public TiledMap getTiledMap(){
        return tiledMap;
    }


    private void checkState(MapState mapState) throws SlickException {
        if (mapState == Karhuset.KARHUSET) {
            tiledMap = mapState.loadMap();
        }
        else {
            tiledMap = Chalmersplatsen.CHALMERSPLATSEN.loadMap();
        }
    }
    private MapState newState(MapState oldState){
        if (oldState == Karhuset.KARHUSET){
            return Chalmersplatsen.CHALMERSPLATSEN;
        }
        else
            return Karhuset.KARHUSET;
    }

    public void playerOutOfBounds(PlayerModel player) throws SlickException {
        int state;
        if (player.getPlayerLocation().y < 700){
            state = 0;
            current.nextState(this, player,state);
            tiledMap = current.loadMap();
        }
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