
import Items.ItemModel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.SlickException;

import static org.junit.Assert.*;

public class ItemsTest extends TestCase {
    private ItemModel im;

    @Before
    public void ItemModel() throws SlickException {
        im = new ItemModel();
    }

    public void testConstructor(){

    }

}