import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class GameState extends BasicGameState { //TODO: Ska detta verkligen extenda BasicGameState?

    /**
     * Declares our map variable as well as our player.
     */
    Map map = new Map();

    Player player = new Player();


    /**
     * Initialise this state. It should load any resources it needs at this stage, in our case our map and our player
     * @param gameContainer The container holding the game
     * @param stateBasedGame The game holding this state
     * @throws SlickException creates an exception if the map file is not found
     */

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        map.initMap();
        player.initPlayer();
    }

    /**
     * Update the state's logic based on the amount of time that has passed.
     * In our update we check the keypresses and updates the game accordingly
     * Updates the animation based on the time that has passed since the last update.
     * @param gameContainer The container holding the game
     * @param stateBasedGame The game holding this state
     * @param delta The amount of time that has passed in millisecond since last update
     * @throws SlickException creates an exception if the map file is not found
     */
    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        player.MoveRightAni.update(delta); // this line makes sure the speed of the Animation is true
        player.MoveUpAni.update(delta); // this line makes sure the speed of the Animation is true
        player.MoveLeftAni.update(delta); // this line makes sure the speed of the Animation is true
        player.MoveDownAni.update(delta); // this line makes sure the speed of the Animation is true

        int objectLayer = map.getTiledMap().getLayerIndex("collision");
        Input input = gameContainer.getInput();

        map.isOutside(player);


        if (input.isKeyDown(Input.KEY_UP))
        {
            if(map.getTiledMap().getTileId((player.getLocation().x)/32,
                    (player.getLocation().y - 16)/32 + 2, objectLayer) == 0
            && map.getTiledMap().getTileId((player.getLocation().x + 64)/32,
                    (player.getLocation().y - 16)/32 + 2, objectLayer) == 0) {
                player.moveUp();
            }

        }else if (input.isKeyDown(Input.KEY_LEFT))
        {
            if(map.getTiledMap().getTileId((player.getLocation().x)/32 + 1,
                    (player.getLocation().y)/32, objectLayer) == 0
            && map.getTiledMap().getTileId((player.getLocation().x)/32 + 1,
                    (player.getLocation().y + 64)/32, objectLayer) == 0) {
                player.moveLeft();
            }
        }else if (input.isKeyDown(Input.KEY_RIGHT))
        {
            if(map.getTiledMap().getTileId((player.getLocation().x)/32 + 2,
                    (player.getLocation().y + 32)/32, objectLayer) == 0
            && map.getTiledMap().getTileId((player.getLocation().x)/32 + 2,
                    (player.getLocation().y)/32, objectLayer) == 0) {
                player.moveRight();
            }

        }else if (input.isKeyDown(Input.KEY_DOWN))
        {

            if(map.getTiledMap().getTileId((player.getLocation().x + 64)/32,
                    (player.getLocation().y)/32 + 2, objectLayer) == 0
            && map.getTiledMap().getTileId((player.getLocation().x)/32,
                    (player.getLocation().y)/32 + 2, objectLayer) == 0) {
                player.moveDown();
            }
        }else{
            player.idlePlayer();
        }


    }


    /**
     * Render this state to the game's graphics context, in our program that is the background image and the player
     * @param gameContainer The container holding the game
     * @param stateBasedGame The game holding this state
     * @param graphics The graphics context to render to
     * @throws SlickException creates an exception if the map or player image file is not found
     */
    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        map.render();

        //TODO: borde använda graphics.drawImage(player.getCurrentImage, player.getLocation().x, player.getLocation().y)??
        //TODO: Samma med graphics.drawAnimation(...) som ^^^^?


        if(player.getOrientation() == Orientation.IDLE){//TODO: Ingen logik i render
            player.currentImage.draw(player.getLocation().x, player.getLocation().y,player.getWidth(),player.getHeight());
        }else{
            player.currentAnimation.draw(player.getLocation().x,player.getLocation().y, player.getWidth(), player.getHeight());
        }

    }



    public static boolean checkRightCollision(){

        return false;
    }
    public static boolean checkLeftCollision(){

        return false;
    }
    public static boolean checkUpCollision(){

        return false;
    }
    public static boolean checkDownCollision(){

        return false;
    }

    /**
     * @return the ID of this game state
     */
    @Override
    public int getID() {
        return 0;
    }
}


