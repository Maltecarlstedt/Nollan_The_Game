package Tasks.taskView;

import Tasks.taskModel.BeerChuggingModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class BeerChuggingView {


    public void render(GameContainer gc, Graphics g, BeerChuggingModel chugModel){
        g.drawImage(chugModel.inidcatorImage, chugModel.getIndicatorLocation().x, chugModel.getIndicatorLocation().y);
        g.drawImage(chugModel.greenThingy, chugModel.getGreenThingyLocation().x, chugModel.getGreenThingyLocation().y);


        //TODO: Ingen logik här pls.
        if (chugModel.inside){
            chugModel.jumpingBeer.drawFlash(chugModel.getJumpingBeerLocationX(), chugModel.getJumpingBeerLocationY());
        }else{
            g.drawImage(chugModel.jumpingBeer, chugModel.getJumpingBeerLocationX(), chugModel.getJumpingBeerLocationY());
        }

        g.drawImage(chugModel.currentChugAnimation, 1024/2, 720/2);
        g.setFont(chugModel.trueTypePixelFont);
        g.drawImage(chugModel.timerBox,820, 40 );
        // TODO: Fixa så att den alltid är centrerad.
        g.drawString(String.valueOf(chugModel.timePassed), 835,55);



    }

    public void renderFlash(BeerChuggingModel chugModel){
        chugModel.jumpingBeer.drawFlash(chugModel.getJumpingBeerLocationX(), chugModel.getJumpingBeerLocationY());

    }
}
