import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class StateSetup extends StateBasedGame {


    public StateSetup(String title) {
        super(title);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new GameMenu());
        this.addState(new MainGame());
        enterState(0);



    }
}
