package NPCs;

import NPCs.EKAK1;
import NPCs.EKAK2;
import org.newdawn.slick.SlickException;

public class NPCFactory {

    //TODO: Loop a list instead of long if

    /**
     * Returns the Npc that is wanted
     * @param NPCType The different npc-objects
     * @return The npc-object requested
     * @throws SlickException Generic exception
     */
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
        if(NPCType.equals("Kvalle")) {
            return new Kvalle();
        }
        if(NPCType.equals("Bieber")) {
            return new Bieber();
        }
        if(NPCType.equals("DNollK")) {
            return new DNollK();
        }
        return null;
    }

}


