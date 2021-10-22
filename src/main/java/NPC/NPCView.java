package NPC;

import model.MapModel;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Julia Böckert
 * Our view of the NPCs. The class that draws the NPCs.
 */
public class NPCView {

    public NPCView(ArrayList<ConcreteNPC> NPCs) throws SlickException {
        spriteSetup(NPCs);
        //showNPC(mp, model, NPCs);
    }


    /**
     * Renders the NPCs on the map. depending on the boolean isShowing.
     *
     * @param g The graphics context to be used for rendering
     */
    public void render(Graphics g, NPCModel model, ArrayList<ConcreteNPC> NPCs, MapModel mp) throws SlickException {
        model.showNPC(mp);
        drawNPC(g, NPCs);

    }

    void drawNPC(Graphics g, ArrayList<ConcreteNPC> NPCs) {
        for (ConcreteNPC npc : NPCs) {
            if (npc.isShowing) {
                g.drawAnimation(npc.animation, npc.getLocation().x, npc.getLocation().y);
            }
        }
    }

    /**
     * Displays the NPCs on the map that they belong to.
     *
     * @param mp - the current MapModel
     * @param NPCs - the ArrayList with all NPCs
     */
    void showNPC(MapModel mp, ArrayList<ConcreteNPC> NPCs) {
        NPCs.forEach(npc -> {
            if (npc.getCurrent().equals(mp.getCurrentMap())) {
                npc.setShowing(true);
            }
            if (npc.getCurrent() != mp.getCurrentMap()) {
                npc.setShowing(false);
            }
        });

    }

    void spriteSetup(ArrayList<ConcreteNPC> NPCs) throws SlickException {
        for (ConcreteNPC npc : NPCs) {
            if (npc.state == 0) {
                npc.taskCharacter = new SpriteSheet(npc.taskString, npc.width, npc.taskHeight);
                npc.animation.addFrame(npc.taskCharacter.getSubImage(0, 0), 500);
                npc.animation.addFrame(npc.taskCharacter.getSubImage(1, 0), 500);
            } else if (npc.state == 1) {
                npc.character = new SpriteSheet(npc.characterString, npc.width, npc.height);
                npc.animation.addFrame(npc.character.getSubImage(0, 0), 1);
            }


        }
    }
}








