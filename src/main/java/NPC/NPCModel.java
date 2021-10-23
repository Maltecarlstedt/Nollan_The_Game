package NPC;
import model.MapModel;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.Hashtable;

    /**
     * @author Julia Böckert
     */

public class NPCModel {


        NPCFactory factory;

        public ArrayList<ConcreteNPC> NPCs;


        ConcreteNPC webers; //factory.createWebers();
        ConcreteNPC kritan; // factory.createKritan();
        ConcreteNPC tango; //factory.createTango();
        ConcreteNPC ekak1; //factory.createEKAK1();
        ConcreteNPC ekak2; //factory.createEKAK2();
        ConcreteNPC bieber; //factory.createBieber();
        ConcreteNPC kvalle;//factory.createKvalle();
        ConcreteNPC dnollk; //factory.createDNollK();


        public NPCModel() {
            factory = new NPCFactory();
            NPCs = new ArrayList<>();

            webers = factory.createWebers();
            kritan = factory.createKritan();
            tango = factory.createTango();
            ekak1 = factory.createEKAK1();
            ekak2 = factory.createEKAK2();
            bieber = factory.createBieber();
            kvalle = factory.createKvalle();
            dnollk = factory.createDNollK();

            initList();
        }

        //TODO: Make this prettier, inte speciellt OCP
        private void initList() {

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
         * @param mp
         */
        void showNPC(MapModel mp) {
            NPCs.forEach(npc -> {
                if (npc.getCurrent().equals(mp.getCurrentMap())) {
                    npc.setShowing(true);
                }
                if (npc.getCurrent() != mp.getCurrentMap()) {
                    npc.setShowing(false);
                }
            });

        }
    }
