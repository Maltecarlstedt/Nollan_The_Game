package Tasks.taskModel;

import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.awt.Font;
import java.io.InputStream;

/**
 * @author Clara
 */
public class BuildBridgeModel {

    public Image bridgeImage;
    public Point bridgeLocation;

    public BuildBridgeModel() throws SlickException {
        initBridgeImage();
    }

    /**
     * Initialize the image that will be used in the task
     * @throws SlickException throws an exception if a filepath is not found
     */
    public void initBridgeImage() throws SlickException {
        bridgeImage = new Image("data/buildBridge/bridge.jpg");
        bridgeLocation = new Point(0, 0);
    }

    public Point getBridgeLocation(){ return bridgeLocation;}

}
