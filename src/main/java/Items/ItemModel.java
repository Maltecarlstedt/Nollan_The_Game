package Items;

import Items.Filled.*;
import Items.Unfilled.*;
import model.MapStates.MapState;
import org.newdawn.slick.SlickException;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Holds the information for the items to be found and the unfilled items
 */
public class ItemModel {

    /**
     * All items to be found and all unfilled items with their specific characteristics.
     * The hashmaps/lists with the items
     */
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
   // private ArrayList<MapState> itemMaps = new ArrayList<>();

    /**
     * The constructor of the ItemModel. It puts all the items in the lists
     * @throws SlickException - throws an exception if a filepath to the image or map is not found
     */
    public ItemModel() throws SlickException {
        //initModel();

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

    /**
     * Gets the list with the items that needs to be found.
     * @return the list of items to be found
     */
    public HashMap<String, Item> getItemsToFind(){ return materialsFilled;}

    /**
     * Gets the list of items that are not found yet
     * @return the list of unfilled items
     */
    public HashMap<String, Item> getItemsUf(){ return materialsUnfilled;}
    /*
    public void initModel(){
        itemMaps.add(scissor.getCurrentMap());
        itemMaps.add(karkort.getCurrentMap());
        itemMaps.add(cardboard.getCurrentMap());
        itemMaps.add(rope.getCurrentMap());
        itemMaps.add(blackColor.getCurrentMap());
        itemMaps.add(turquoiseColor.getCurrentMap());
    }

     */

    /**
     * Checks if all items has been found
     * @return true if the list of items to be found is empty
     */
    public boolean itemsCollected(){
        if (getItemsToFind().size() == 0){
            System.out.println("Spelet är slut");
            return true;
        }
        return false;
    }

    /**
     * Creates a rectangle in the corner to make it easier to see which items to be collected
     */
    public void initRect(){
        rect = new Rectangle(700,710, 350, 70);
    }
}
