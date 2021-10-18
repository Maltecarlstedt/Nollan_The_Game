package model;

/**
 * Creates an enum for the Player's orientation.
 * The orientation holds the speeds of which the player move in each axis.
 */

public enum Orientation {
    RIGHT(20,0), UP(0,-20), LEFT(-20,0), DOWN(0,20), IDLE(0,0);
    public int deltaX, deltaY;

    /**
     * Changes the location of the player depending on what orientation it has
     * @param deltaX - x velocity
     * @param deltaY - y velocity
     */
    Orientation(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
}
