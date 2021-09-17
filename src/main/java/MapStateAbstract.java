import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

abstract class MapStateAbstract {

    /*
    public TiledMap tiledMap;

    public void initMap() throws SlickException {
        tiledMap = new TiledMap("data/maps/karhuset.tmx");
        //state = MapEnums.KARHUSET;
    }

    public void render(){
        tiledMap.render(0,0);
    }

    public void isOutside(Player player) throws SlickException {
        if (!player.checkBorder()){
            nextState(player);
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




    public abstract void nextState(Player player) throws SlickException;
    public abstract void startPosition();

     */

}
