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
        g.drawImage(materialModel.scissorUnfilled, materialModel.getScissorUnfilledLocation().x, materialModel.getScissorUnfilledLocation().y);
        g.drawImage(materialModel.karkort, materialModel.getkarkortLocation().x, materialModel.getkarkortLocation().y);
        g.drawImage(materialModel.cardboard, materialModel.getCardboardLocation().x, materialModel.getCardboardLocation().y);
    }

    public void renderFindMaterial(Graphics g, MaterialModel materialModel, MapModel mapModel){
        drawMaterial(mapModel, g, materialModel);
    }


    public void drawMaterial(MapModel mapModel, Graphics g, MaterialModel materialModel){
        currentMap = mapModel.getCurrentMap().toString();
        if (currentMap.equals("ADAMMEN")){
            g.drawImage(materialModel.scissor, materialModel.getScissorLocation().x, materialModel.getScissorLocation().y);
        }
    }
}
