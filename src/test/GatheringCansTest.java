import Tasks.Highscores;
import Tasks.taskModel.GatheringCansModel;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;


public class GatheringCansTest extends TestCase {

    @Test
    public void testGetScore() {
        GatheringCansModel testScore = new GatheringCansModel();
        testScore.increaseScore();
        Assert.assertEquals(1,testScore.getScore());
        Assert.assertTrue(testScore.getScore() == 1);
    }

    @Test
    public void testAddCan() {
        GatheringCansModel testCan = new GatheringCansModel();

        testCan.addCan();
        testCan.addCan();
        testCan.addCan();

        Assert.assertEquals(3,testCan.getCans().size());
    }

    @Test
    public void testAddResetHighscore() {
        GatheringCansModel testCan = new GatheringCansModel();

        testCan.increaseScore();
        testCan.increaseScore();

        testCan.resetScore();

        testCan.increaseScore();
        testCan.increaseScore();
        testCan.increaseScore();

        Assert.assertEquals(3,testCan.getScore());
    }

    @Test
    public void testArrayHighscore() {
        GatheringCansModel testCan = new GatheringCansModel();

        testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();
        testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();
        testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();
        testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();
        testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();
        testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();testCan.increaseScore();

        testCan.addHighScore();
        Assert.assertTrue(testCan.getCanHighscore().get(2) == 42);
    }

    @Test
    public void testTimer() {
        GatheringCansModel testCan = new GatheringCansModel();

        double test = testCan.getTaskTimer();

        testCan.outOfTime();

        testCan.resetTimer();
        testCan.canReceived();
        testCan.canReceived();
        testCan.canReceived();
        testCan.canReceived();

        testCan.timerUpdate(2);

        Assert.assertTrue(testCan.getTaskTimer() > test);
    }

    // förväntat fel, catches it.
    @Test (expected = IOException.class)
    public void testCatchHighscore() {
        GatheringCansModel test = new GatheringCansModel();
        try {
            Field privateHighscoreField = GatheringCansModel.class.getDeclaredField("hs");
            privateHighscoreField.setAccessible(true);
            // skapar filepath som inte finns aka tom.
            privateHighscoreField.set(test, new Highscores(""));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        test.addHighScore();



    }

}
