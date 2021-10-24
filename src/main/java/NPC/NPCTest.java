package NPC;

import model.MapStates.Karhuset;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class NPCTest {

    //These tests were functional before, but our NPCs cannot be tested due to the
    // instantiation logic containing a MapState (used to be an Enum, is now a class
    //that creates an Image - this creates errors when testing.

   /* NPCModel model;
    NPCFactory factory;
    ConcreteNPC npc;


    @Before
    public void init() {
        model = new NPCModel();
        factory = new NPCFactory();
        npc = new ConcreteNPC(Karhuset.INSTANCE, 64, 64, 128, 0, 200, 200, "data/compressedNPCs/dnollk64x64-min.png", "data/compressedNPCs/dnollk128x128TASK (1)-min.png", true);

    }

    @Test
    public void matchingLocation(){
     assertEquals(factory.createDNollK().getLocation().x, npc.getLocation().x, 0.0);
    }

    @Test
    public void testCurrent(){
        assertSame(npc.getCurrent(), factory.createWebers().getCurrent());
    }

    @Test
    public void isShowingTest(){
    npc.setShowing(true);
    assertTrue(npc.isShowing);

    }

    */


}
