
import junit.framework.TestCase;
import model.CollisionChecker;
import model.MapModel;
import model.MapStates.Karhuset;
import model.MapStates.Markena;
import model.Orientation;
import model.PlayerModel;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.SlickException;

public class MapTest extends TestCase {
    PlayerModel playerModel = new PlayerModel();

    CollisionChecker collisionChecker = new CollisionChecker();
    MapModel mapModel = new MapModel(collisionChecker);

    /*
    @Before
    public void init(){
        collisionChecker = new CollisionChecker();
        mapModel = new MapModel(collisionChecker);
        playerModel = new PlayerModel();
    }

     */

    public void testGetCurrentMap(){
        assertEquals(mapModel.getCurrentMap(), Karhuset.INSTANCE);
    }

    /*
    public void testChangeMap(){
        mapModel.setCurrentMap(Karhuset.INSTANCE);
        playerModel.setOrientation(Orientation.LEFT);
        mapModel.changeMap(playerModel);
        assertSame(mapModel.getCurrentMap(), Markena.INSTANCE);
    }

     */



}
