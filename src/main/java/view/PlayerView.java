package view;

import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class PlayerView {

    public PlayerView() throws SlickException {
    }

    public void render(GameContainer gc, Graphics g, PlayerModel playerModel){
        g.drawAnimation(playerModel.currentAnimation, playerModel.getPlayerLocation().x,playerModel.getPlayerLocation().y);
    }

}
