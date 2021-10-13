package Tasks;

import Tasks.taskController.BuildBridgeController;
import Tasks.taskModel.BuildBridgeModel;
import Tasks.taskView.BuildBridgeView;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BuildBridgeTask extends BasicGameState {
    private BuildBridgeModel bridgeModel;
    private BuildBridgeController bridgeController;
    private BuildBridgeView bridgeView;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        bridgeModel = new BuildBridgeModel();
        bridgeView = new BuildBridgeView();
        bridgeController = new BuildBridgeController(bridgeModel);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bridgeView.render(gc, g, bridgeModel);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        bridgeController.update(gc, sbg, delta);
    }

    @Override
    public int getID() { return 21; }
}
