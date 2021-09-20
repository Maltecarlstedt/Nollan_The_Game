package model;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;


// TODO:: TA REDA PÅ IFALL VI VILL EXTENDA TILED MAPS??
public class MapModel{
    private TiledMap tiledMap;
    private int mapState;

    public MapModel() throws SlickException {
        initMap();
    }

    private void initMap() throws SlickException {
        tiledMap = new TiledMap("data/maps/karhuset.tmx");
        mapState = 0;
        // tiledMap = new TiledMap("data/maps/chalmershallplatsen.tmx");
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
}
