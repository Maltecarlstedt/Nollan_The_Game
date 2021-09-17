import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;

public class Map {
    private MapState current;
    public TiledMap tiledMap;

    public Map(){
        current = Karhuset.KARHUSET;
    }

    //When the game starts it will start in the map Kårhuset
    public void initMap() throws SlickException {tiledMap = current.loadMap();}

    public void setTiledMap(MapState current){this.current = current;}

    public MapState getCurrentState(){return current;}

    public void isOutside(Player player) throws SlickException {
        if (!player.checkBorder()) {
            current.nextState(this, player);
            current.setPosition(player);
            tiledMap = current.loadMap();
        }
    }

    public Orientation getPOrientation(Player player){
        return player.getOrientation();
    }


}
