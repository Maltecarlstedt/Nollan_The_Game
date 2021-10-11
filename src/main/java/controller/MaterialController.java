package controller;

import model.MaterialModel;
import model.PlayerModel;
import view.MaterialView;

import java.awt.*;

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
        isColliding = materialCollision(pm);
        collectedItem();
    }

    /** Method checks collision between player and item
     * @param pm the player
     * @return true if collides, otherwise false
     */
    public boolean materialCollision(PlayerModel pm) {
        //Todo Make the material disapear
        for (Object material : mm.getMaterialsFilled()) {
        if (pm.getNextLocation().intersects((Rectangle) material)) {
                return true;
            }
        }
        return false;
    }

    public void collectedItem() {
        for (int i = mm.getMaterialsFilled().size() - 1; i >= 0; i--) {
            if (isColliding) {
                System.out.println("item gone" + i);
                mm.getMaterialsFilled().remove(i);
                mm.getMaterialsUnfilled().remove(i);
            }
        }
    }

}
