package NPC;
import model.MapStates.*;

/**
 * @author Julia Böckert
 * Initializes NPC instances
 * Used by NPCModel
 * Uses ConcreteNPC
 */
public class NPCFactory {

    public NPCFactory() {
    }

    /**
     * Creates an NPC-instance
     */

    public ConcreteNPC createWebers() {
        return new ConcreteNPC(Karhuset.INSTANCE, 64, 64, 128,
                0, 710, 205, "data/NPC/webers64x64.png",
                "data/NPC/webersTASK128x128_NOBLINK.png", true);
    }

    public ConcreteNPC createDNollK() {
        return new ConcreteNPC(DeltaP.INSTANCE, 64, 64, 128,
                0, 200, 250, "data/NPC/dnollk64x64.png",
                "data/NPC/dnollk128x128TASK.png", true);
    }

    public ConcreteNPC createEKAK1()  {
        return new ConcreteNPC(Ekak.INSTANCE, 64, 72, 128,
                1, 460, 160, "data/NPC/ekak64x72.png",
                "data/NPC/ekak64x72.png", true);
    }

    public ConcreteNPC createEKAK2(){
        return new ConcreteNPC(Ekak.INSTANCE, 64, 64, 128,
                0, 400, 120, "data/NPC/ekak64x72.png",
                "data/NPC/ekak_TASK_128x115.png", true);
    }

    public ConcreteNPC createKritan()  {
        return new ConcreteNPC(Chalmersplatsen.INSTANCE, 64, 64, 128,
                1, 600, 210, "data/NPC/kritanPRIT64x64.png",
                "data/NPC/kritanPRIT64x64.png", true);
    }

    public ConcreteNPC createKvalle()  {
        return new ConcreteNPC(Markena.INSTANCE, 64, 64, 128,
                1, 600, 220, "data/NPC/kvalle64x64.png",
                "data/NPC/kvalle64x64.png", true);
    }

    public ConcreteNPC createBieber() {
        return new ConcreteNPC(Markena.INSTANCE, 64, 90, 128,
                1, 530, 200, "data/NPC/Bieber64x90.png",
                "data/NPC/Bieber64x90.png", true);
    }

    public ConcreteNPC createTango() {
        return new ConcreteNPC(Chalmersplatsen.INSTANCE, 64, 64, 128,
                1, 530, 210, "data/NPC/tangoPRIT64x64.png",
                "data/NPC/tangoPRIT64x64.png", true);
    }

    }




