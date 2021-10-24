import model.CollisionChecker;
import model.Orientation;
import model.PlayerModel;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.RecursiveAction;

import static org.junit.Assert.*;

public class CollisionCheckerTest {
    PlayerModel testPlayer;
    CollisionChecker testCollisionChecker;
    ArrayList<Rectangle> testCollisionTiles = new ArrayList<>();
    Random r = new Random();

    @Before
    public void init(){
        testPlayer = new PlayerModel();
        testPlayer.setOrientation(Orientation.IDLE);
        testCollisionChecker = new CollisionChecker();
        CollisionChecker.setCollisionTiles(testCollisionTiles);

    }

    @Test
    public void testIsColliding(){
        testCollisionTiles.add(new Rectangle(240, 380, 32, 32));
        testCollisionTiles.add(new Rectangle(300, 55, 32, 32));
        testCollisionTiles.add(new Rectangle(100, 500, 64, 64));

        assertTrue(testCollisionChecker.isColliding(testPlayer));

        testPlayer.setNewPlayerTile(332, 55);
        assertFalse(testCollisionChecker.isColliding(testPlayer));

        testPlayer.setOrientation(Orientation.LEFT);
        assertTrue(testCollisionChecker.isColliding(testPlayer));

    }

    @Test
    public void testIsNextOutside(){
        testPlayer.setNewPlayerTile(0, 704);
        testPlayer.setOrientation(Orientation.LEFT);
        assertTrue(testCollisionChecker.isNextOutside(testPlayer));

        testPlayer.setOrientation(Orientation.RIGHT);
        assertFalse(testCollisionChecker.isNextOutside(testPlayer));

        testPlayer.setOrientation(Orientation.UP);
        assertFalse(testCollisionChecker.isNextOutside(testPlayer));

        testPlayer.setOrientation(Orientation.DOWN);
        assertTrue(testCollisionChecker.isNextOutside(testPlayer));


        testPlayer.setNewPlayerTile(300, 300);

        testPlayer.setOrientation(Orientation.LEFT);
        assertFalse(testCollisionChecker.isNextOutside(testPlayer));

        testPlayer.setOrientation(Orientation.RIGHT);
        assertFalse(testCollisionChecker.isNextOutside(testPlayer));

        testPlayer.setOrientation(Orientation.UP);
        assertFalse(testCollisionChecker.isNextOutside(testPlayer));

        testPlayer.setOrientation(Orientation.DOWN);
        assertFalse(testCollisionChecker.isNextOutside(testPlayer));
    }



}
