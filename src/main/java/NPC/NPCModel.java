package NPC;
import model.MapModel;
import java.util.ArrayList;

    /**
     * @author Julia Böckert
     * Creates a list of NPCs and checks if they should be drawn
     * Uses NPCFactory, ConcreteNPC, MapModel
     * Used by MainGame
     */

public class NPCModel {
        NPCFactory factory;
        public ArrayList<ConcreteNPC> NPCs;

        ConcreteNPC webers;
        ConcreteNPC kritan;
        ConcreteNPC tango;
        ConcreteNPC ekak1;
        ConcreteNPC ekak2;
        ConcreteNPC bieber;
        ConcreteNPC kvalle;
        ConcreteNPC dnollk;


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

        /**
         * Initializes the list of NPCs
         */

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
         * @param mp A MapModel
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
