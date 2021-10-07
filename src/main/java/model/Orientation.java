package model;

/**
 * Creates an enum for the Player's orientation.
 * The orientation holds the speeds of which the player move in each axis.
 */

public enum Orientation {
    RIGHT(2,0), UP(0,-2), LEFT(-2,0), DOWN(0,2), IDLE(0,0);
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
