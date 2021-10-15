import controller.MapController;
import controller.PlayerController;
import model.CollisionChecker;
import model.MapModel;
import model.MapStates.Dammen;
import model.MapStates.Ekak;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import view.MapView;
import view.PlayerView;

public class GameDoneView extends BasicGameState {

    private PlayerModel playerModel;
    private PlayerView playerView;
    private PlayerController playerController;
    private CollisionChecker collisionChecker;

    private MapModel mapModel;
    private MapView mapView;
    private MapController mapController;



    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        collisionChecker = new CollisionChecker();

        playerModel = new PlayerModel();
        playerView = new PlayerView();
        playerController = new PlayerController(playerModel, playerView, collisionChecker);

        mapController = new MapController(mapModel, mapView);
        mapModel = new MapModel(collisionChecker);
        mapModel.setTiledMap(Ekak.EKAK.loadMap());
        mapModel.setTiledMap(Ekak.EKAK);
        mapView = new MapView();

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapView.render(mapModel);
        playerView.render(g, playerModel);
        mapView.renderTopLayer(mapModel);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        playerController.update(gc, sbg, delta);
        mapController.update(gc, delta);
    }

    @Override
    public int getID() {
        return 100;
    }
}
