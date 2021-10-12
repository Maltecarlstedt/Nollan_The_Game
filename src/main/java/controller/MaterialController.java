package controller;

import model.MaterialModel;
import model.PlayerModel;
import org.newdawn.slick.Image;
import org.w3c.dom.css.Rect;
import view.MaterialView;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MaterialController {

    MaterialModel mm;
    MaterialView mv;
    PlayerModel pm;

    boolean isColliding = false;

    public MaterialController( MaterialModel mm, MaterialView mv, PlayerModel pm) {
        this.mm = mm;
        this.mv = mv;
        this.pm = pm;
    }


    public void update(PlayerModel pm) {
        //isColliding = materialCollision(pm);
        //collectedItem();
        removeMaterial(pm);
       // deleteMaterial();
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

    public void removeMaterial(PlayerModel pm){
       // for (Rectangle material: mm.getMaterialsF().keySet()){
            Rectangle rect = deleteMaterial();
            if (pm.getNextLocation().intersects(rect)){
                mm.getMaterialsF().remove(rect);
            }


        //}
    }


    public Rectangle deleteMaterial(){
        Rectangle key = mm.getMaterialsFilled().get(0);
        for (Map.Entry<Rectangle, Image> material : mm.getMaterialsF().entrySet()){
            key = material.getKey();
            return key;


            /*
            if (pm.getNextLocation().intersects(key)){
                mm.getMaterialsF().remove(key, value);
            }

             */


        }
        return key;
    }

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
