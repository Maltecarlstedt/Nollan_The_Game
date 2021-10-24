package NPC;

import model.MapModel;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import java.util.ArrayList;

/**
 * @author Julia Böckert
 * Draws the NPCs.
 * Used by MainGame
 * Uses ConcreteNPC, MapModel, NPCModel
 */
public class NPCView {

    public NPCView(ArrayList<ConcreteNPC> NPCs) throws SlickException {
        spriteSetup(NPCs);
    }


    /**
     * Renders the NPCs on the map. depending on the boolean isShowing.
     * @param g The graphics context to be used for rendering
     * @param model an NPCModel
     * @param NPCs an arraylist of all initialized NPCs
     * @param mp, a MapModel
     */
    public void render(Graphics g, NPCModel model, ArrayList<ConcreteNPC> NPCs, MapModel mp) throws SlickException {
        model.showNPC(mp);
        drawNPC(g, NPCs);

    }

    /**
     * Displays the NPC if it should be visible
     * @param NPCs - the ArrayList with all NPCs
     * @param g The grapchics context to be used for rendering
     */


    void drawNPC(Graphics g, ArrayList<ConcreteNPC> NPCs) {
        for (ConcreteNPC npc : NPCs) {
            if (npc.isShowing) {
                g.drawAnimation(npc.animation, npc.getLocation().x, npc.getLocation().y);
            }
        }
    }

    /**
     * Chooses the correct SpriteSheet for the NPCs, depending on its state
     * @param NPCs - the ArrayList with all NPCs
     */

    void spriteSetup(ArrayList<ConcreteNPC> NPCs) throws SlickException {
        for (ConcreteNPC npc : NPCs) {
            if (npc.state == 0) {
                npc.character = new SpriteSheet(npc.taskString, npc.width, npc.taskHeight);
                npc.animation.addFrame(npc.character.getSubImage(0, 0), 500);
                npc.animation.addFrame(npc.character.getSubImage(1, 0), 500);
            } else if (npc.state == 1) {
                npc.character = new SpriteSheet(npc.characterString, npc.width, npc.height);
                npc.animation.addFrame(npc.character.getSubImage(0, 0), 1);
            }


        }
    }
}








