import Tasks.taskController.BeerChuggingController;
import Tasks.taskModel.BeerChuggingModel;
import Tasks.taskView.BeerChuggingView;
import model.MapModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import Tasks.taskController.GatheringPantController;
import Tasks.taskModel.GatheringPantModel;
import Tasks.taskView.GatheringPantView;
import view.MapView;


public class TaskManager extends BasicGameState {

    private MapModel mapModel;
    private MapView mapView;

    private BeerChuggingModel beerChuggingModel;
    private BeerChuggingView beerChuggingView;
    private BeerChuggingController beerChuggingController;

    private GatheringPantModel pantModel;
    private GatheringPantController pantController;
    private GatheringPantView pantView;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        mapModel = new MapModel();
        mapView = new MapView();

        beerChuggingModel = new BeerChuggingModel();
        beerChuggingView = new BeerChuggingView();
        beerChuggingController = new BeerChuggingController(beerChuggingModel, beerChuggingView);

        //pantModel = new GatheringPantModel();
        //pantView = new GatheringPantView();
        //pantController = new GatheringPantController(pantModel, pantView);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        mapView.render(gc, g, mapModel);
        beerChuggingView.render(gc, g, beerChuggingModel);
        //pantView.render(gc, g, pantModel);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        beerChuggingController.update(gc, delta);
        //pantController.update(gc, delta);
    }

    public void taskPicker(int taskIndex){


    }

    @Override
    public int getID() {
        return 2;
    }
}
