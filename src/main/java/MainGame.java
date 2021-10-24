import Items.ItemModel;
import NPC.NPCController;
import NPC.NPCModel;
import NPC.NPCView;
import TextBoxes.TextBoxController;
import TextBoxes.TextBoxModel;
import TextBoxes.TextBoxView;
import controller.MapController;
import Items.ItemController;
import controller.PlayerController;
import model.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.MapView;
import Items.ItemView;
import view.PlayerView;

/**
     * @author Malte Carlstedt
     * @author Alexander Brunnegård
     * @author Steffanie Kristiansson
     * @author Julia Böckert
     * @author Clara Simonsson
     * Main class for controlling models, views and controllers
     */
public class MainGame extends BasicGameState {

    private PlayerModel playerModel;
    private PlayerView playerView;
    private PlayerController playerController;


    private MapModel mapModel;
    private MapView mapView;
    private MapController mapController;

    private ItemModel itemModel;
    private ItemView itemView;
    private ItemController itemController;

    private NPCView npcView;
    private NPCModel npcModel;
    private NPCController npcController;

    private EnterTask enterTask;

    private CollisionChecker collisionChecker;

    private TextBoxModel textBoxModel;
    private TextBoxView textBoxView;
    private TextBoxController textBoxController;

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
        collisionChecker = new CollisionChecker();
        playerModel = new PlayerModel();
        playerView = new PlayerView();
        playerController = new PlayerController(playerModel, playerView, collisionChecker);
        enterTask = new EnterTask();
        itemModel = new ItemModel();
        itemView = new ItemView();
        itemController = new ItemController(itemModel, itemView,playerModel);

        mapModel = new MapModel(collisionChecker);
        mapView = new MapView(mapModel);
        mapController = new MapController(mapModel, mapView);

        npcModel = new NPCModel();
        npcView = new NPCView(npcModel.NPCs);
        npcController = new NPCController();

        textBoxModel = new TextBoxModel();
        textBoxView = new TextBoxView(textBoxModel.textboxes);
        textBoxController = new TextBoxController();

    }
    /**
     * Our head render function that renders everything that needs to be drawn on the canvas
     * @param gc The container that have the game
     * @param sbg The current state of the game used to isolate the game from different aspects
     * @param g The graphics context to be used for rendering
     * @throws SlickException
     */


    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        // Render the map
        mapView.render(mapModel);

        // Renders The player
        playerView.render(g, playerModel);
        // Renders the top layer
        mapView.renderTopLayer(mapModel);

        itemView.renderItemsToFind(g, itemModel, mapModel);
        itemView.renderUnfilledItems(g, itemModel);
       // itemView.renderImages(g, itemModel);

        //Renders the textBoxes

        textBoxView.render(textBoxModel.textboxes, textBoxModel, mapModel);

        //Renders the nps
        npcView.render(g, npcModel, npcModel.NPCs, mapModel);



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
        mapController.update(gc, delta, mapModel);
        // Checks if a task should be started and entered.
        enterTask.update(gc, mapModel, sbg);

        itemController.update(playerModel, itemModel, sbg);

        npcController.update(npcModel.NPCs, delta);

        textBoxController.update(mapModel, textBoxModel.textboxes);
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
