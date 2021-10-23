package Tasks.taskView;

import Tasks.taskModel.BeerChuggingModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class BeerChuggingView {

    /**
     * Draws everything to the canvas
     * @param g The grapchics context to be used for rendering
     * @param bcm The model where we collect what is to be drawn.
     */
    public void render(Graphics g, BeerChuggingModel bcm){

        bcm.getBackground().render(0,0);

       if(bcm.isTaskRunning){
            // Renders the brown bar
            g.drawImage(bcm.inidcatorImage, bcm.getIndicatorLocation().x, bcm.getIndicatorLocation().y);
            // Renders the green indicator.
            g.drawImage(bcm.greenThingy, bcm.getGreenThingyLocation().x, bcm.getGreenThingyLocation().y);

           //TODO: Make a method so that we do NOT have logic inside our render method.
           if (bcm.inside){
               // Draw a flash variant of the image to indicate that the jumping beer is inside.
               bcm.jumpingBeer.drawFlash(bcm.getJumpingBeerLocationX(), bcm.getJumpingBeerLocationY());
           }else{
               // Renders the regular beer if it's not inside.
               g.drawImage(bcm.jumpingBeer, bcm.getJumpingBeerLocationX(), bcm.getJumpingBeerLocationY());
           }
        }

        // Draw the player chugging beer.
        g.drawImage(bcm.currentChugAnimation, 1024/2, 720/2);
        // Set our custom font
        g.setFont(bcm.trueTypePixelFont);
        // Render our box that will have the timer inside of it.
        g.drawImage(bcm.timerBox,820, 40 );

        g.drawImage(bcm.highScoreBox, 820, 110);

        // TODO: Make a method so that the string is always centered.
        // Render the timer.
        g.drawString(String.valueOf(bcm.timePassed), 835,55);

        for(int i = 0; i < bcm.beerChuggingHighScore.size(); i++){
            g.drawString(String.valueOf(bcm.beerChuggingHighScore.get(i)), 835, 120 + i*35 );
        }
        if(bcm.isTaskFinished){
            g.drawString("Bra supit bajsnolla, Din tid blev " + bcm.timePassed, 200, 768/2);
            g.drawString("Tryck på 'f' för att fortsätta ", 200, 600);
        }
    }
}
