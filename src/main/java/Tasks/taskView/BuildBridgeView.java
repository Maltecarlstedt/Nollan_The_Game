package Tasks.taskView;

import Tasks.taskModel.BuildBridgeModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class BuildBridgeView {

    public void render(GameContainer gc, Graphics g, BuildBridgeModel bridgeModel){
        g.drawImage(bridgeModel.bridgeImage, bridgeModel.getBridgeLocation().x, bridgeModel.getBridgeLocation().y);
    }
}
