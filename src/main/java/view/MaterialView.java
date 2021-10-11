package view;


import model.MapModel;
import model.MaterialModel;
import org.newdawn.slick.Graphics;

public class MaterialView {

    MaterialModel mm;

    private String currentMap;

    public void renderMaterial(Graphics g, MaterialModel materialModel){
        g.fill(mm.rect);

        g.drawImage(mm.scissorUnfilled, mm.getScissorUnfilledLocation().x, mm.getScissorUnfilledLocation().y);
        g.drawImage(mm.karkort, mm.getkarkortLocation().x, mm.getkarkortLocation().y);
        g.drawImage(mm.cardboard, mm.getCardboardLocation().x, mm.getCardboardLocation().y);
    }

    public void renderFindMaterial(Graphics g, MaterialModel materialModel, MapModel mapModel){
        drawMaterial(mapModel, g, materialModel);
    }


    public void drawMaterial(MapModel mapModel, Graphics g, MaterialModel materialModel){
        currentMap = mapModel.getCurrentMap().toString();
        if (currentMap.equals("ADAMMEN")){
            g.drawImage(mm.scissor, mm.getScissorLocation().x, mm.getScissorLocation().y);
        }
    }
}
