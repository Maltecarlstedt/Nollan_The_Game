import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

import static org.junit.Assert.*;

public class testPlayer {
    Player testPlayer;


    @Before
    public void init() throws SlickException {
        testPlayer = new Player();
        //testPlayer.initPlayer();
    }

    @Test
    public void testMoveUp(){
        int startX = testPlayer.getLocation().x;
        int startY = testPlayer.getLocation().y;

        testPlayer.moveUp();
        assertTrue(testPlayer.getLocation().y < startY);
        assertEquals(testPlayer.getLocation().x, startX);
    }

    @Test
    public void testMoveLeft(){
        int startX = testPlayer.getLocation().x;
        int startY = testPlayer.getLocation().y;

        testPlayer.moveLeft();
        assertTrue(testPlayer.getLocation().x < startX);
        assertEquals(testPlayer.getLocation().y, startY);
    }

    @Test
    public void testMoveRight(){
        int startX = testPlayer.getLocation().x;
        int startY = testPlayer.getLocation().y;

        testPlayer.moveRight();
        assertTrue(testPlayer.getLocation().x > startX);
        assertEquals(testPlayer.getLocation().y, startY);
    }

    @Test
    public void testMoveDown(){
        int startX = testPlayer.getLocation().x;
        int startY = testPlayer.getLocation().y;

        testPlayer.moveDown();
        assertTrue(testPlayer.getLocation().y > startY);
        assertEquals(testPlayer.getLocation().x, startX);
    }

    /*@Test
    public void testIdlePlayer() throws SlickException {
        testPlayer.spriteSetup();
        SpriteSheet testSprite = testPlayer.MoveLeft;
        Image testImage = testSprite.getSubImage(0,0);

        for(int i = 0; i < 25; i++){
            testPlayer.moveLeft();
        }
        testPlayer.setOrientation(Orientation.IDLE);
        assertEquals(testImage, testPlayer.currentImage);
    }*/

}
