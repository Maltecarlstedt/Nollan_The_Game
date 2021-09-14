import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

public class Map extends BasicGame{

    private TiledMap tiledMap;
    private int mapState;

    public Map() {
        super("Map");
    }

/*
    public void initMap() throws SlickException {
        tiledMap = new TiledMap("data/maps/chalmershallplatsen.tmx");
        mapState = 0;

    }

    public void render(){
        tiledMap.render(0,0);
    }
*/

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
            player.setLocation(500, 700);
        }
    }
    private int newState(int oldState){
        if (oldState == 1){
            return 0;
        }
        else
            return 1;
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        tiledMap = new TiledMap("data/maps/chalmershallplatsen.tmx");
        mapState = 0;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        int objectLayer = tiledMap.getLayerIndex("entren");
        tiledMap.getTileId(0,0, objectLayer);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        tiledMap.render(0,0);
    }

}
