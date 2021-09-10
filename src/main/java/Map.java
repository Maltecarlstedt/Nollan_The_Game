import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Map {

    private TiledMap tiledMap;


    public void initMap() throws SlickException {
        tiledMap = new TiledMap("data/maps/karhuset.tmx");
        // chalmershallplatsen = new TiledMap("data/maps/chalmershallplatsen.tmx");
    }

    public void render(){
        tiledMap.render(0,0);
    }

    public void checkIfOutside(Player player){
        if (player.getLocation().getY() > 704){
            System.out.println("Tjo bre");
        }
    }

}
