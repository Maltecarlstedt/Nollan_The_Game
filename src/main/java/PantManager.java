import model.MapModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import taskMiniGame.GatheringPantController;
import taskMiniGame.GatheringPantModel;
import taskMiniGame.GatheringPantView;
import view.MapView;


public class PantManager extends BasicGameState {

    private MapModel mapModel;
    private MapView mapView;

    private GatheringPantModel pantModel;
    private GatheringPantController pantController;
    private GatheringPantView pantView;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapModel = new MapModel();
        mapView = new MapView();

        pantModel = new GatheringPantModel();
        pantView = new GatheringPantView();
        pantController = new GatheringPantController(pantModel, pantView);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapView.render(gc, g, mapModel);
        pantView.render(gc, g, pantModel);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        pantController.update(gc, delta);
    }

    @Override
    public int getID() {
        return 666;
    }
}