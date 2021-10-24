import Tasks.BeerChugginTask;
import Tasks.BuildBridgeTask;
import Tasks.GatheringCansTask;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * @author Malte Carlstedt
 * A class for keeping all of our different states.
 */

public class StateSetup extends StateBasedGame {


    public StateSetup(String title) {
        super(title);
    }

    /**
     * Adds all the different states so that they can be referenced to later on. Then enters the first state
     * @param gameContainer The container that have the game
     * @throws SlickException Generic exception
     */
    @Override
    public void initStatesList(GameContainer gameContainer) {
        this.addState(new GameMenu());
        this.addState(new HelpViewMenu());
        this.addState(new BeerChugginTask());
        this.addState(new BuildBridgeTask());
        this.addState(new GatheringCansTask());
        this.addState(new GameDoneView());
        this.addState(new MainGame());
        // Enters state 0
        enterState(0);
    }
}
