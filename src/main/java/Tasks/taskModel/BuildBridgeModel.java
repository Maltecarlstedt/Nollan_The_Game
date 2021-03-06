package Tasks.taskModel;

import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.awt.Font;
import java.io.InputStream;

/**
 * The logic behind the BuildBridgeTask.
 * This class has some view attributes which shouldn't be in the model.
 * If we should continue to work with this class, we would focus on get rid of the methods that
 * needs to throw a SlickException because that should be in the view instead.
 * Used by: BuildBridgeView, BuildBridgeController, BuildBridgeTask
 * @author Clara Simonsson
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
