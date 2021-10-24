package model;

import model.MapStates.*;

/**
 * Holds all the information for the map
 * Uses: MapStates
 * Used by: mapController, mapView
 * @author Clara Simonsson & Alexander Brunnegård
 */
public class MapModel{
    /** The current map in the form of a MapState (interface) */
    private MapState current;
    public MapState oldState;

    public boolean taskDone = false;


    /**
     * The constructor that creates our map
     * @param collisionChecker - the collisionChecker that will make sure that the player cannot move to an obstructed tile
     */
    public MapModel(CollisionChecker collisionChecker){
        initMap();
        collisionChecker.setCurrentMap(this);
    }

    /**
     * Initiates our first map, which is "Chalmersplatsen".
     * Sets the first oldstate to the current state because it's in the start.
     */
    private void initMap(){
        current = Chalmersplatsen.INSTANCE;
        oldState = getCurrentMap();
    }

    public MapState getCurrentMap(){ return current; }

    public void setCurrentMap(MapState current){ this.current = current; }

    /**
     * Changes the map
     */
    public void changeMap(PlayerModel playermodel){
        oldState = getCurrentMap();
        current = current.nextMap(playermodel);
        taskDone = false;
    }

    /**
     * Checks if there is a task on the map
     * @return true if the map has a task
     */
    public boolean hasTask(){
        return getCurrentMap().equals(Ekak.INSTANCE) || getCurrentMap().equals(DeltaP.INSTANCE);
    }
  
    public int getCurrentTopLayers(){
        return current.getTopLayers();
    }


}