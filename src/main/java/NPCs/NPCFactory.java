package NPCs;

import NPCs.EKAK1;
import NPCs.EKAK2;
import org.newdawn.slick.SlickException;

public class NPCFactory {

    //public NPC npc = new NPC();


    //TODO: Loopa lista ist för lång if-sats
    public NPC getNPC(String NPCType) throws SlickException {
        if(NPCType == null){
            return null;
        }
        if(NPCType.equals("Webers")){
            return new Webers();
        }
        if(NPCType.equals("Kritan")){
            return new Kritan();
        }
        if(NPCType.equals("Tango")) {
            return new Tango();
        }
        if(NPCType.equals("Ekak1")) {
            return new EKAK1();
        }
        if(NPCType.equals("Ekak2")) {
            return new EKAK2();
        }


        return null;
    }

}


