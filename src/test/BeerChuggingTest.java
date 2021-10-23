import Tasks.BeerChugginTask;
import Tasks.taskController.BeerChuggingController;
import Tasks.taskModel.BeerChuggingModel;
import Tasks.taskView.BeerChuggingView;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.SlickException;

public class BeerChuggingTest {
    BeerChuggingModel bcm;


    @Before
    public void init(){
        bcm = new BeerChuggingModel();
    }
    @Test
    public void testBeerJump() {
        int startY = bcm.getJumpingBeerLocationY();
        bcm.beerJump();
        int endY = bcm.getJumpingBeerLocationY();
        assertTrue(startY > endY);

    }
}