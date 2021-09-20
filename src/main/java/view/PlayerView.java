package view;

import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class PlayerView {



    public PlayerView() throws SlickException {
    }

    public void render(GameContainer gc, Graphics g, PlayerModel playerModel){
        g.drawAnimation(playerModel.currentAnimation, playerModel.getLocation().x,playerModel.getLocation().y);

    }

    public void drawIdlePlayer(PlayerModel playerModel){

        //playerModel.currentImage.draw(playerModel.getLocation().x, playerModel.getLocation().y,playerModel.getWidth(),playerModel.getHeight());


    }

    public void drawRunningPlayer(PlayerModel playerModel){

        //playerModel.currentAnimation.draw(playerModel.getLocation().x,playerModel.getLocation().y, playerModel.getWidth(), playerModel.getHeight());


    }
}
