package NPC;
import model.MapModel;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * @author Julia
 */

public class NPCModel {


    NPCFactory factory; // = new NPCFactory();
    NPCView npcView;
   // public Hashtable<String, ConcreteNPC> npcs;
    //public ArrayList<NPC> NPCs; // = new ArrayList<>();
    //public ArrayList<TaskHoldingNPC> taskHoldingNPCs;

    public ArrayList<ConcreteNPC> NPCs;


    ConcreteNPC webers;
    ConcreteNPC kritan;
    ConcreteNPC tango;
    ConcreteNPC ekak1;
    ConcreteNPC ekak2;
    ConcreteNPC bieber;
    ConcreteNPC kvalle;
    ConcreteNPC dnollk;


    public NPCModel() throws SlickException {
        npcView = new NPCView();
        factory = new NPCFactory();
        //npcs = new Hashtable<>();
        NPCs = new ArrayList<>();

        //taskHoldingNPCs = new ArrayList<>();

        webers = factory.createWebers();
        kritan = factory.createKritan();
        tango = factory.createTango();
        ekak1 = factory.createEKAK1();
        ekak2 = factory.createEKAK2();
        bieber = factory.createBieber();
        kvalle = factory.createKvalle();
        dnollk = factory.createDNollK();




    }


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
     *
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

    /*public void initHashTable() throws SlickException {
        npcs.put("Webers", factory.createWebers());
        npcs.put("Kritan", factory.createKritan());
        npcs.put("Tango", factory.createTango());
        npcs.put("Ekak1", factory.createEKAK1());
        npcs.put("Ekak2", factory.createEKAK2());
        npcs.put("Kvalle", factory.createKvalle());
        npcs.put("Bieber", factory.createBieber());
        npcs.put("DNollK", factory.createDNollK());

     */


    }

    /*public void taskStateChanged(MapModel mapModel) {
        for (NPC npc : NPCs) {
            if (!mapModel.taskDone) {
                npc.state = 0;
            } else {
                npc.state = 1;
            }

     */








