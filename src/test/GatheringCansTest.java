import Tasks.Highscores;
import Tasks.taskModel.GatheringCansModel;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.lang.reflect.Field;


public class GatheringCansTest extends TestCase {
    GatheringCansModel gcm = new GatheringCansModel();

    @Test
    public void testGetScore() {
        gcm.increaseScore();
        Assert.assertEquals(1,gcm.getScore());
        Assert.assertTrue(gcm.getScore() == 1);
    }

    @Test
    public void testAddCan() {
        gcm.addCan();
        gcm.addCan();
        gcm.addCan();

        Assert.assertEquals(3,gcm.getCans().size());
    }

    @Test
    public void testAddResetHighscore() {
        gcm.increaseScore();
        gcm.increaseScore();

        gcm.resetScore();

        gcm.increaseScore();
        gcm.increaseScore();
        gcm.increaseScore();

        Assert.assertEquals(3,gcm.getScore());
    }

    @Test
    public void testArrayHighscore() {
        for (int i = 0; i < 10000; i++) {
            gcm.increaseScore();
        }
        gcm.addHighScore();
        Assert.assertTrue(gcm.getCanHighscore().get(0) == 10000);
    }

    @Test
    public void testTimer() {
        double test = gcm.getTaskTimer();

        gcm.outOfTime();

        gcm.resetTimer();
        gcm.canReceived();
        gcm.canReceived();
        gcm.canReceived();
        gcm.canReceived();

        gcm.timerUpdate(2);
        System.out.println(test);
        System.out.println(gcm.getTaskTimer());
        Assert.assertTrue(gcm.getTaskTimer() > test);
    }

    // expected exception, catches it.
    @Test (expected = IOException.class)
    public void testCatchHighscore() {
        try {
            Field privateHighscoreField = GatheringCansModel.class.getDeclaredField("hs");
            privateHighscoreField.setAccessible(true);
            // Creates new filepath which is empty.
            privateHighscoreField.set(gcm, new Highscores(""));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        gcm.addHighScore();



    }

}
