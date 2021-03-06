package Tasks;
import Tasks.taskController.BeerChuggingController;
import Tasks.taskModel.BeerChuggingModel;
import Tasks.taskView.BeerChuggingView;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 * @author Malte Carlstedt
 * A class that represents the Beer chugging task within it's own state.
 */

public class BeerChugginTask extends BasicGameState {

    private BeerChuggingModel beerChuggingModel;
    private BeerChuggingView beerChuggingView;
    private BeerChuggingController beerChuggingController;

    /**
     * Initialize everything needed to run this state.
     *
     * @param gc The container that have the game
     * @param sbg The current state of the game used to isolate the game from different aspects
     * @throws SlickException A generic exception
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        beerChuggingModel = new BeerChuggingModel();
        beerChuggingView = new BeerChuggingView();
        beerChuggingController = new BeerChuggingController(beerChuggingModel, beerChuggingView);
    }

    /**
     * Draws everything on the canvas
     *
     * @param gc The container that have the game
     * @param sbg The current state of the game used to isolate the game from different aspects
     * @param g The grapchics context to be used for rendering
     * @throws SlickException A generic exception
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
        beerChuggingView.render(g, beerChuggingModel);
    }

    /**
     * Update method
     *
     * @param gc The container that have the game
     * @param sbg The current state of the game used to isolate the game from different aspects
     * @param delta How long in ms that has passed since the last update
     * @throws SlickException A generic exception
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta){
        beerChuggingController.update(gc, sbg, delta);
    }

    @Override
    public int getID() {
        return 69;
    }
}
