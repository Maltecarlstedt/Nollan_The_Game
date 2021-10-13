package Items;


import model.MapModel;
import model.MapStates.MapState;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.*;
import java.util.Map;

public class ItemView {


    public MapState currentMap;

    public void renderMaterial(Graphics g, ItemModel mm) {
        for (Map.Entry<Rectangle, Image> material : mm.getMaterialsUf().entrySet()){
            Rectangle key = material.getKey();
            Image value = material.getValue();
            g.drawImage(value, key.x, key.y);
        }
        /*
        g.drawImage(mm.scissorUf, mm.getScissorUfLocation().x, mm.getScissorUfLocation().y);
        g.drawImage(mm.cardboardUf, mm.getCardboardUfLocation().x, mm.getCardboardUfLocation().y);
        g.drawImage(mm.ropeUf, mm.getRopeUfLocation().x, mm.getRopeUfLocation().y);
        g.drawImage(mm.blackColorUf, mm.getBlackColorUfLocation().x, mm.getBlackColorUfLocation().y);
        g.drawImage(mm.turqoiseColorUf, mm.getTurqoiseColorUfLocation().x, mm.getTurqoiseColorUfLocation().y);

         */
    }

    public void renderFindMaterial(Graphics g, ItemModel itemModel, MapModel mapModel) {
        drawMaterial(mapModel, g, itemModel);
    }

    //TODO Find a better way to write these criterias?
    public Boolean imgKarhuset(Image value, ItemModel mm, String currentMap){
        if(currentMap.equals("KARHUSET")){
            return true;
        }
        return false;
    }



    public void drawMaterial(MapModel mapModel, Graphics g, ItemModel mm) {
        currentMap = mapModel.getCurrentMap();
        for(MapState curr : mm.getCurrentMaps()){
            if (currentMap.equals(curr)){
                for (Map.Entry<String, Item> material : mm.getMaterialsF().entrySet()) {
                    String key = material.getKey();
                    Item value = material.getValue();
                    if (value.getCurrentMap().equals(curr)){
                        value.render(g);
                    }
                }
            }
        }

        /*
        for (Map.Entry<Rectangle, Image> material : mm.getMaterialsF().entrySet()){
            Rectangle key = material.getKey();
            Image value = material.getValue();
            //TODO Find a way to draw right icon on right map without using duplicated code
            if () {
            }
            }

         */
        }

}
