package NPC;

import NPC.*;
import model.CollisionChecker;
import model.MapModel;
import model.MapStates.Karhuset;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
import org.junit.Assert;
import org.newdawn.slick.SlickException;

import static org.junit.Assert.*;

public class NPCTest {

    NPCModel model;
    NPCFactory factory;
    ConcreteNPC npc;
    MapModel mapModel;
    CollisionChecker collisionChecker;

    //funkar inte testa showNPC(); pga MapModel har TiledMap?

    @Before
    public void init() throws SlickException {
        model = new NPCModel();
        factory = new NPCFactory();
        npc = new ConcreteNPC(Karhuset.INSTANCE, 64, 64, 128, 0, 200, 200, "data/compressedNPCs/dnollk64x64-min.png", "data/compressedNPCs/dnollk128x128TASK (1)-min.png", true);
        collisionChecker = new CollisionChecker();
        //mapModel = new MapModel(collisionChecker);
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

}
