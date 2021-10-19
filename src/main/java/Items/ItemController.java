package Items;

import model.MapModel;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.awt.*;
import java.lang.reflect.GenericDeclaration;
import java.util.Iterator;
import java.util.Map;

    /**
     * The class that dictates the update of the items
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
        deleteFoundItem(pm, im);
        gameDone(sbg);
    }

        /**
         * Checks if the player has collected all items and so on won the game.
         * @param sbg - the canvas which to be changed
         */
    public void gameDone(StateBasedGame sbg){
        if (im.itemsCollected()){
            sbg.enterState(100, new FadeOutTransition(), new FadeInTransition());
        }
    }

        /**
         * Deletes the item when the player
         * has either intersected with it on the map or won a task.
         * @param pm - the player
         * @param im - the items
         */
    private void deleteFoundItem(PlayerModel pm, ItemModel im){
        for (Iterator<Map.Entry<String, Item>> it = im.getItemsToFind().entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Item> material = it.next();
            String key = material.getKey();
            Item value = material.getValue();
            if (itemFound(pm, iv, value)){
                replace(key, value);
                //Todo will be removed even if it doesn`t match an item in the unfilled list, do something about it?
                it.remove();
                break;
            }
        }
    }

        /**
         * Checks if the player has either intersected with the item on the map
         * or completed a task on the map.
         * @param pm - the player
         * @param iv - our view of the item
         * @param item - the specific item in our list
         * @return true if the criteria are achieved
         */
    private boolean itemFound(PlayerModel pm, ItemView iv, Item item){
        return (pm.getNextLocation().intersects(item.location) && iv.currentMap.equals(item.getCurrentMap()));
    }

        /**
         * Replaces an item that isn´t found with the collected item.
         * @param key - The name of the item that are found
         * @param value - the item with a location and image
         */
    private void replace(String key, Item value){
        for (Iterator<Map.Entry<String, Item>> it = im.getItemsUf().entrySet().iterator(); it.hasNext();){
            Map.Entry<String,Item> material = it.next();
            String replacableKey = material.getKey();
            Item replacableValue = material.getValue();
            if (replacableKey.contains(key)){
                value.location = replacableValue.location;
                im.getItemsUf().replace(replacableKey, replacableValue, value);
                break;
            }
        }
    }

}
