package Tasks;

import Tasks.taskController.GatheringPantController;
import Tasks.taskModel.GatheringPantModel;
import Tasks.taskView.GatheringPantView;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PantRetrievingTask extends BasicGameState {

    private GatheringPantModel pantModel;
    private GatheringPantController pantController;
    private GatheringPantView pantView;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

        pantModel = new GatheringPantModel();
        pantView = new GatheringPantView();
        pantController = new GatheringPantController(pantModel, pantView);

    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        pantView.render(gc, g, pantModel);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        pantController.update(gc, delta);

    }

    @Override
    public int getID() {
        return 420;
    }
}
