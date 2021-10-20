package NPC;
import model.MapModel;
import model.MapStates.*;
import org.newdawn.slick.SlickException;
import java.util.Hashtable;


public class NPCFactory {

    /**
     * @author Julia
     */



    public NPCFactory() throws SlickException{
    }

    /**
     * Adds every key-value-combination to the HashTable
     * @throws SlickException Generic exception
     */

    public ConcreteNPC createWebers() throws SlickException {
        return new ConcreteNPC(Karhuset.KARHUSET, 64, 64, 128,
                0, 700, 255, "data/NPC/webers64x64.png",
                "data/NPC/webersTASK128x128_NOBLINK.png", true);
    }

    public ConcreteNPC createDNollK() throws SlickException {
        return new ConcreteNPC(DeltaP.DELTAP, 64, 64, 128,
                0, 700, 255, "data/NPC/dnollk64x64.png",
                "data/NPC/dnollk128x128TASK.png", true);
    }

    public ConcreteNPC createEKAK1() throws SlickException {
        return new ConcreteNPC(Ekak.EKAK, 64, 64, 128,
                1, 700, 255, "data/NPC/ekak64x72.png",
                "data/NPC/ekak64x72.png", true);
    }

    public ConcreteNPC createEKAK2() throws SlickException {
        return new ConcreteNPC(Ekak.EKAK, 64, 64, 128,
                0, 700, 255, "data/NPC/ekak64x72.png",
                "data/NPC/ekak_TASK_128x115.png", true);
    }

    public ConcreteNPC createKritan() throws SlickException {
        return new ConcreteNPC(Chalmersplatsen.CHALMERSPLATSEN, 64, 64, 128,
                1, 700, 255, "data/NPC/webers64x64.png",
                "data/NPC/webersTASK128x128_NOBLINK.png", true);
    }

    public ConcreteNPC createKvalle() throws SlickException {
        return new ConcreteNPC(Markena.MARKENA, 64, 64, 128,
                1, 700, 255, "data/NPC/kvalle64x64.png",
                "data/NPC/kvalle64x64.png", true);
    }

    public ConcreteNPC createBieber() throws SlickException {
        return new ConcreteNPC(Markena.MARKENA, 64, 90, 128,
                1, 700, 255, "data/NPC/Bieber64x90.png",
                "data/NPC/webersTASK128x128_NOBLINK.png", true);
    }

    public ConcreteNPC createTango() throws SlickException {
        return new ConcreteNPC(Chalmersplatsen.CHALMERSPLATSEN, 64, 64, 128,
                1, 700, 255, "data/NPC/tangoPRIT64x64.png",
                "data/NPC/tangoPRIT64x64.png", true);
    }





    }




