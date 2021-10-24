package Items;

import model.PlayerModel;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

/**
     * The class that dictates the update of the items
     * Uses: ItemModel, ItemView, PlayerModel
     * Used by: MainGame
     * @author Clara Simonsson
     */
public class ItemController {
    /** Declarations of all the parameters that will be initiated in the constructor. */
    ItemModel im;
    ItemView iv;
    PlayerModel pm;

        /**
         * The constructor that initiates our item controller.
         * @param im - the item
         * @param iv - our view of the item
         * @param pm - the player
         */
    public ItemController(ItemModel im, ItemView iv, PlayerModel pm) {
        this.im = im;
        this.iv = iv;
        this.pm = pm;
    }

        /**
         * Updates the items placed on the screen depending on which items
         * the player has found or won in the tasks.
         * @param pm - the player
         * @param im - the items
         * @param sbg - the canvas
         */
    public void update(PlayerModel pm, ItemModel im, StateBasedGame sbg) {
        im.deleteFoundItem(pm, iv);
        gameDone(sbg);
    }

    /**
     * Checks if the player has collected all items and so on won the game.
     * @param sbg - the canvas which to be changed
     */
    void gameDone(StateBasedGame sbg){
        if (im.itemsCollected()){
            sbg.enterState(100, new FadeOutTransition(), new FadeInTransition());
        }
    }
}
