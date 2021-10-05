package Tasks;

import Tasks.taskController.BeerChuggingController;
import Tasks.taskModel.BeerChuggingModel;
import Tasks.taskView.BeerChuggingView;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BeerChugginTask extends BasicGameState {

    private BeerChuggingModel beerChuggingModel;
    private BeerChuggingView beerChuggingView;
    private BeerChuggingController beerChuggingController;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        beerChuggingModel = new BeerChuggingModel();
        beerChuggingView = new BeerChuggingView();
        beerChuggingController = new BeerChuggingController(beerChuggingModel, beerChuggingView);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        beerChuggingView.render(gc, g, beerChuggingModel);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        beerChuggingController.update(gc, delta);
    }

    @Override
    public int getID() {
        return 69;
    }
}
