import Tasks.taskModel.BeerChuggingModel;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class BeerChuggingTest {
    BeerChuggingModel bcm;


    @Before
    public void init(){
        bcm = new BeerChuggingModel();
    }

    @Test
    public void testReadHighScoreList(){
        bcm.beerChuggingHighScore.clear();
        bcm.readHighScoreList();
        assertFalse(bcm.beerChuggingHighScore.isEmpty());
    }

    @Test
    public void testChugTimer(){
        bcm.chugTimer(1);
        assertNotEquals(0, bcm.timePassed);
    }


    @Test
    public void testLoopGreenIndicatorLocation(){
        int startPos = bcm.getGreenIndicatorLocation().y;
        double startSpeed = bcm.greenIndicatorSpeed;
        bcm.loopGreenIndicatorLocation();
        assertNotEquals(startPos, bcm.getGreenIndicatorLocation().y);
        assertNotEquals(startSpeed, bcm.greenIndicatorSpeed);
        bcm.setGreenIndicatorLocationY(326);
        bcm.loopGreenIndicatorLocation();
        assertFalse(bcm.upDir);
        bcm.setGreenIndicatorLocationY(630);
        bcm.loopGreenIndicatorLocation();
        assertTrue(bcm.upDir);
    }
    
    @Test
    public void testAddHighScore(){
        bcm.beerChuggingHighScore.clear();
        int sizeOfArray = bcm.beerChuggingHighScore.size();
        bcm.timePassed = 10;
        bcm.addHighScore();
        assertNotEquals(sizeOfArray, bcm.beerChuggingHighScore.size());
        assertTrue(bcm.beerChuggingHighScore.contains(10.0));
    }
    @Test
    public void testUpdateChugAnimation(){
        bcm.numberOfChugs = 31;
        bcm.updateChugAnimation();
        assertTrue(bcm.numberOfChugs == 0);
        assertNotEquals(0, bcm.chugIndexAnimation);

    }
    @Test
    public void testCheckIntersect(){
        // Test that .contains works
        int testNumberOfChugsBefore = bcm.numberOfChugs;
        bcm.setJumpingBeerLocationY(100);
        bcm.setGreenIndicatorLocationY(100);
        bcm.checkIntersect();
        int testNumberOfChugsAfter = bcm.numberOfChugs;
        assertTrue(testNumberOfChugsBefore < testNumberOfChugsAfter);
        // Test that intersects also works.
        bcm.setJumpingBeerLocationY(120);
        bcm.checkIntersect();
        int testNumberOfChugsIntersects = bcm.numberOfChugs;
        assertTrue(testNumberOfChugsIntersects > testNumberOfChugsAfter);
        bcm.setJumpingBeerLocationY(200);
        bcm.checkIntersect();
        assertFalse(bcm.beerInside);
    }

    @Test
    public void testBeerJump() {
        int startY = bcm.getJumpingBeerLocationY();
        bcm.beerJump();
        int endY = bcm.getJumpingBeerLocationY();
        assertTrue(startY > endY);

    }

    @Test
    public void testResetBeerChuggingTask(){
        bcm.resetBeerChuggingTask();
        assertEquals(0, bcm.chugIndexAnimation);
        assertEquals(0, bcm.timePassed, 0);
        assertEquals(3, bcm.greenIndicatorSpeed, 0);
        assertTrue(bcm.isTaskRunning);
        assertFalse(bcm.isTaskFinished);

    }
}