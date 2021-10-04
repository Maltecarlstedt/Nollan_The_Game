package view;


import model.MapModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MapView {

    public MapView() throws SlickException{

    }

    public void render(GameContainer gc, Graphics g, MapModel mapModel){
        mapModel.getTiledMap().render(0,0);

    }

    public void renderTopLayer(GameContainer gc, Graphics g, MapModel mapModel){
        mapModel.getTiledMap().render(0, 0, mapModel.getTiledMap().getLayerCount()-1);
    }
}
