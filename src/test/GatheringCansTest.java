import Tasks.Highscores;
import Tasks.taskModel.GatheringCansModel;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

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

}
