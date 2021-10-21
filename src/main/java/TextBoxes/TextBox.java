package TextBoxes;

import model.MapStates.MapState;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

/**
 * @author Julia
 */


    public class TextBox {

        Point location;
        MapState mapState;
        Animation textAnim;
        SpriteSheet backgroundBox;
        String textBoxFile;
        boolean isShowing;

        int width;
        int height;

        public TextBox(MapState mapState, String textBoxFile, int x, int y, boolean isShowing, int width, int height) throws SlickException {
            this.textBoxFile = textBoxFile;
            this.location = new Point(x, y);
            this.isShowing = isShowing;
            this.mapState = mapState;
            this.width = width;
            this.height = height;
            textAnim = new Animation();


        }

        /*void SpriteSetup () throws SlickException {
            textAnim = new Animation();
            backgroundBox = new SpriteSheet(textBoxFile, width, height);
            textAnim.addFrame(backgroundBox.getSubImage(0, 0), 1);

        }

         */

        /**
         * Gets the current map so that the correlated TextBox can be drawn.
         * @return current MapState
         */
        MapState getCurrent(){
            return mapState;

        }

        /**
         * Gets the location of the textBox
         * @return x and y of the textBox
         */
        Point getLocation(){
            return location;
        }

        void setShowing(boolean isItShowing){
            isShowing = isItShowing;

        }
    }

