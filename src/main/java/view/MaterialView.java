package view;


import model.MapModel;
import model.MaterialModel;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class MaterialView {


    public String currentMap;

    public void renderMaterial(Graphics g, MaterialModel mm) {
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

    public void renderFindMaterial(Graphics g, MaterialModel materialModel, MapModel mapModel) {
        drawMaterial(mapModel, g, materialModel);
    }

    //TODO Find a better way to write these criterias?
    public Boolean imgKarhuset(Image value, MaterialModel mm, String currentMap){
        if(currentMap.equals("KARHUSET")){
            return true;
        }
        return false;
    }



    public void drawMaterial(MapModel mapModel, Graphics g, MaterialModel mm) {
        currentMap = mapModel.getCurrentMap().toString();
        /*if (currentMap.equals("ADAMMEN")) {
            g.drawImage(mm.scissor, mm.getScissorLocation().x, mm.getScissorLocation().y);
        }
        if (currentMap.equals("KARHUSET")) {
            for (Map.Entry<Rectangle, Image> material : mm.getMaterialsF().entrySet()){
                Rectangle key = material.getKey();
                Image value = material.getValue();
                g.drawImage(value, key.x, key.y);
            }

         */

        for (Map.Entry<Rectangle, Image> material : mm.getMaterialsF().entrySet()){
            Rectangle key = material.getKey();
            Image value = material.getValue();
            //TODO Find a way to draw right icon on right map without using duplicated code
            if (imgKarhuset(value,mm, currentMap)){
                g.drawImage(value, key.x, key.y);
            }
            if (currentMap.equals("ADAMMEN") && value.equals(mm.cardboard)){
                g.drawImage(value, key.x, key.y);
            }


                /*
                g.drawImage(mm.scissor, mm.getScissorLocation().x, mm.getScissorLocation().y);
                g.drawImage(mm.karkort, mm.getKarkortLocation().x, mm.getKarkortLocation().y);
                g.drawImage(mm.cardboard, mm.getCardboardLocation().x, mm.getCardboardLocation().y);
                g.drawImage(mm.rope, mm.getRopeLocation().x, mm.getRopeLocation().y);
                g.drawImage(mm.blackColor, mm.getBlackColorLocation().x, mm.getBlackColorLocation().y);
                g.drawImage(mm.turqoiseColor, mm.getTurqoiseColorLocation().x, mm.getTurqoiseColorLocation().y);

                 */
            }
        }

}
