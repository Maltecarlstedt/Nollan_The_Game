import controller.MapController;
import controller.PlayerController;
import model.CollisionChecker;
import model.MapModel;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.MapView;
import view.PlayerView;

public class MainGame extends BasicGameState {

    private PlayerModel playerModel;
    private PlayerView playerView;
    private PlayerController playerController;

    private MapModel mapModel;
    private MapView mapView;
    private MapController mapController;

    private CollisionChecker collisionChecker;

    public MainGame() throws SlickException {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        // TODO:: SKAPA EN MANAGER SÅ ATT DET INTE BLIR SÅ MKT INITIERING HÄR.
        collisionChecker = new CollisionChecker();

        playerModel = new PlayerModel();
        playerView = new PlayerView();
        playerController = new PlayerController(playerModel, playerView, collisionChecker);

        mapModel = new MapModel(collisionChecker);
        mapView = new MapView();
        mapController = new MapController(mapModel, mapView); // IDK om mapController kommer behöva detta men lägger dom där så länge.



    }
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapView.render(gc, g, mapModel);
        playerView.render(gc, g, playerModel);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        playerController.update(gc,stateBasedGame, delta);
        mapController.update(gc, stateBasedGame, delta);
    }

    @Override
    public int getID() {
        return 1;
    }
}
