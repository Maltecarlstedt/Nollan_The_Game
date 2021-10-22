package Items;

import junit.framework.TestCase;
import model.PlayerModel;
import org.junit.Before;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ItemsTest extends TestCase {
    private ItemModel im = new ItemModel();

    public void testGetUnfilledItems(){
        assertFalse(im.getItemsToFind().isEmpty());
        assertEquals(6, im.getItemsUf().size());
    }

    public void testGetItemsToFind(){
        assertFalse(im.getItemsToFind().isEmpty());
        assertEquals(6, im.getItemsToFind().size());
    }

    public void testItemsCollected(){
        assertFalse(im.itemsCollected());
        im.getItemsToFind().clear();
        assertTrue(im.itemsCollected());
    }

}