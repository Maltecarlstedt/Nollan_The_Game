package Items;

import Items.Filled.Cardboard;
import Items.Filled.Karkort;
import Items.Filled.Scissor;
import Items.Unfilled.CardboardUf;
import Items.Unfilled.KarkortUf;
import junit.framework.TestCase;
import model.MapStates.Karhuset;
import model.PlayerModel;
import org.junit.Before;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Objects;

public class ItemsTest extends TestCase {
    private final ItemModel im = new ItemModel();

    public void testGetUnfilledItems(){
        Item cardboardUf = new CardboardUf();
        assertFalse(im.getItemsToFind().isEmpty());
        assertEquals(6, im.getItemsUf().size());
        Item item = im.getItemsUf().get("CardboardUf");
        assertEquals(item.filePathToItem, cardboardUf.filePathToItem);

    }

    public void testGetItemsToFind(){
        Item scissor = new Scissor();
        assertFalse(im.getItemsToFind().isEmpty());
        assertEquals(6, im.getItemsToFind().size());
        Item item = im.getItemsToFind().get("Scissor");
        assertEquals(item.location.x, scissor.location.x);
    }

    public void testItemsCollected(){
        assertFalse(im.itemsCollected());
        im.getItemsToFind().clear();
        assertTrue(im.itemsCollected());
    }

    public void testDeleteFoundItem(){
        PlayerModel pm = new PlayerModel();
        ItemView iv = new ItemView();
        Item karkort = new Karkort();
        iv.currentMap = karkort.getCurrentMap();
        pm.setNewPlayerTile(karkort.location.x,karkort.location.y);

        assertEquals(6, im.getItemsToFind().size());
        im.deleteFoundItem(pm, iv);
        assertEquals(5, im.getItemsToFind().size());
        Item item = im.getItemsUf().get("KarkortUf");
        assertEquals(item.filePathToItem, karkort.filePathToItem);
    }

}