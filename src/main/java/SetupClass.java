import SceneBuilder.Main;
import javafx.application.Application;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class SetupClass extends StateBasedGame {
    public static final int canvasWidth = 1024;
    public static final int canvasHeight = 768;

    public SetupClass(String title) {
        super(title);
    }



    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        //this.addState(new StartMenu());

        Application.launch(Main.class);
        //Platform.setImplicitExit(false);
        this.addState(new GameState());

    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new SetupClass("Nollans Första Dag"));


        app.setIcons(new String[]{"data/icon32.png", "data/icon16.png"});

        app.setTargetFrameRate(60);


        app.setShowFPS(false);

        app.setDisplayMode(canvasWidth,canvasHeight,false);
        app.start();
    }
}
