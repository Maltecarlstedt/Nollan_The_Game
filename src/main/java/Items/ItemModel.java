package Items;

import Items.Filled.*;
import Items.Unfilled.*;
import org.newdawn.slick.SlickException;
import java.util.HashMap;

/**
 * Holds the information for the items to be found and the unfilled items
 */
public class ItemModel {

    /**
     * All items to be found and all unfilled items with their specific characteristics.
     * The hashmaps/lists with the items
     */
    private final HashMap<String, Item> materialsFilled = new HashMap<>();
    private final HashMap<String, Item> materialsUnfilled = new HashMap<>();

    /**
     * The constructor of the ItemModel. It puts all the items in the lists
     * @throws SlickException - throws an exception if a filepath to the image or map is not found
     */
    public ItemModel() throws SlickException {
        initMaterialsToFind();
        initMaterialsUnfilled();
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
    HashMap<String, Item> getItemsUf(){ return materialsUnfilled;}

    /**
     * Checks if all items has been found
     * @return true if the list of items to be found is empty
     */
    boolean itemsCollected(){
        return getItemsToFind().size() == 0;
    }

    /**
     * Puts all items to be collected in a hashmap
     * @throws SlickException - throws an exception if a filepath to the image or map is not found
     */
    private void initMaterialsToFind() throws SlickException {
        materialsFilled.put("Scissor", new Scissor());
        materialsFilled.put("Karkort", new Karkort());
        materialsFilled.put("Cardboard", new Cardboard());
        materialsFilled.put("Rope", new Rope());
        materialsFilled.put("BlackColor", new BlackColor());
        materialsFilled.put("TurquoiseColor", new TurquoiseColor());
    }

    /**
     * Puts all items that are not found yet in a hashmap
     * @throws SlickException - throws an exception if a filepath to the image or map is not found
     */
    private void initMaterialsUnfilled() throws SlickException {
        materialsUnfilled.put("ScissorUf", new ScissorUf());
        materialsUnfilled.put("KarkortUf", new KarkortUf());
        materialsUnfilled.put("CardboardUf", new CardboardUf());
        materialsUnfilled.put("RopeUf", new RopeUf());
        materialsUnfilled.put("BlackColorUf", new BlackColorUf());
        materialsUnfilled.put("TurquoiseColorUf", new TurquoiseColorUf());
    }
}
