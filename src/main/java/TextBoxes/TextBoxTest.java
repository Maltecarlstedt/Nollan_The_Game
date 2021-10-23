package TextBoxes;

import TextBoxes.TextBox;
import TextBoxes.TextBoxFactory;
import TextBoxes.TextBoxModel;
import model.MapStates.Karhuset;
import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.SlickException;

import static org.junit.Assert.*;

public class TextBoxTest {

    //saknas: test med showTextBox som kräver en mapmodel

    TextBoxModel model;
    TextBoxFactory factory;
    TextBox textbox;

    @Before
    public void init() throws SlickException {
        model = new TextBoxModel();
        factory = new TextBoxFactory();
        textbox = new TextBox(Karhuset.INSTANCE,"data/Text-related/datatext.png", 90, 200, true, 400, 106 );

    }

    @Test
    public void matchingLocation() throws SlickException {
        assertEquals(factory.createDeltaTextBox().getLocation().x, textbox.getLocation().x, 0.0);
    }

    @Test
    public void testCurrent() throws SlickException {
        assertSame(textbox.getCurrent(), factory.createKarhusetTextBox().getCurrent());
    }

    @Test
    public void isShowingTest(){
        textbox.setShowing(true);
        assertTrue(textbox.isShowing);

    }
}
