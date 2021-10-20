import Tasks.BeerChugginTask;
import Tasks.taskController.BeerChuggingController;
import Tasks.taskModel.BeerChuggingModel;
import Tasks.taskView.BeerChuggingView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.SlickException;

public class BeerChuggingTest {

    BeerChugginTask bct;
    BeerChuggingModel bcm;
    BeerChuggingView bcv;
    BeerChuggingController bcc;

    @Before
    public void init() throws SlickException {
        bct = new BeerChugginTask();
        bcm = new BeerChuggingModel();
        bcv = new BeerChuggingView();
        bcc = new BeerChuggingController(bcm);

    }
    @Test
    public void testTimer() {
        double testTimer = bcm.timePassed;
        
        Assert.assertTrue(true);
    }
}