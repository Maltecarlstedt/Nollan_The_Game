import model.CollisionChecker;
import model.MapModel;
import model.MapStates.Ekak;
import model.MapStates.Karhuset;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import static org.junit.Assert.*;

public class testMap {
    MapModel mapModel;

    CollisionChecker collisionChecker;

    @Before
    public void init() throws SlickException {
        collisionChecker = new CollisionChecker();
        mapModel = new MapModel(collisionChecker);
    }

/*
    @Test
    public void testSetMap(){
        assertEquals(mapModel.getCurrentMap(), Karhuset.KARHUSET);
    }

 */




}
