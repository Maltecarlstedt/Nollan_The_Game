import controller.PlayerController;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.PlayerView;

public class MainGame extends BasicGameState {

    PlayerModel playerModel;
    PlayerView playerView;
    PlayerController playerController;

    public MainGame() throws SlickException {
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        playerModel = new PlayerModel();
        playerView = new PlayerView();
        playerController = new PlayerController(playerModel, playerView);

    }
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        playerView.render(gc, g, playerModel);


    }
    @Override
    public void update(GameContainer gc, StateBasedGame stateBasedGame, int delta) throws SlickException {
        playerController.update(gc,delta);

    }

    @Override
    public int getID() {
        return 1;
    }
}
