package Items;

import model.MapStates.Karhuset;
import model.MapStates.MapState;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemModel {

    public Rectangle rect;

    private Item scissor1 = new Scissor();
    private Item karkort1 = new Karkort();

    private Item scissorUf1 = new ScissorUf();

    private HashMap<String, Item> materialsFilled = new HashMap<>();
    private HashMap<String, Item> materialsUnfilled = new HashMap<>();
    private ArrayList<MapState> currentMaps = new ArrayList<>();

    public HashMap<String, Item> getMaterialsF(){ return materialsFilled;}
    public HashMap<String, Item> getMaterialsUf(){ return materialsUnfilled;}
    public ArrayList<MapState> getCurrentMaps(){ return currentMaps; }


    public ItemModel() throws SlickException {
        materialsFilled.put("Scissor", scissor1);
        materialsFilled.put("Karkort", karkort1);

        materialsUnfilled.put("ScissorUf", scissorUf1);

        initModel();

    }
    public void initModel(){
        currentMaps.add(scissor1.getCurrentMap());
        currentMaps.add(karkort1.getCurrentMap());
    }

    public void initRect(){
        rect = new Rectangle(700,710, 350, 70);
    }
}
