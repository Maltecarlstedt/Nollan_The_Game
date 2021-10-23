import model.Orientation;
import model.PlayerModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerModelTest {
    PlayerModel testPlayer;

    @Before
    public void init() {
        testPlayer = new PlayerModel();
    }

    @Test
    public void testMoveUp(){
        float startX = (float) testPlayer.getPlayerLocation().getX();
        float startY = (float) testPlayer.getPlayerLocation().getY();

        testPlayer.moveUp();
        assertTrue(testPlayer.getPlayerLocation().getY() < startY);
        assertEquals(testPlayer.getPlayerLocation().getX(), startX, 0.0);
        assertSame(testPlayer.getOrientation(), Orientation.UP);
    }

    @Test
    public void testMoveLeft(){
        int startX = (int)testPlayer.getPlayerLocation().getX();
        int startY = (int)testPlayer.getPlayerLocation().getY();

        testPlayer.moveLeft();
        assertTrue(testPlayer.getPlayerLocation().getX() < startX);
        assertEquals(testPlayer.getPlayerLocation().getY(), startY, 0.0);
        assertSame(testPlayer.getOrientation(), Orientation.LEFT);
    }

    @Test
    public void testMoveRight(){
        int startX = (int)testPlayer.getPlayerLocation().getX();
        int startY = (int)testPlayer.getPlayerLocation().getY();

        testPlayer.moveRight();
        assertTrue(testPlayer.getPlayerLocation().getX() > startX);
        assertEquals(testPlayer.getPlayerLocation().getY(), startY, 0.0);
        assertSame(testPlayer.getOrientation(), Orientation.RIGHT);
    }

    @Test
    public void testMoveDown(){
        float startX = (float) testPlayer.getPlayerLocation().getX();
        float startY = (float) testPlayer.getPlayerLocation().getY();
        testPlayer.setOrientation(Orientation.LEFT);

        testPlayer.moveDown();
        assertTrue(testPlayer.getPlayerLocation().getY() > startY);
        assertEquals(testPlayer.getPlayerLocation().getX(), startX, 0.0);
        assertSame(testPlayer.getOrientation(), Orientation.DOWN);
    }



}