package NPC;
import model.MapModel;
import org.newdawn.slick.SlickException;
import java.util.Hashtable;


public class NPCFactory {

    public Hashtable<String, NPC> npcs;

    public NPCFactory(MapModel mp) throws SlickException{
        npcs = new Hashtable<>();
        initHashTable(mp);
    }

    /**
     * Adds every key-value-combination to the HashTable
     * @throws SlickException Generic exception
     */

    public void initHashTable(MapModel mp) throws SlickException {
        npcs.put("Webers", new Webers(mp));
        npcs.put("Kritan", new Kritan());
        npcs.put("Tango", new Tango());
        npcs.put("Ekak1", new EKAK1(mp));
        npcs.put("Ekak2", new EKAK2());
        npcs.put("Kvalle", new Kvalle());
        npcs.put("Bieber", new Bieber());
        npcs.put("DNollK", new DNollK(mp));

    }

}


