package NPC;

import model.MapModel;
import model.MapStates.MapState;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

public class TaskHoldingNPC extends NPC {

    //state 1 elr 0, task complete eller inte, alternerar bild med/utan utroptecken
    int state;

    public SpriteSheet taskCharacter;

    /**
     * Fetches correct Sprite and creates the animation
     * @throws SlickException Generic Exception
     */
    void spriteSetupTask() throws SlickException{
    }

    /**
     * Initializes the SpriteSheets depending on the MapModel's boolean "taskDone".
     * @throws SlickException Generic Exception
     * @param mapModel
     */
    void initNPC(MapModel mapModel) throws SlickException {
    }

    @Override
    void spriteSetup() throws SlickException {

    }


    @Override
    void setLocation(int x, int y) {

    }

    @Override
    public MapState getCurrent() {
        return null;
    }

    @Override
    Point getLocation() {
        return null;
    }

    @Override
    public void setShowing(boolean isItShowing) {

    }
}
