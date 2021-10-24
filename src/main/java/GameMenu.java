import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
 * @author Steffanie Kristiansson
 * Represents the start game menu with some buttons, uses BasicStateGame.
 */
public class GameMenu extends BasicGameState {

    /** Images representing "buttons".
     */
    Image startGame;
    Image exitGame;
    Image background;
    Image nollan;
    Image help;
    Image fullScreen;

    /** Initiating the images.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @throws SlickException Generic exception
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        nollan = new Image("data/maps/images/Nollan.png");
        background = new Image("data/maps/images/startscreen.png");
        startGame = new Image("data/maps/images/startaButton.png");
        exitGame = new Image("data/maps/images/avslutaButton.png");
        help = new Image("data/maps/images/hjalpButton.png");
        fullScreen = new Image("data/fullscreen_V2.png");
    }

    /** Render all the images.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param g represents the graphics context to be used for rendering.
     * @throws SlickException Generic exception
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        background.draw();
        nollan.draw(1024/6,90, 2);
        startGame.drawCentered(1024/2,768/2);
        exitGame.drawCentered(1024/2,616);
        help.drawCentered(1024/2,500);
        fullScreen.draw(950, 700);
    }

    /** Check the mouse, if clicked in specific area, move to state.
     * @param gc represents the container that have the game.
     * @param sbg the current state of the game used to isolate the game from different aspects.
     * @param delta represents time in ms since last update.
     * @throws SlickException Generic exception
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        // start game button
        if ((posX > 243 && posX < 781) && (posY > 337 && posY < 431)) {
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(101, new FadeOutTransition(), new FadeInTransition());
            }
        }

        // help button
        if ((posX > 243 && posX < 781) && (posY > 221 && posY < 315)) {
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(5, new FadeOutTransition(), new FadeInTransition());
            }
        }

        // exit game button
        if ((posX > 243 && posX < 781) && (posY > 106 && posY < 194)) {
            if (Mouse.isButtonDown(0)) {
                System.exit(0);
            }
        }

        // fullscreen button
        if ((posX > 950 && posX < 1011) && (posY > 8 && posY < 65)){
            if (Mouse.isButtonDown(0)){
                gc.setFullscreen(true);
            }
        }



    }

    /** A special ID for this specific state.
     * @return represents this state with a unique int.
     */
    @Override
    public int getID() {
        return 0;
    }
}
