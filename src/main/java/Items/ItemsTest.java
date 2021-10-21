package Items;

import junit.framework.TestCase;
import org.junit.Before;

public class ItemsTest extends TestCase {
    private ItemModel im = new ItemModel();

    public void testGetUnfilledItems(){
        im = new ItemModel();
        assertFalse(im.getItemsToFind().isEmpty());
        assertEquals(6, im.getItemsUf().size());
    }

    public void testGetItemsToFind(){
        im = new ItemModel();
        assertFalse(im.getItemsToFind().isEmpty());
        assertEquals(6, im.getItemsToFind().size());
    }

    public void testItemsCollected(){
        assertFalse(im.itemsCollected());
        im.getItemsToFind().clear();
        assertTrue(im.itemsCollected());
    }

}