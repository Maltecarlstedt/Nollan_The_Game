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

public class ItemController {

    ItemModel im;
    ItemView iv;
    PlayerModel pm;

    public ItemController(ItemModel im, ItemView iv, PlayerModel pm) {
        this.im = im;
        this.iv = iv;
        this.pm = pm;
    }


    public void update(PlayerModel pm, ItemModel im, StateBasedGame sbg, GameContainer gc) {
        deleteFoundItem(pm, im);
        gameDone(sbg);
    }

    public void gameDone(StateBasedGame sbg){
        if (im.itemsCollected()){
            sbg.enterState(100, new FadeOutTransition(), new FadeInTransition());
        }
    }

    /** Method checks collision between player and item
     * @param pm the player
     * @return true if collides, otherwise false
     */

    public void deleteFoundItem(PlayerModel pm, ItemModel im){
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

    public boolean itemFound(PlayerModel pm, ItemView iv, Item item){
        return (pm.getNextLocation().intersects(item.location) && iv.currentMap.equals(item.getCurrentMap()));
    }

    public void replace(String key, Item value){
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
