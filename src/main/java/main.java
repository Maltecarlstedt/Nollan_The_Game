import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class main {
    public static final int canvasWidth = 1024;
    public static final int canvasHeight = 768;

    // TODO: Gör fönstret scaleable

    public static void main(String[] args) {
        // TODO: Kolla upp om detta kan lösa så att library sätts automatiskt eller om vi ska använda nån jävla mavenskit
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
