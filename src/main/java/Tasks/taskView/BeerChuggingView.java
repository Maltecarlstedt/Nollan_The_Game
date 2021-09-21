package Tasks.taskView;

import Tasks.taskModel.BeerChuggingModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class BeerChuggingView {



    public void render(GameContainer gc, Graphics g, BeerChuggingModel chugModel){

        g.drawImage(chugModel.scaledInidcatorImage, chugModel.getLocation().x, chugModel.getLocation().y);



    }
}
