import Tasks.GatheringCansTask;
import Tasks.taskController.GatheringCansController;
import Tasks.taskModel.Cans;
import Tasks.taskModel.GatheringCansModel;
import Tasks.taskView.GatheringCansView;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.newdawn.slick.SlickException;

public class TestGatheringCansModel extends TestCase {

    private GatheringCansModel gcm;
    private GatheringCansTask gct;
    private GatheringCansView gcv;
    private GatheringCansController gcc;

    @Before
    public void init() throws SlickException{
        gcm = new GatheringCansModel();
        gct = new GatheringCansTask();
        gcv = new GatheringCansView();
        gcc = new GatheringCansController(gcm);
    }

    @Before
    @Override
    public void setUp() throws Exception{
        gcm.init();
    }

    @Test
    public void testAddCan() throws SlickException {
        GatheringCansModel testCan = new GatheringCansModel();
        testCan.addCan();
        Assert.assertEquals(1,testCan.getCans());
    }


    @Test
    public void testGetScore() throws SlickException {
        GatheringCansModel testScore = new GatheringCansModel();
        testScore.increaseScore();
        Assert.assertEquals(1,testScore.getScore());
        //Assert.assertTrue(testScore.getScore() == 1);
    }






}
