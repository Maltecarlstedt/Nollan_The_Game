import controller.MapController;
import model.CollisionChecker;
import model.MapModel;
import model.MapStates.Gasquen;
import model.MapStates.MapState;
import model.PlayerModel;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import view.MapView;
import view.PlayerView;

/**
 * Represents the view when the game has ended
 *
 * @author Clara Simonsson
 */
public class GameDoneView extends BasicGameState {

    /**
     * The player and map
     */
    private PlayerModel playerModel;
    private PlayerView playerView;

    private boolean musicStarted = false;

    private MapModel mapModel;
    private MapView mapView;
    private MapController mapController;

    private Image endGame;

    /**
     * Initializes the player and map
     * @param gameContainer - The container that has the game
     * @param stateBasedGame - The current state of the game used to isolate the game from different aspects
     * @throws SlickException - if the file for the maps is not found, slick-exception.
     */
    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        CollisionChecker collisionChecker = new CollisionChecker();
        endGame = new Image("data/maps/images/avslutaSpeletButton.png");

        mapModel = new MapModel(collisionChecker);
        mapModel.setCurrentMap(Gasquen.INSTANCE);
        mapView = new MapView(mapModel);
        mapController = new MapController(mapModel, mapView);

        playerModel = new PlayerModel();
        playerView = new PlayerView();

    }

    private float getPositionX(){ return 200;}
    private float getPositionY(){ return 350;}
    /**
     * Draws the player and the map on the screen
     * @param gc - The container that has the game
     * @param sbg - The current state of the game used to isolate the game from different aspects
     * @param g - represents the graphics context to be used for rendering.
     * @throws SlickException - if the file for the maps is not found, slick-exception.
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapView.render(mapModel);
        playerView.render(g, playerModel);
        endGame.drawCentered(getPositionX(), getPositionY());
    }

    /**
     * Updates the player and map
     * @param gc - The container that has the game
     * @param sbg - The current state of the game used to isolate the game from different aspects
     * @param delta - represents time in ms since last update.
     * @throws SlickException - if the file for the maps is not found, slick-exception.
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        mapController.update(gc, delta, mapModel);

        int posX = Mouse.getX();
        int posY = Mouse.getY();

        //Todo The y-position on the image are inverse to the y-position for the mouse. Is there a way to change this?
        if (xPosIntersection(posX) && yPosIntersection(posY) && Mouse.isButtonDown(0)) {
            System.exit(0);
        }
        if(!musicStarted){
            startMusic();
        }


    }

    private void startMusic(){
        try{
            Sound anthem = new Sound("data/music/Stad_i_ljus.wav");
            anthem.play((float)1, 1);
            musicStarted = true;
        }catch(SlickException e){
            e.printStackTrace();
        }

    }

    private boolean xPosIntersection(int posX){
        return (getStartX() < posX && posX < getEndX());
    }
    private boolean yPosIntersection(int posY){
        return (getStartY() > posY && posY > getEndY());
    }

    private float getStartX(){
        return (getPositionX() - (endGame.getWidth()/2f));
    }

    private float getEndX(){
        return (getPositionX() + (endGame.getWidth()/2f));
    }

    private float getStartY(){
        return getEndY()*5;
    }

    private float getEndY(){
        return (getPositionY() + (endGame.getHeight()/4f));
    }

    /** A special ID for this specific state.
     * @return represents this state with a unique int.
     */
    @Override
    public int getID() {
        return 100;
    }
}
