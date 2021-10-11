import NPCs.NPCFactory;
import controller.MapController;
import controller.MaterialController;
import controller.PlayerController;
import model.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.MapView;
import view.MaterialView;
import view.PlayerView;
import NPCs.*;

import java.util.ArrayList;

/**
 * Main class for controlling models, views and controllers
 */
public class MainGame extends BasicGameState {

    private PlayerModel playerModel;
    private PlayerView playerView;
    private PlayerController playerController;
    private ArrayList<NPCs.NPC> NPCs;

    private MapModel mapModel;
    private MapView mapView;
    private MapController mapController;

    private MaterialModel materialModel;
    private MaterialView materialView;
    private MaterialController materialController;

    private EnterTask enterTask;

    private CollisionChecker collisionChecker;

    public MainGame() throws SlickException {
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
        NPCFactory factory = new NPCFactory();
        playerModel = new PlayerModel();
        playerView = new PlayerView();
        playerController = new PlayerController(playerModel, playerView, collisionChecker);
        enterTask = new EnterTask();

        materialModel = new MaterialModel();
        materialView = new MaterialView();
        materialController = new MaterialController(materialModel,materialView,playerModel);





        //TODO: Make this prettier
        NPCs = new ArrayList<>();
        NPC webers = factory.getNPC("Webers");
        NPC kritan = factory.getNPC("Kritan");
        NPC tango = factory.getNPC("Tango");
        NPC ekak1 = factory.getNPC("Ekak1");
        NPC ekak2 = factory.getNPC("Ekak2");
        NPC bieber = factory.getNPC("Bieber");
        NPC kvalle = factory.getNPC("Kvalle");
        NPC dnollk = factory.getNPC("DNollK");

        //TODO: Make this prettier
        NPCs.add(webers);
        NPCs.add(kritan);
        NPCs.add(tango);
        NPCs.add(ekak1);
        NPCs.add(ekak2);
        NPCs.add(bieber);
        NPCs.add(kvalle);
        NPCs.add(dnollk);

        mapModel = new MapModel(collisionChecker);

        mapView = new MapView();
        mapController = new MapController(mapModel, mapView);

    }

    /**
     * Our head render function that renders everything that needs to be drawn on the canvas
     * @param gc The container that have the game
     * @param sbg The current state of the game used to isolate the game from different aspects
     * @param g The grapchics context to be used for rendering
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        // Render the map
        mapView.render(mapModel);

        materialView.renderFindMaterial(g, materialModel, mapModel);
        // Renders The player
        playerView.render(g, playerModel);
        // Renders the top layer
        mapView.renderTopLayer(mapModel);
        materialView.renderMaterial(g, materialModel);
    
        //TODO: Move this from MainGame into its own class.
        //Renders the nps
        for(NPCs.NPC npc: NPCs) {
            npc.render(gc, g);
        }
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
        enterTask.update(gc, playerModel, mapModel, sbg);
        // Checks if player collides with items (the materials).
        materialController.update(playerModel);

        //TODO: Move this from MainGame into its own class.
        showNPC();
    }

    /**
     * The id for this state
     * @return state number
     */
    @Override
    public int getID() {
        return 1;
    }

    /**
     * Method for displaying NPC on the map that they belong to.
     */
    //TODO: Move this from MainGame into its own class.
    public void showNPC() {
        for (NPCs.NPC npc : NPCs) {
            if (npc.getCurrent().equals(mapModel.getCurrentMap())) {
                npc.setShowing(true);
            }
            if ((npc.getCurrent() != mapModel.getCurrentMap())) {
                npc.setShowing(false);
            }
        }
    }


}

