import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState { //TODO: Ska detta verkligen extenda BasicGameState?

    /**
     * Declares our map variable as well as our player.
     */
    Map map = new Map();

    Player player = new Player();

    beerChugging beerChugg = new beerChugging();
    JumpingBeer jumpingBeer = new JumpingBeer();
    ChugIndicator chugIndicator = new ChugIndicator();
    public int currentTime;
    public int deltaTime;

    double velocityY;
    int y0 = 635;
    double t = 0.0;
    public double gravity = 9.8;


    public int numberOfChugs = 0;


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
        beerChugg.initBeerChugging();
        chugIndicator.initChugIndicator();
        jumpingBeer.initJumpingBeer();
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

        currentTime += delta;
        deltaTime = delta;

        player.MoveRightAni.update(delta); // this line makes sure the speed of the Animation is true
        player.MoveUpAni.update(delta); // this line makes sure the speed of the Animation is true
        player.MoveLeftAni.update(delta); // this line makes sure the speed of the Animation is true
        player.MoveDownAni.update(delta); // this line makes sure the speed of the Animation is true
        //beerChugg.beerAni.update(delta/2);
        chugIndicator.bar_inidcatorAni.update(delta);

        Input input = gameContainer.getInput();

        map.isOutside(player);
        updateJump();
        if (input.isKeyPressed(Input.KEY_F)){
            updateJump();

        }

        if (input.isKeyPressed(Input.KEY_SPACE)){
            beerChugg.numberOfChugs = beerChugg.numberOfChugs + 1;
            beerChugg.chug();
        }

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

    public int getCurrentTime(){
        return currentTime;
    }

    public void updateJump(){
        jumpingBeer.location.y = (int) (y0 + velocityY * t + 0.5 * gravity * t * t);
        if(jumpingBeer.location.y > 635){
            jumpingBeer.location.y = y0 = 0;
            t = 0.0;
        } else {
            y0 = jumpingBeer.location.y;
            t += 0.25;
        }
        jumpingBeer.jumpingBeer.draw(jumpingBeer.getLocation().x,jumpingBeer.getLocation().y,jumpingBeer.getWidth(),jumpingBeer.getHeight());




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

        beerChugg.currentBeerImage.draw(beerChugg.getLocation().x,beerChugg.getLocation().y, beerChugg.getWidth(), beerChugg.getHeight());
        chugIndicator.bar_inidcatorAni.draw(chugIndicator.getLocation().x, chugIndicator.getLocation().y,chugIndicator.getWidth(), chugIndicator.getHeight());
        jumpingBeer.jumpingBeer.draw(jumpingBeer.getLocation().x,jumpingBeer.getLocation().y,jumpingBeer.getWidth(),jumpingBeer.getHeight());





        //TODO: borde använda graphics.drawImage(player.getCurrentImage, player.getLocation().x, player.getLocation().y)??
        //TODO: Samma med graphics.drawAnimation(...) som ^^^^?


        if(player.getOrientation() == Orientation.IDLE){//TODO: Ingen logik i render
            player.currentImage.draw(player.getLocation().x, player.getLocation().y,player.getWidth(),player.getHeight());
        }else{
            player.currentAnimation.draw(player.getLocation().x,player.getLocation().y, player.getWidth(), player.getHeight());
        }

    }


    /**
     * @return the ID of this game state
     */
    @Override
    public int getID() {
        return 0;
    }
}


