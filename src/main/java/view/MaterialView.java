package view;


import model.MapModel;
import model.MaterialModel;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.awt.*;
import java.util.Map;

public class MaterialView {


    private String currentMap;

    public void renderMaterial(Graphics g, MaterialModel mm) {
        g.drawImage(mm.scissorUf, mm.getScissorUfLocation().x, mm.getScissorUfLocation().y);
        g.drawImage(mm.karkortUf, mm.getKarkortUfLocation().x, mm.getKarkortUfLocation().y);
        g.drawImage(mm.cardboardUf, mm.getCardboardUfLocation().x, mm.getCardboardUfLocation().y);
        g.drawImage(mm.ropeUf, mm.getRopeUfLocation().x, mm.getRopeUfLocation().y);
        g.drawImage(mm.blackColorUf, mm.getBlackColorUfLocation().x, mm.getBlackColorUfLocation().y);
        g.drawImage(mm.turqoiseColorUf, mm.getTurqoiseColorUfLocation().x, mm.getTurqoiseColorUfLocation().y);
    }

    public void renderFindMaterial(Graphics g, MaterialModel materialModel, MapModel mapModel) {
        drawMaterial(mapModel, g, materialModel);
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
            if (currentMap.equals("KARHUSET") && value.equals(mm.scissor)){
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
