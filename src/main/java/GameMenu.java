import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

public class GameMenu extends BasicGameState {

    Image startGame;
    Image exitGame;
    Image background;
    Image nollan;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        nollan = new Image("data/maps/images/Nollan.png");
        background = new Image("data/maps/images/startscreen.png");
        startGame = new Image("data/maps/images/startaButton.png");
        exitGame = new Image("data/maps/images/avslutaButton.png");

        AePlayWave aw = new AePlayWave( "data/music/Mycket Mera Scout - Webscout.wav" );
        aw.start();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        background.draw();
        nollan.draw(1024/6,90, 2);
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
