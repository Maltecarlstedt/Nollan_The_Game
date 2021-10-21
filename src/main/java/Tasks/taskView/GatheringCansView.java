package Tasks.taskView;

import Tasks.taskModel.GatheringCansModel;
import Tasks.taskModel.Cans;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/** The view of Gathering Cans
 * @author Steffanie Kristiansson
 * @author Alexander Brunnegård
 */
public class GatheringCansView {

    /** Method to draw each can.
     * @param g represents the graphics context to be used for rendering.
     * @param gcm representing the model to get data from it.
     */
    public void render (Graphics g, GatheringCansModel gcm) {
        gcm.getBackground().render(0,0);

        g.drawImage(gcm.timerBox,820, 40);

        g.drawImage(gcm.highScoreBox, 820, 140);

        g.drawString("Your score: ", 820, 20);
        g.drawString("Highscore: ", 820, 120);

        // Render the timer.
        g.drawString(String.valueOf(gcm.getTaskTimer()), 835,55);
        g.drawString(String.valueOf(gcm.getScore()), 835,75);
        for(int i = 0; i < gcm.getCanHighscore().size(); i++){
            int number = gcm.getCanHighscore().get(i).intValue();
            g.drawString(String.valueOf(number), 835, 155 + i*35);
        }

        // the mouse
        if(gcm.isRunning){
            g.setColor(Color.cyan);
            g.fill(gcm.mouseBall);

            g.setColor(Color.white);

            // Render our box that will have the timer inside of it.

        } else{
            g.drawString("Bra plockat!", 400, 400);
            g.drawString("Tryck F för att avsluta uppdraget.", 400, 440);
        }

        for(Cans cans : gcm.getCans()){
            g.drawImage(cans.getImage(), cans.getCanLocation().getX(), cans.getCanLocation().getY());

        }
    }



}
