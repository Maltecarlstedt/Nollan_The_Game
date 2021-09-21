import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class GameMenu extends BasicGameState {

    Image startGame;
    Image exitGame;

    /*
    public Menu(int state) {

    }
*/

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        startGame = new Image("data/maps/images/startaSpeletButton.png");
        exitGame = new Image("data/maps/images/avslutaButton.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        startGame.drawCentered(1024/2,768/2);
        exitGame.drawCentered(1024/2,500);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        // start game button
        if ((posX > 243 && posX < 781) && (posY > 337 && posY < 431)) {
            if (Mouse.isButtonDown(0)) {
                sbg.enterState(1);
            }
        }

        // exit game button
        if ((posX > 243 && posX < 781) && (posY > 221 && posY < 315)) {
            if (Mouse.isButtonDown(0)) {
                System.exit(0);
            }
        }
    }

    @Override
    public int getID() {
        return 0;
    }
}
