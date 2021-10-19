
import Items.ItemModel;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import java.awt.*;

import static org.junit.Assert.*;

public class testItems {
    ItemModel im;
    @Before
    public void ItemModel() throws SlickException {
        im = new ItemModel();
    }

    @Test
    public void testConstructor(){
        assertEquals(6, im.getItemsToFind().size());
    }

}
