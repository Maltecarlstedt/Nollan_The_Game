package Tasks.taskView;

import Tasks.taskController.GatheringPantController;
import Tasks.taskModel.GatheringPantModel;
import Tasks.taskModel.Pant;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GatheringPantView {

    /**
     * GatheringPantView should draw the pripps-images (data/maps/images/pripps_pant.png)
     */

    GatheringPantModel pantModel;
    GatheringPantController pantController;



    public void render (GameContainer gc, Graphics g, GatheringPantModel pantModel) {
        for(Pant pant : pantModel.getPants()){
            g.drawImage(pant.getImage(), pant.getPantLocation().getX(), pant.getPantLocation().getY());
            //System.out.println(pant.getHeight());
        }

    }

}
