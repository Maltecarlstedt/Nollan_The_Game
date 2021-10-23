package model;

import model.MapStates.*;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.awt.*;
import java.util.ArrayList;


// TODO:: TA REDA PÅ IFALL VI VILL EXTENDA TILED MAPS??

/**
 * @author Clara Simonsson
 * @author Alexander Brunnegård
 * Holds all the information for the map
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
     * Initiates our first map, which is "Chalmersplatsen", sets up all the collisions of the map with tileSetup
     */
    private void initMap(){
        current = Chalmersplatsen.INSTANCE;
        oldState = getCurrentMap();
    }

    public MapState getCurrentMap(){ return current; }

    public void setCurrentMap(MapState current){ this.current = current; }

    /**
     * Changes the map
     * @throws SlickException - if the filepath to the next map is not found.
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