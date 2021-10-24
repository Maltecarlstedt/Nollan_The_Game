package Tasks.taskView;

import Tasks.taskModel.BuildBridgeModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.awt.image.PixelGrabber;

/**
 * Draws the view of the task
 * Uses: BuildBridgeModel
 * Used by: BuildBridgeController, BuildBridgeTask
 * @author Clara Simonsson
 */
public class BuildBridgeView {

    /**
     * Draws the image of the bridge on the view. Texts with descriptions will appear.
     * @param g represents the graphics context to be used for rendering.
     * @param bridgeModel represent the model to get data from
     */
    public void render(Graphics g, BuildBridgeModel bridgeModel){
        g.drawImage(bridgeModel.bridgeImage, bridgeModel.getBridgeLocation().x, bridgeModel.getBridgeLocation().y);
        g.drawString("Uppgiften ej klar", 400, 350);
        g.drawString("Tryck F för att avsluta", 400, 400);
    }

    private void grabPixels(){
        PixelGrabber imageGrabber;
    }
}
