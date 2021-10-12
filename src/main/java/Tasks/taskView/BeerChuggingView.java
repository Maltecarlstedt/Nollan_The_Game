package Tasks.taskView;

import Tasks.taskModel.BeerChuggingModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class BeerChuggingView {

    /**
     * Draws everything to the canvas
     * @param gc The container that have the game
     * @param g The grapchics context to be used for rendering
     * @param chugModel The model where we collect what is to be drawn.
     */
    public void render(GameContainer gc, Graphics g, BeerChuggingModel chugModel){

        chugModel.getBackground().render(0,0);

        // Renders the brown bar
        g.drawImage(chugModel.inidcatorImage, chugModel.getIndicatorLocation().x, chugModel.getIndicatorLocation().y);
        // Renders the green indicator.
        g.drawImage(chugModel.greenThingy, chugModel.getGreenThingyLocation().x, chugModel.getGreenThingyLocation().y);


        //TODO: Make a method so that we do NOT have logic inside our render method.
        if (chugModel.inside){
            // Draw a flash variant of the image to indicate that the jumping beer is inside.
            chugModel.jumpingBeer.drawFlash(chugModel.getJumpingBeerLocationX(), chugModel.getJumpingBeerLocationY());
        }else{
            // Renders the regular beer if it's not inside.
            g.drawImage(chugModel.jumpingBeer, chugModel.getJumpingBeerLocationX(), chugModel.getJumpingBeerLocationY());
        }
        // Draw the player chugging beer.
        g.drawImage(chugModel.currentChugAnimation, 1024/2, 720/2);
        // Set our custom font
        g.setFont(chugModel.trueTypePixelFont);
        // Render our box that will have the timer inside of it.
        g.drawImage(chugModel.timerBox,820, 40 );
        g.drawImage(chugModel.highScoreBox, 820, 110);

        // TODO: Make a method so that the string is always centered.
        // Render the timer.
        g.drawString(String.valueOf(chugModel.timePassed), 835,55);

        for(int i = 0; i < chugModel.beerChuggingHighScore.size(); i++){
            g.drawString(String.valueOf(chugModel.beerChuggingHighScore.get(i)), 835, 120 + i*35 );
        }
        if(chugModel.isTaskFinished){
            g.drawString("Bra supit bajsnolla, Din tid blev " + chugModel.timePassed, 200, 768/2);
            g.drawString("Tryck på 'f' för att fortsätta ", 200, 600);
        }

    }
}
