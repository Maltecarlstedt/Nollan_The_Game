import controller.MapController;
import controller.PlayerController;
import model.CollisionChecker;
import model.MapModel;
import model.MapStates.Dammen;
import model.MapStates.Ekak;
import model.MapStates.Gasquen;
import model.PlayerModel;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;
import view.MapView;
import view.PlayerView;

/**
 * Represents the view when the game has ended
 */
public class GameDoneView extends BasicGameState {

    /**
     * The player and map
     */
    private PlayerModel playerModel;
    private PlayerView playerView;
    private PlayerController playerController;
    private CollisionChecker collisionChecker;

    private MapModel mapModel;
    private MapView mapView;
    private MapController mapController;

    private Image endGame;


    /**
     * Initializes the player and map
     * @param gameContainer - The container that has the game
     * @param stateBasedGame - The current state of the game used to isolate the game from different aspects
     * @throws SlickException - if the file for the maps is not found, slick-exception.
     */
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        collisionChecker = new CollisionChecker();

        playerModel = new PlayerModel();
        playerView = new PlayerView();
        playerController = new PlayerController(playerModel, playerView, collisionChecker);

        mapController = new MapController(mapModel, mapView);
        mapModel = new MapModel(collisionChecker);
        mapModel.setTiledMap(Gasquen.GASQUEN.loadMap());
        mapModel.setTiledMap(Gasquen.GASQUEN);
        mapView = new MapView();

        endGame = new Image("data/maps/images/avslutaButton.png");

    }

    /**
     * Draws the player and the map on the screen
     * @param gc - The container that has the game
     * @param sbg - The current state of the game used to isolate the game from different aspects
     * @param g - represents the graphics context to be used for rendering.
     * @throws SlickException - if the file for the maps is not found, slick-exception.
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapView.render(mapModel);
        playerView.render(g, playerModel);
        mapView.renderTopLayer(mapModel);
        endGame.draw(1024/2,616);
    }

    /**
     * Updates the player and map
     * @param gc - The container that has the game
     * @param sbg - The current state of the game used to isolate the game from different aspects
     * @param delta - represents time in ms since last update.
     * @throws SlickException - if the file for the maps is not found, slick-exception.
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        playerController.update(gc, sbg, delta);
        mapController.update(gc, delta);

        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if (((posX > 243 && posX < 781) && (posY > 221 && posY < 315)) && Mouse.isButtonDown(0)) {
            System.exit(0);
        }
    }

    /** A special ID for this specific state.
     * @return represents this state with a unique int.
     */
    @Override
    public int getID() {
        return 100;
    }
}
