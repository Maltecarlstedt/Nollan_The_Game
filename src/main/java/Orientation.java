public enum Orientation {
    RIGHT(1,0), UP(0,-1), LEFT(-1,0), DOWN(0,1), IDLE(0,0);
    public int deltaX, deltaY;

    Orientation(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
}
