import model.MapModel;
import model.MapStates.MapState;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class EnterTask {

    private Input input;
    private String currMap;


    // Denna kollar hela tiden ifall vilkoren i IF satsen är uppfyllda och hoppar isåfall in i korrekt state.
    // Den är absolut inte klar
    // Den hämtar heller inte rätt karta. Eller snarare ingen karta alls.


    public void update(GameContainer gc, PlayerModel playerModel, MapModel mapModel, StateBasedGame sbg){
        input = gc.getInput();
        currMap = mapModel.getCurrentMap().toString();

        if (currMap.equals("EKAK") && input.isKeyPressed(Input.KEY_F)){
            sbg.enterState(69, new EmptyTransition(), new HorizontalSplitTransition()); // Idk ser lite dumt ut

        }

        if (currMap.equals("DELTAP") && input.isKeyPressed(input.KEY_F)){
            sbg.enterState(420, new EmptyTransition(), new VerticalSplitTransition());
        }

        if (currMap.equals("KARHUSET") && input.isKeyPressed(input.KEY_F)){
            sbg.enterState(21, new FadeOutTransition(), new VerticalSplitTransition());
        }

    }


}
