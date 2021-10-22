
import junit.framework.TestCase;
import model.CollisionChecker;
import model.MapModel;
import model.MapStates.Karhuset;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.SlickException;

public class MapTest extends TestCase {
    MapModel mapModel;

    CollisionChecker collisionChecker;

    @Before
    public void init(){
        collisionChecker = new CollisionChecker();
        mapModel = new MapModel(collisionChecker);
    }

    public void testGetCurrentMap(){
        assertEquals(mapModel.getCurrentMap(), Karhuset.INSTANCE);
    }

    public void testSetTiledMap(){
    }



}
