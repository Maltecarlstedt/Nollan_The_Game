import java.awt.Font;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

public class StartMenu extends BasicGameState {

    private TiledMap map;
    UnicodeFont uFont;


    @Override
    public int getID() {
        return 007;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        //Font font = new Font("Serif", Font.BOLD, 20);
        //uFont = new UnicodeFont(font, font.getSize(), font.isBold(), font.isItalic());
        map = new TiledMap("data/maps/startMenu.tmx");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        map.render(0,0);
        //graphics.setFont(uFont);
        //graphics.setColor(Color.white);
        graphics.drawString("Hej Nollan! För att börja ditt äventyr på chalmers, tryck S", 206, 384);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_S)) {
            stateBasedGame.enterState(0, new FadeOutTransition(), new FadeInTransition());
        }
    }
}
