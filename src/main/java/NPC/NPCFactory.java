package NPC;
import model.MapModel;
import model.MapStates.*;
import org.newdawn.slick.SlickException;
import java.util.Hashtable;

/**
 * @author Julia Böckert
 */
public class NPCFactory {

    public NPCFactory() {
    }

    /**
     * Adds every key-value-combination to the HashTable
     * @throws SlickException Generic exception
     */

    public ConcreteNPC createWebers() {
        return new ConcreteNPC(Karhuset.KARHUSET, 64, 64, 128,
                0, 710, 205, "data/compressedNPCs/webers64x64-min.png",
                "data/compressedNPCs/webersTASK128x128SOMINTEBLINKAR-min.png", true);
    }

    public ConcreteNPC createDNollK() {
        return new ConcreteNPC(DeltaP.DELTAP, 64, 64, 128,
                0, 200, 250, "data/compressedNPCs/dnollk64x64-min.png",
                "data/compressedNPCs/dnollk128x128TASK (1)-min.png", true);
    }

    public ConcreteNPC createEKAK1()  {
        return new ConcreteNPC(Ekak.EKAK, 64, 72, 128,
                1, 460, 160, "data/compressedNPCs/ekak64x72-min.png",
                "data/compressedNPCs/ekak64x72-min.png", true);
    }

    public ConcreteNPC createEKAK2(){
        return new ConcreteNPC(Ekak.EKAK, 64, 64, 128,
                0, 400, 120, "data/compressedNPCs/ekak64x72-min.png",
                "data/compressedNPCs/ekak_TASK_128x115-min.png", true);
    }

    public ConcreteNPC createKritan()  {
        return new ConcreteNPC(Chalmersplatsen.CHALMERSPLATSEN, 64, 64, 128,
                1, 600, 210, "data/compressedNPCs/kritanPRIT64x64-min.png",
                "data/compressedNPCs/kritanPRIT64x64-min.png", true);
    }

    public ConcreteNPC createKvalle()  {
        return new ConcreteNPC(Markena.MARKENA, 64, 64, 128,
                1, 600, 220, "data/compressedNPCs/kvalle64x64-min.png",
                "data/compressedNPCs/kvalle64x64-min.png", true);
    }

    public ConcreteNPC createBieber() {
        return new ConcreteNPC(Markena.MARKENA, 64, 90, 128,
                1, 530, 200, "data/compressedNPCs/Bieber64x90-min.png",
                "data/compressedNPCs/Bieber64x90-min.png", true);
    }

    public ConcreteNPC createTango() {
        return new ConcreteNPC(Chalmersplatsen.CHALMERSPLATSEN, 64, 64, 128,
                1, 530, 210, "data/compressedNPCs/tangoPRIT64x64-min.png",
                "data/compressedNPCs/tangoPRIT64x64-min.png", true);
    }





    }




