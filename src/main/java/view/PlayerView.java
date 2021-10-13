package view;

import model.PlayerModel;
import org.newdawn.slick.Graphics;

/**
 * Our view of the player. The class that draws the player.
 */
public class PlayerView {

    /**
     * Draws the player on the canvas
     * @param g The graphics context to be used for rendering
     * @param playerModel Model of the player that is to be rendered
     */
    public void render(Graphics g, PlayerModel playerModel){
        g.drawAnimation(playerModel.currentAnimation, (float)playerModel.getPlayerLocation().getX(), (float)playerModel.getPlayerLocation().getY());
    }

}
