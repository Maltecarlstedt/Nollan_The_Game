import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {



    private Image map;

    Player player = new Player();



    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        map = new Image("data/maps/testMap.png");
        player.initPlayer();


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        player.MoveRightAni.update(delta); // this line makes sure the speed of the Animation is true
        player.MoveUpAni.update(delta); // this line makes sure the speed of the Animation is true
        player.MoveLeftAni.update(delta); // this line makes sure the speed of the Animation is true
        player.MoveDownAni.update(delta); // this line makes sure the speed of the Animation is true

        Input input = gameContainer.getInput();

        if (input.isKeyDown(Input.KEY_UP))
        {
            player.moveUp();
            player.currentImage = player.MoveUpAni;

        }
        if (input.isKeyDown(Input.KEY_LEFT))
        {
            player.moveLeft();
            player.currentImage = player.MoveLeftAni;
        }
        if (input.isKeyDown(Input.KEY_RIGHT))
        {
            player.moveRight();
            player.currentImage = player.MoveRightAni;
        }
        if (input.isKeyDown(Input.KEY_DOWN))
        {
            player.moveDown();
            player.currentImage = player.MoveDownAni;
        }


    }



    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        map.draw(0,0,SetupClass.canvasWidth, SetupClass.canvasHeight);

        player.currentImage.draw(player.x, player.y);

    }



    @Override
    public int getID() {
        return 0;
    }
}


