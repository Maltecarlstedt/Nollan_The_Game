package Items;

import Items.Filled.*;
import Items.Unfilled.*;
import model.PlayerModel;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds the information for the items to be found and the unfilled items
 *
 * @author Clara Simonsson
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
     */
    public ItemModel(){
        initMaterialsToFind();
        initMaterialsUnfilled();
    }

    /**
     * Gets the list with the items that needs to be found.
     * @return the list of items to be found
     */
    HashMap<String, Item> getItemsToFind(){ return materialsFilled;}

    /**
     * Gets the list of items that are not found yet
     * @return the list of unfilled items
     */
    HashMap<String, Item> getItemsUf(){ return materialsUnfilled;}

    /**
     * Checks if the player has collected all items and so on won the game.
     * @param sbg - the canvas which to be changed
     */
    void gameDone(StateBasedGame sbg){
        if (itemsCollected()){
            sbg.enterState(100, new FadeOutTransition(), new FadeInTransition());
        }
    }
    
    /**
     * Checks if all items has been found
     * @return true if the list of items to be found is empty
     */
    boolean itemsCollected(){
        return getItemsToFind().size() == 0;
    }

    /**
     * Deletes the item when the player
     * has either intersected with it on the map or won a task.
     * @param pm - the player
     * @param iv - our view of the item
     */
    void deleteFoundItem(PlayerModel pm, ItemView iv){
        for (Map.Entry<String, Item> material : getItemsToFind().entrySet()) {
            String key = material.getKey();
            Item value = material.getValue();
            if (itemFound(pm, iv, value)) {
                replace(key, value);
                break;
            }
        }
    }
    /**
     * Checks if the player has either intersected with the item on the map
     * or completed a task on the map.
     * @param pm - the player
     * @param iv - our view of the item
     * @param item - the specific item in our list
     * @return true if the criteria are achieved
     */
    private boolean itemFound(PlayerModel pm, ItemView iv, Item item){
        return (pm.getNextLocation().intersects(item.location) && iv.currentMap.equals(item.getCurrentMap()));
    }

    /**
     * Replaces an item that isn´t found with the collected item.
     * @param key - The name of the item that are found
     * @param value - the item with a location and image
     */
    private void replace(String key, Item value){
        for (Map.Entry<String, Item> material : getItemsUf().entrySet()) {
            String replaceableKey = material.getKey();
            Item replaceableValue = material.getValue();
            if (replaceableKey.contains(key)) {
                value.location = replaceableValue.location;
                getItemsUf().replace(replaceableKey, replaceableValue, value);
                getItemsToFind().remove(key, value);
                break;
            }
        }
    }

    /**
     * Puts all items to be collected in a hashmap
     */
    private void initMaterialsToFind(){
        materialsFilled.put("Scissor", new Scissor());
        materialsFilled.put("Karkort", new Karkort());
        materialsFilled.put("Cardboard", new Cardboard());
        materialsFilled.put("Rope", new Rope());
        materialsFilled.put("BlackColor", new BlackColor());
        materialsFilled.put("TurquoiseColor", new TurquoiseColor());
    }

    /**
     * Puts all items that are not found yet in a hashmap
     */
    private void initMaterialsUnfilled(){
        materialsUnfilled.put("ScissorUf", new ScissorUf());
        materialsUnfilled.put("KarkortUf", new KarkortUf());
        materialsUnfilled.put("CardboardUf", new CardboardUf());
        materialsUnfilled.put("RopeUf", new RopeUf());
        materialsUnfilled.put("BlackColorUf", new BlackColorUf());
        materialsUnfilled.put("TurquoiseColorUf", new TurquoiseColorUf());
    }
}
