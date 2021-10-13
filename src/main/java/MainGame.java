import controller.MapController;
import controller.PlayerController;
import model.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.MapView;
import view.PlayerView;
import NPCs.*;
    /**
     * Main class for controlling models, views and controllers
     */
public class MainGame extends BasicGameState {

    private PlayerModel playerModel;
    private PlayerView playerView;
    private PlayerController playerController;

    private MapModel mapModel;
    private MapView mapView;
    private MapController mapController;

    private NPCView npcView;
    private NPCModel npcModel;

    private EnterTask enterTask;

    private CollisionChecker collisionChecker;

    public MainGame(){
    }

    /**
     * Our head init function that initialize the different models of the game.
     * @param gc The container that have the game
     * @param sbg The current state of the game used to isolate the game from different aspects
     * @throws SlickException Generic Exception
     */

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        // TODO:: Make this prettier
        collisionChecker = new CollisionChecker();
        playerModel = new PlayerModel();
        playerView = new PlayerView();
        playerController = new PlayerController(playerModel, playerView, collisionChecker);
        enterTask = new EnterTask();
        npcView = new NPCView();
        npcModel = new NPCModel();
        mapModel = new MapModel(collisionChecker);
        mapView = new MapView();
        mapController = new MapController(mapModel, mapView);
    }
    /**
     * Our head render function that renders everything that needs to be drawn on the canvas
     * @param gc The container that have the game
     * @param sbg The current state of the game used to isolate the game from different aspects
     * @param g The graphics context to be used for rendering
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
        // Render the map
        mapView.render(mapModel);
        // Renders The player
        playerView.render(g, playerModel);
        // Renders the top layer
        mapView.renderTopLayer(mapModel);

        //Renders the nps
        npcModel.showNPC(mapModel);
        npcModel.initList();
        npcView.render(g, npcModel.NPCs);
    }

    /**
     * Our head update functions that updates our model
     *
     * @param gc The container that have the game
     * @param sbg The current state of the game used to isolate the game from different aspects
     * @param delta Time in ms since last update
     * @throws SlickException Generic exception
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        // Updates our player
        playerController.update(gc, sbg, delta);
        // Updates our map
        mapController.update(gc, delta);
        // Checks if a task should be started and entered.
        enterTask.update(gc, mapModel, sbg);
    }
    /**
     * The id for this state
     * @return state number
     */
    @Override
    public int getID() {
        return 1;
    }
}
