package Tasks.taskModel;

import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.awt.Font;
import java.io.InputStream;

public class BuildBridgeModel {

    public Image bridgeImage;
    public Point bridgeLocation;

    public BuildBridgeModel() throws SlickException {
        initBridgeImage();
    }

    public void initBridgeImage() throws SlickException {
        bridgeImage = new Image("data/buildBridge/bridge.jpg");
        bridgeLocation = new Point(0, 0);
    }

    public Point getBridgeLocation(){ return bridgeLocation;}

}
