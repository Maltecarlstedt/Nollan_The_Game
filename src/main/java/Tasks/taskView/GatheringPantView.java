package Tasks.taskView;

import Tasks.taskController.GatheringPantController;
import Tasks.taskModel.GatheringPantModel;
import Tasks.taskModel.Pant;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GatheringPantView {

    /** Method to draw each pant.
     * @param gc the container that have the game.
     * @param g represents the graphics context to be used for rendering.
     * @param pm representing the model to get data from it.
     */
    public void render (GameContainer gc, Graphics g, GatheringPantModel pm, GatheringPantController pc) {
        pm.getBackground().render(0,0);
        for(Pant pant : pm.getPants()){
            g.drawImage(pant.getImage(), pant.getPantLocation().getX(), pant.getPantLocation().getY());

            // the mouse
            g.setColor(Color.cyan);
            g.fill(pm.mouseBall);

            // Render our box that will have the timer inside of it.
            g.drawImage(pm.timerBox,820, 40 );
            // Render the timer.
            g.drawString(String.valueOf(pm.pantTimePassed), 835,55);
            g.drawString(String.valueOf(pc.pantGathered), 835,75);
        }
    }

}
