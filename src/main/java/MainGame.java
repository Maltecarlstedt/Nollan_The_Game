import NPCs.NPCFactory;
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

import java.util.ArrayList;

public class MainGame extends BasicGameState {

    private PlayerModel playerModel;
    private PlayerView playerView;
    private PlayerController playerController;
    private ArrayList<NPCs.NPC> NPCs;

    private MapModel mapModel;
    private MapView mapView;
    private MapController mapController;

    private EnterTask enterTask;

    private  StateSetup stateSetup;

    private CollisionChecker collisionChecker;

    public MainGame() throws SlickException {
    }


    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        // TODO:: Make this prettier
        collisionChecker = new CollisionChecker();
        NPCFactory factory = new NPCFactory();
        playerModel = new PlayerModel();
        playerView = new PlayerView();
        playerController = new PlayerController(playerModel, playerView, collisionChecker);
        enterTask = new EnterTask();

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

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        // Render the map
        mapView.render(gc, g, mapModel);
        // Renders The player
        playerView.render(gc, g, playerModel);
        // Renders top layer
        mapView.renderTopLayer(gc, g, mapModel);

        //TODO: Move this from MainGame into its own class.
        //Renders the nps
        for(NPCs.NPC npc: NPCs) {
            npc.render(gc, g);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {

        // Updates our player
        playerController.update(gc, stateBasedGame, delta);
        // Updates our map
        mapController.update(gc, delta);
        // Checks if a task should be started and entered.
        enterTask.update(gc, playerModel, mapModel, stateBasedGame);

        //TODO: Move this from MainGame into its own class.
        showNPC();
    }

    @Override
    public int getID() {
        return 1;
    }

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

