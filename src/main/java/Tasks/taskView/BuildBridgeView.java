package Tasks.taskView;

import Tasks.taskModel.BuildBridgeModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.awt.image.PixelGrabber;

public class BuildBridgeView {

    public void render(GameContainer gc, Graphics g, BuildBridgeModel bridgeModel){
        g.drawImage(bridgeModel.bridgeImage, bridgeModel.getBridgeLocation().x, bridgeModel.getBridgeLocation().y);
        g.drawString("Uppgiften ej klar", 400, 350);
        g.drawString("Tryck F för att avsluta", 400, 400);
    }

    private void grabPixels(){
        PixelGrabber imageGrabber;
    }
}
