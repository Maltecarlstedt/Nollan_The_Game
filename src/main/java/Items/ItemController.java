package Items;

import model.PlayerModel;
import org.newdawn.slick.Image;

import java.awt.*;
import java.util.Iterator;
import java.util.Map;

public class ItemController {

    ItemModel mm;
    ItemView mv;
    PlayerModel pm;

    public ItemController(ItemModel mm, ItemView mv, PlayerModel pm) {
        this.mm = mm;
        this.mv = mv;
        this.pm = pm;
    }


    public void update(PlayerModel pm) {
        deleteMaterial(pm);
    }

    /** Method checks collision between player and item
     * @param pm the player
     * @return true if collides, otherwise false
     */

    public void deleteMaterial(PlayerModel pm){
        for (Iterator<Map.Entry<String, Item>> it = mm.getMaterialsF().entrySet().iterator(); it.hasNext();){
            Map.Entry<String, Item> material = it.next();
            String key = material.getKey();
            Item value = material.getValue();
            if (pm.getNextLocation().intersects(value.location) && mv.currentMap.equals(value.getCurrentMap())){
                replace(key, value);
                it.remove();
                break;
            }
        }
    }

    public void replace(String key, Item value){
        for (Iterator<Map.Entry<String, Item>> it = mm.getMaterialsUf().entrySet().iterator(); it.hasNext();){
            Map.Entry<String,Item> material = it.next();
            String replacableKey = material.getKey();
            Item replacableValue = material.getValue();
            if (replacableKey.contains(key)){
                value.location = replacableValue.location;
                mm.getMaterialsUf().replace(replacableKey, replacableValue, value);
                break;
            }
        }
    }

}
