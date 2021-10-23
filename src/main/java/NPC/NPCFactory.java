package NPC;
import org.newdawn.slick.SlickException;
import java.util.Hashtable;


public class NPCFactory {

    public Hashtable<String, NPC> npcs;

    public NPCFactory() throws SlickException{
        npcs = new Hashtable<>();
        initHashTable();
    }

    /**
     * Adds every key-value-combination to the HashTable
     * @throws SlickException Generic exception
     */

    public void initHashTable() throws SlickException {
        npcs.put("Webers", new Webers());
        npcs.put("Kritan", new Kritan());
        npcs.put("Tango", new Tango());
        npcs.put("Ekak1", new EKAK1());
        npcs.put("Ekak2", new EKAK2());
        npcs.put("Kvalle", new Kvalle());
        npcs.put("Bieber", new Bieber());
        npcs.put("DNollK", new DNollK());

    }

}


