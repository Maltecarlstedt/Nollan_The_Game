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

    boolean isColliding = false;

    public ItemController(ItemModel mm, ItemView mv, PlayerModel pm) {
        this.mm = mm;
        this.mv = mv;
        this.pm = pm;
    }


    public void update(PlayerModel pm) {
        //isColliding = materialCollision(pm);
        //collectedItem();
        //removeMaterial(pm);
       // deleteMaterial();
       // deleteMaterial(pm);
    }

    /** Method checks collision between player and item
     * @param pm the player
     * @return true if collides, otherwise false
     */
    /*
    public boolean materialCollision(PlayerModel pm) {
        //Todo Make the material disapear
        for (Object material : mm.getMaterialsFilled()) {
        if (pm.getNextLocation().intersects((Rectangle) material)) {
                return true;
            }
        }
        return false;
    }

     */

    public void deleteMaterial(PlayerModel pm){
        /*
        for (Iterator<Map.Entry<Rectangle, Image>> it = mm.getMaterialsF().entrySet().iterator(); it.hasNext();){
            Map.Entry<Rectangle, Image> material = it.next();
            Rectangle key = material.getKey();
            Image value = material.getValue();
            if (pm.getNextLocation().intersects(key) && mv.imgKarhuset(value,mm, mv.currentMap)){
                replace(value);
                it.remove();
                break;
            }
        }

         */
    }

    public void replace(Image value){
        for (Iterator<Map.Entry<Rectangle, Image>> it = mm.getMaterialsUf().entrySet().iterator(); it.hasNext();){
            Map.Entry<Rectangle, Image> material = it.next();
            Rectangle replacableKey = material.getKey();
            Image replacableValue = material.getValue();
            if (replacableValue.getName().contains(value.getName())){
                mm.getMaterialsUf().replace(replacableKey, replacableValue, value);
                break;
            }
        }
    }

   /* public Rectangle deleteMaterial(PlayerModel pm){
        Rectangle key = new Rectangle();
        for (Map.Entry<Rectangle, Image> material : mm.getMaterialsF().entrySet()){
            key = material.getKey();
            if (pm.getNextLocation().intersects(key)){
               // mm.getMaterialsF().remove(key);
                return key;
            }
        }
        return key;
    }

    */

    /*
    public void collectedItem() {
        for (int i = mm.getMaterialsFilled().size() - 1; i >= 0; i--) {
            if (isColliding) {
                System.out.println("item gone" + i);
                mm.getMaterialsFilled().remove(i);
                mm.getMaterialsUnfilled().remove(i);
            }
        }
    }

     */

}
