import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * @author Steffanie Kristiansson
 * Represents the help view menu.
 */
public class HelpViewMenu extends BasicGameState {

    /** Some images representing "buttons".
     */
    Image bg;
    Image infoText;
    Image startGame;


    /** Initiating the images.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @throws SlickException SlickException if file not found, slick-exception.
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        bg = new Image("data/maps/images/startscreen.png");
        infoText = new Image("data/maps/images/helpText.png");
        startGame = new Image("data/maps/images/borjaSpela.png");
    }

    /** Rendering all the images.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param g represents the graphics context to be used for rendering.
     * @throws SlickException SlickException if file not found, slick-exception.
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        bg.draw();
        infoText.drawCentered(1024/2,768/2);
        startGame.drawCentered(1024/2,616);
    }

    /** Checks the mouse, and enters a state if "if-statement" is fulfilled.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param delta represents time in ms since last update.
     * @throws SlickException SlickException if file not found, slick-exception.
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        // start the game button
        if ((posX > 243 && posX < 781) && (posY > 106 && posY < 194)) {
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(101, new FadeOutTransition(), new FadeInTransition());
            }
        }
        // TODO: fix a back "button" to get to the main menu
    }

    /** A special ID for this specific state.
     * @return represents this state with a unique int.
     */
    @Override
    public int getID() {
        return 5;
    }

}
