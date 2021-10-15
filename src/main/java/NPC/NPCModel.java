package NPC;
import model.MapModel;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class NPCModel {

    NPCFactory factory; // = new NPCFactory();
    NPCView npcView;
    public ArrayList<NPC> NPCs; // = new ArrayList<>();

    NPC webers;
    NPC kritan;
    NPC tango;
    NPC ekak1;
    NPC ekak2;
    NPC bieber;
    NPC kvalle;
    NPC dnollk;

 /*
    NPC webers = factory.npcs.get("Webers");
    NPC  kritan = factory.npcs.get("Kritan");
    NPC tango = factory.npcs.get("Tango");
    NPC ekak1 = factory.npcs.get("Ekak1");
    NPC ekak2 = factory.npcs.get("Ekak2");
    NPC bieber = factory.npcs.get("Bieber");
    NPC kvalle = factory.npcs.get("Kvalle");
    NPC dnollk = factory.npcs.get("DNollK");

  */


    public NPCModel() throws SlickException {
        npcView = new NPCView();
        factory = new NPCFactory();

        NPCs = new ArrayList<>();

        webers = factory.npcs.get("Webers");
        kritan = factory.npcs.get("Kritan");
        tango = factory.npcs.get("Tango");
        ekak1 = factory.npcs.get("Ekak1");
        ekak2 = factory.npcs.get("Ekak2");
        bieber = factory.npcs.get("Bieber");
        kvalle = factory.npcs.get("Kvalle");
        dnollk = factory.npcs.get("DNollK");



    }

    /**
     *
     */

    //TODO: Make this prettier, inte speciellt OCP
    public void initList() {
        NPCs.add(webers);
        NPCs.add(kritan);
        NPCs.add(tango);
        NPCs.add(ekak1);
        NPCs.add(ekak2);
        NPCs.add(bieber);
        NPCs.add(kvalle);
        NPCs.add(dnollk);
}

    /**
     * Displays the NPCs on the map that they belong to.
     * @param mapModel
     */
    public void showNPC(MapModel mapModel) {
        NPCs.forEach(npc -> {
            if (npc.getCurrent().equals(mapModel.getCurrentMap())) {
                npc.setShowing(true);
            }
                if ((npc.getCurrent() != mapModel.getCurrentMap())) {
                npc.setShowing(false);
            }
        });

    }
}