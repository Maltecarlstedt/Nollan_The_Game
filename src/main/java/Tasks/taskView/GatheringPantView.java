package Tasks.taskView;

import Tasks.taskController.GatheringPantController;
import Tasks.taskModel.GatheringPantModel;
import Tasks.taskModel.Pant;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GatheringPantView {

    public GatheringPantModel pantModel;
    public GatheringPantController pantController;

    /** Method to draw each pant.
     * @param gc the container that have the game.
     * @param g represents the graphics context to be used for rendering.
     * @param pantModel representing the model to get data from it.
     */
    public void render (GameContainer gc, Graphics g, GatheringPantModel pantModel) {
        for(Pant pant : pantModel.getPants()){
            g.drawImage(pant.getImage(), pant.getPantLocation().getX(), pant.getPantLocation().getY());
        }
    }

}
