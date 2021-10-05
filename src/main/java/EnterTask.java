import model.MapModel;
import model.MapStates.MapState;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class EnterTask {

    private Input input;
    private String currMap;
    private TaskManager taskManager;

    public void update(GameContainer gc, PlayerModel playerModel, MapModel mapModel, StateBasedGame sbg){
        input = gc.getInput();
        currMap = mapModel.getCurrentMap().toString();

        if (currMap.equals("EKAK") && input.isKeyPressed(Input.KEY_F)){
            sbg.enterState(2);

        }

        //System.out.println(mapModel.getCurrentMap());

    }

    private void playerChecker(PlayerModel playerModel) {



    }
}
