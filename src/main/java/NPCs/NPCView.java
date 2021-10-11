package NPCs;

import model.MapModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 * Our view of the NPCs. The class that draws the NPCs.
 */


public class NPCView {


    /**
     * Renders the NPCs on the map. depending on the boolean isShowing.
     * @param g The graphics context to be used for rendering
     */

    public void render(Graphics g, ArrayList<NPC> NPCs) {
        for (NPC npc : NPCs) {
            if (npc.isShowing) {
                g.drawAnimation(npc.animation, npc.getLocation().x, npc.getLocation().y);
            }
        }
    }

    /**
     * Displays the NPCs on the map that they belong to.
     * @param mapModel
     */
    public void showNPC(MapModel mapModel) {
        for (NPCs.NPC npc : NPCs) {
            if (npc.getCurrent().equals(mapModel.getCurrentMap())) {
                npc.setShowing(true);
            }
            if ((npc.getCurrent() != mapModel.getCurrentMap())) {
                npc.setShowing(false);
            }
        }

    }






}





