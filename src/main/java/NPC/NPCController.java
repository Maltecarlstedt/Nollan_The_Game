package NPC;

import java.util.ArrayList;

/**
 * @author Julia Böckert
 * Controlls the animation of the NPCs
 * Used by MainGame
 * Uses ConcreteNPC
 */

public class NPCController {

    boolean animationUpdateIsSet = false;


    public void update(ArrayList<ConcreteNPC> NPCs, int delta) {
       if (animationUpdateIsSet) {
            for (ConcreteNPC npc : NPCs) {
                npc.animation.update(delta);
                animationUpdateIsSet = true;
            }
        }
    }

}




