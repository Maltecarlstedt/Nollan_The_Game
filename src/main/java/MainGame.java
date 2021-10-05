import Tasks.taskController.BeerChuggingController;
import Tasks.taskModel.BeerChuggingModel;
import Tasks.taskView.BeerChuggingView;
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

import java.util.ArrayList;

public class MainGame extends BasicGameState {

    private PlayerModel playerModel;
    private PlayerView playerView;
    private PlayerController playerController;
    public ArrayList<NPC> NPCs;

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

        // TODO:: SKAPA EN MANAGER SÅ ATT DET INTE BLIR SÅ MKT INITIERING HÄR.
        collisionChecker = new CollisionChecker();
        // private Webers npcTest;
        NPCFactory factory = new NPCFactory();
        playerModel = new PlayerModel();
        playerView = new PlayerView();
        playerController = new PlayerController(playerModel, playerView, collisionChecker);
        enterTask = new EnterTask();

        //det här borde gå att göra mkt snyggare
        NPCs = new ArrayList<>();
        NPC webers = factory.getNPC("Webers");
        NPC kritan = factory.getNPC("Kritan");
        NPC tango = factory.getNPC("Tango");
        NPC ekak1 = factory.getNPC("Ekak1");
        NPC ekak2 = factory.getNPC("Ekak2");

        NPCs.add(webers);
        NPCs.add(kritan);
        NPCs.add(tango);
        NPCs.add(ekak1);
        NPCs.add(ekak2);

        mapModel = new MapModel(collisionChecker);

        mapView = new MapView();
        mapController = new MapController(mapModel, mapView); // IDK om mapController kommer behöva detta men lägger dom där så länge.

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapView.render(gc, g, mapModel);
        playerView.render(gc, g, playerModel);
        for(NPC npc: NPCs)
            npc.render(gc, g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {

        playerController.update(gc, stateBasedGame, delta);
        mapController.update(gc, delta);
        enterTask.update(gc, playerModel, mapModel, stateBasedGame);
        showNPC();


    }

    @Override
    public int getID() {
        return 1;
    }

    //funkar kanske?
    public void showNPC() {
        for (NPC npc : NPCs) {
            if (npc.current.equals(mapModel.getCurrentMap())) {
                npc.setShowing(true);
            }
            if ((npc.current != mapModel.getCurrentMap())) {
                npc.setShowing(false);
            }

        }
    }
}

