package view;


import model.MapModel;
import model.MaterialModel;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.ShapeFill;
import org.newdawn.slick.geom.Rectangle;

public class MaterialView {

    private String currentMap;

    public void renderMaterial(Graphics g, MaterialModel materialModel){
        g.fill(materialModel.rect);
        g.drawImage(materialModel.scissorUf, materialModel.getScissorUfLocation().x, materialModel.getScissorUfLocation().y);
        g.drawImage(materialModel.karkortUf, materialModel.getKarkortUfLocation().x, materialModel.getKarkortUfLocation().y);
        g.drawImage(materialModel.cardboardUf, materialModel.getCardboardUfLocation().x, materialModel.getCardboardUfLocation().y);
        g.drawImage(materialModel.ropeUf, materialModel.getRopeUfLocation().x, materialModel.getRopeUfLocation().y);
        g.drawImage(materialModel.blackColorUf, materialModel.getBlackColorUfLocation().x, materialModel.getBlackColorUfLocation().y);
        g.drawImage(materialModel.turqoiseColorUf, materialModel.getTurqoiseColorUfLocation().x, materialModel.getTurqoiseColorUfLocation().y);
    }

    public void renderFindMaterial(Graphics g, MaterialModel materialModel, MapModel mapModel){
        drawMaterial(mapModel, g, materialModel);
    }


    public void drawMaterial(MapModel mapModel, Graphics g, MaterialModel materialModel){
        currentMap = mapModel.getCurrentMap().toString();
        if (currentMap.equals("KARHUSET")){
            g.drawImage(materialModel.scissor, materialModel.getScissorLocation().x, materialModel.getScissorLocation().y);
            g.drawImage(materialModel.karkort, materialModel.getKarkortLocation().x, materialModel.getKarkortLocation().y);
            g.drawImage(materialModel.cardboard, materialModel.getCardboardLocation().x, materialModel.getCardboardLocation().y);
            g.drawImage(materialModel.rope, materialModel.getRopeLocation().x, materialModel.getRopeLocation().y);
            g.drawImage(materialModel.blackColor, materialModel.getBlackColorLocation().x, materialModel.getBlackColorLocation().y);
            g.drawImage(materialModel.turqoiseColor, materialModel.getTurqoiseColorLocation().x, materialModel.getTurqoiseColorLocation().y);
        }
    }
}
