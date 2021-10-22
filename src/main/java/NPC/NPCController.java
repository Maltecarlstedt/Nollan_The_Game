package NPC;

import model.MapModel;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

/**
 * @author Julia Böckert
 */

public class NPCController {

    boolean animationUpdateIsSet = false;

    public NPCController() throws SlickException {

    }

    public void update(ArrayList<ConcreteNPC> NPCs, int delta) {
        if (animationUpdateIsSet) {
            for (ConcreteNPC npc : NPCs) {
                npc.animation.update(delta);
                animationUpdateIsSet = true;
            }
        }
    }

}




