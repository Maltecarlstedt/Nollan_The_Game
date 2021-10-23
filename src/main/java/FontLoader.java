import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.*;
import java.io.InputStream;

public class FontLoader {
    public TrueTypeFont trueTypePixelFont;

    /**
     * Function for fetching and loading a custom pixel font for the game Supposed to give more 8bit feeling.
     *  However, not implemented yet
     */
    public void fontLoader(){
        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("/data/fonts/slkscr.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            font = font.deriveFont(32f); // set font size
            trueTypePixelFont = new TrueTypeFont(font, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
