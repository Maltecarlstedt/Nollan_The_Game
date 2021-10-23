import model.CollisionChecker;
import model.PlayerModel;
import org.junit.Before;
import org.junit.Test;

public class CollisionCheckerTest {
    PlayerModel testPlayer;
    CollisionChecker testCollisionChecker;

    @Before
    public void init(){
        testPlayer = new PlayerModel();
        testCollisionChecker = new CollisionChecker();

    }

    @Test
    public void testNextMoveIsCollision(){

    }



}
