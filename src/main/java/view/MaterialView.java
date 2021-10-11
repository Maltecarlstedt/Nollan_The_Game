package view;


import model.MapModel;
import model.MaterialModel;
import org.newdawn.slick.Graphics;

public class MaterialView {

    private String currentMap;

    public void renderMaterial(Graphics g, MaterialModel mm) {
        g.fill(mm.rect);
        g.drawImage(mm.scissorUf, mm.getScissorUfLocation().getX(), mm.getScissorUfLocation().getY());
        g.drawImage(mm.karkortUf, mm.getKarkortUfLocation().getX(), mm.getKarkortUfLocation().getY());
        g.drawImage(mm.cardboardUf, mm.getCardboardUfLocation().getX(), mm.getCardboardUfLocation().getY());
        g.drawImage(mm.ropeUf, mm.getRopeUfLocation().getX(), mm.getRopeUfLocation().getY());
        g.drawImage(mm.blackColorUf, mm.getBlackColorUfLocation().getX(), mm.getBlackColorUfLocation().getY());
        g.drawImage(mm.turqoiseColorUf, mm.getTurqoiseColorUfLocation().getX(), mm.getTurqoiseColorUfLocation().getY());
    }

    public void renderFindMaterial(Graphics g, MaterialModel materialModel, MapModel mapModel) {
        drawMaterial(mapModel, g, materialModel);
    }


    public void drawMaterial(MapModel mapModel, Graphics g, MaterialModel mm) {
        currentMap = mapModel.getCurrentMap().toString();
        if (currentMap.equals("ADAMMEN")) {
            g.drawImage(mm.scissor, mm.getScissorLocation().getX(), mm.getScissorLocation().getY());
            if (currentMap.equals("KARHUSET")) {
                g.drawImage(mm.scissor, mm.getScissorLocation().getX(), mm.getScissorLocation().getY());
                g.drawImage(mm.karkort, mm.getKarkortLocation().getX(), mm.getKarkortLocation().getY());
                g.drawImage(mm.cardboard, mm.getCardboardLocation().getX(), mm.getCardboardLocation().getY());
                g.drawImage(mm.rope, mm.getRopeLocation().getX(), mm.getRopeLocation().getY());
                g.drawImage(mm.blackColor, mm.getBlackColorLocation().getX(), mm.getBlackColorLocation().getY());
                g.drawImage(mm.turqoiseColor, mm.getTurqoiseColorLocation().getX(), mm.getTurqoiseColorLocation().getY());
            }
        }
    }
}
