package TextBoxes;

import model.MapStates.MapState;
import org.newdawn.slick.Image;
import java.awt.*;

/**
 * @author Julia Böckert
 * Contains instantiation logic for a TextBox
 * Used by TextBoxFactory, TextBoxController, TextBoxView, TextBoxModel
 * Uses MapState
 */


    public class TextBox {

        Point location;
        MapState mapState;
        Image backgroundBox;
        String textBoxFile;
        boolean isShowing;

        int width;
        int height;

        public TextBox(MapState mapState, String textBoxFile, int x, int y, boolean isShowing, int width, int height){
            this.textBoxFile = textBoxFile;
            this.location = new Point(x, y);
            this.isShowing = isShowing;
            this.mapState = mapState;
            this.width = width;
            this.height = height;
        }
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

    /**
     * Sets the visibility for the textbox
     * @param isItShowing boolean for false or true regarding if the NPC is to be shown or not
     */
        void setShowing(boolean isItShowing){
            isShowing = isItShowing;
        }
    }

