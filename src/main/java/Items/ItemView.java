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
        for (Map.Entry<String, Item> material : mm.getMaterialsUf().entrySet()){
            String key = material.getKey();
            Item value = material.getValue();
            value.render(g);
        }
    }

    public void renderFindMaterial(Graphics g, ItemModel itemModel, MapModel mapModel) {
        drawMaterial(mapModel, g, itemModel);
    }

    public void drawMaterial(MapModel mapModel, Graphics g, ItemModel mm) {
        currentMap = mapModel.getCurrentMap();
        for(MapState curr : mm.getCurrentMaps()){
            if (currentMap.equals(curr) && !mapModel.hasTask()){
                for (Map.Entry<String, Item> material : mm.getMaterialsF().entrySet()) {
                    String key = material.getKey();
                    Item value = material.getValue();
                    if (value.getCurrentMap().equals(curr)){
                        value.render(g);
                    }
                }
            }
        }
        }

}
