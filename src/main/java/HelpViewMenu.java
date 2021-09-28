import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class HelpViewMenu extends BasicGameState {

    Image bg;
    Image infoText;
    Image startGame;
    // Image backButton;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        bg = new Image("data/maps/images/startscreen.png");
        infoText = new Image("data/maps/images/helpText.png");
        startGame = new Image("data/maps/images/borjaSpela.png");
        //backButton = new Image("data/maps/images/backButton.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        bg.draw();
        infoText.drawCentered(1024/2,768/2);
        startGame.drawCentered(1024/2,616);
        //backButton.drawCentered(1024/2,616);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        // back to the menu button
        if ((posX > 243 && posX < 781) && (posY > 106 && posY < 194)) {
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
            }
        }
    }

    @Override
    public int getID() {
        return 5;
    }

}
