import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState  extends BasicGameState {

    private int state = 0;
    private Image playerGuyMan = null;
    private SpriteSheet player = null;
    private Animation walkDownAnimation, walkLeftAnimation,
            walkRightAnimation, walkUpAnimation;
    private Player player1 = new Player();
    private Image map = null;



    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        playerGuyMan = new Image("data/playerAnimation/gubbe.png");
        map = new Image("data/maps/testMap.png");
        player = new SpriteSheet(playerGuyMan,(int)(1841/4),2400/4);
        player1.setLocation(200, 500);
        animationSetup();


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {


    }

    public void animationSetup(){
        walkDownAnimation = new Animation();
        walkLeftAnimation = new Animation();
        walkRightAnimation = new Animation();
        walkUpAnimation = new Animation();

        for(int i = 0; i <= 3; i++){
            walkDownAnimation.addFrame(player.getSubImage(i, 0), 200);
        }
        for(int i = 0; i <= 3; i++){
            walkRightAnimation.addFrame(player.getSubImage(i, 1), 200);
        }
        for(int i = 0; i <= 3; i++){
            walkLeftAnimation.addFrame(player.getSubImage(i, 2), 200);
        }
        for(int i = 0; i <= 3; i++){
            walkUpAnimation.addFrame(player.getSubImage(i, 3), 200);
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        map.draw(0,0,SetupClass.canvasWidth, SetupClass.canvasHeight);

        if(gameContainer.getInput().isKeyDown(Input.KEY_DOWN)){
            player1.setOrientation(Orientation.DOWN);
            player1.move();
            walkDownAnimation.draw((float)player1.getLocation().getX(), (float)player1.getLocation().getY(), 45, 60);
            state = 0;
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_LEFT)) {
            player1.setOrientation(Orientation.LEFT);
            player1.move();
            walkLeftAnimation.draw((float) player1.getLocation().getX(), (float) player1.getLocation().getY(), 45, 60);
            state = 2;
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_RIGHT)) {
            player1.setOrientation(Orientation.RIGHT);
            player1.move();
            walkRightAnimation.draw((float) player1.getLocation().getX(), (float) player1.getLocation().getY(), 45, 60);
            state = 1;
        }else if(gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            player1.setOrientation(Orientation.UP);
            player1.move();
            walkUpAnimation.draw((float) player1.getLocation().getX(), (float) player1.getLocation().getY(), 45, 60);
            state = 3;
        }else{
            if(state != 2) {
                player1.setOrientation(Orientation.IDLE);
                player.getSubImage(1, state).draw((float) player1.getLocation().getX(), (float) player1.getLocation().getY(), 45, 60);

            }else{
                player1.setOrientation(Orientation.IDLE);
                player.getSubImage(0,state).draw((float) player1.getLocation().getX(), (float) player1.getLocation().getY(), 45, 60);

            }
        }

    }



    @Override
    public int getID() {
        return 0;
    }
}


