package Items;

import Items.Filled.*;
import Items.Unfilled.*;
import model.MapStates.MapState;
import org.newdawn.slick.SlickException;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemModel {

    public Rectangle rect;

    private Item scissor = new Scissor();
    private Item karkort = new Karkort();
    private Item cardboard = new Cardboard();
    private Item rope = new Rope();
    private Item blackColor = new BlackColor();
    private Item turquoiseColor = new TurquoiseColor();

    private Item scissorUf = new ScissorUf();
    private Item karkortUf = new KarkortUf();
    private Item cardboardUf = new CardboardUf();
    private Item ropeUf = new RopeUf();
    private Item blackColorUf = new BlackColorUf();
    private Item turquoiseColorUf = new TurquoiseColorUf();

    private HashMap<String, Item> materialsFilled = new HashMap<>();
    private HashMap<String, Item> materialsUnfilled = new HashMap<>();
    private ArrayList<MapState> itemMaps = new ArrayList<>();

    public HashMap<String, Item> getItemsToFind(){ return materialsFilled;}
    public HashMap<String, Item> getItemsUf(){ return materialsUnfilled;}
    public ArrayList<MapState> getItemMaps(){ return itemMaps; }


    public ItemModel() throws SlickException {
        initModel();

        materialsFilled.put("Scissor", scissor);
        materialsFilled.put("Karkort", karkort);
        materialsFilled.put("Cardboard", cardboard);
        materialsFilled.put("Rope", rope);
        materialsFilled.put("BlackColor", blackColor);
        materialsFilled.put("TurquoiseColor", turquoiseColor);


        materialsUnfilled.put("ScissorUf", scissorUf);
        materialsUnfilled.put("KarkortUf", karkortUf);
        materialsUnfilled.put("CardboardUf", cardboardUf);
        materialsUnfilled.put("RopeUf", ropeUf);
        materialsUnfilled.put("BlackColorUf", blackColorUf);
        materialsUnfilled.put("TurquoiseColorUf", turquoiseColorUf);


    }
    public void initModel(){
        itemMaps.add(scissor.getCurrentMap());
        itemMaps.add(karkort.getCurrentMap());
        itemMaps.add(cardboard.getCurrentMap());
        itemMaps.add(rope.getCurrentMap());
        itemMaps.add(blackColor.getCurrentMap());
        itemMaps.add(turquoiseColor.getCurrentMap());
    }

    public void initRect(){
        rect = new Rectangle(700,710, 350, 70);
    }
}
