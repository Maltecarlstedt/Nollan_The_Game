import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class GameState extends BasicGameState {

    private TiledMap map;

    Player player = new Player();

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        map = new TiledMap("data/maps/chalmers_hallplatsen.tmx");
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


        }else if (input.isKeyDown(Input.KEY_LEFT))
        {
            player.moveLeft();
        }else if (input.isKeyDown(Input.KEY_RIGHT))
        {
            player.moveRight();
        }else if (input.isKeyDown(Input.KEY_DOWN))
        {
            player.moveDown();
        }else{
            player.idlePlayer();
        }


    }



    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        map.render(0,0);

        if(player.getOrientation() == Orientation.IDLE){//TODO: Ingen logik i render
            player.currentImage.draw(player.getLocation().x, player.getLocation().y,player.getWidth(),player.getHeight());
        }else{
            player.currentAnimation.draw(player.getLocation().x,player.getLocation().y, player.getWidth(), player.getHeight());
        }

    }



    @Override
    public int getID() {
        return 0;
    }
}


