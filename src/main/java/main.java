import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 * Main class that setups and creates our game application.
 */
public class main {
    public static final int canvasWidth = 1024;
    public static final int canvasHeight = 768;

    // TODO: Make the game scaleable.

    public static void main(String[] args) {
        // TODO: Set up Maven so that the librarys automatically load for new users.
        //System.setProperty("org.lwjgl.librarypath", new File( new File( System.getProperty("user.dir") , "native") , LWJGLUtil.getPlatformName() ).getAbsolutePath() );

        try {
            AppGameContainer app = new AppGameContainer(new StateSetup("Nollans Första Dag"));
            app.setIcons(new String[]{"data/icon32.png", "data/icon16.png"});
            app.setTargetFrameRate(60);
            app.setShowFPS(false);
            app.setAlwaysRender(true);
            app.setDisplayMode(canvasWidth,canvasHeight,false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
