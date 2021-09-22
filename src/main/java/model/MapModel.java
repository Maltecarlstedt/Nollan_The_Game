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
    private MapState mapState;
    private int collisionLayer;
    private Rectangle tile = new Rectangle(0,0,32,32);
    private CollisionChecker collisionChecker;

    public MapModel() throws SlickException {
        initMap();
    }

    public MapModel(CollisionChecker collisionChecker) throws SlickException {
        initMap();
        this.collisionChecker = collisionChecker;
        collisionChecker.setCurrentMap(this);
    }

    private void initMap() throws SlickException {
        current = Karhuset.KARHUSET;
        tiledMap = current.loadMap();
        updateCollisionLayer();
    }

    public void setTiledMap(MapState current){ this.current = current;}

    public void updateCollisionLayer(){
        collisionLayer = tiledMap.getLayerIndex("collision");
    }

    public TiledMap getTiledMap(){
        return tiledMap;
    }


    public void checkState(Orientation orientation) throws SlickException {
        System.out.println(current.toString());
        System.out.println(orientation);
        tiledMap = current.nextMap(orientation);

        /*if (mapState == Karhuset.KARHUSET) {
            tiledMap = mapState.loadMap();
        }
        else {
            tiledMap = Chalmersplatsen.CHALMERSPLATSEN.loadMap();
        }
        updateCollisionLayer();
        collisionChecker.setCurrentMap(this);*/
    }
    public MapState newState(){
        if (current == Karhuset.KARHUSET){
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

    public void setTiledMap(TiledMap tiledMap) {
        this.tiledMap = tiledMap;
    }

}