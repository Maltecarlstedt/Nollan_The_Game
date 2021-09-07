import java.awt.*;

public class Player {
    private Point location;
    private int width, height;
    private Orientation orientation;

    public Player(){
        location = new Point(1024/2, 768/2);
        width = 45;
        height = 60;
        orientation = Orientation.IDLE;

    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(int x, int y) {
        location.x = x;
        location.y = y;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setLocation(Point location) {
        location = location;
    }

    public void move() {
        location.x += orientation.deltaX * 2;
        location.y += orientation.deltaY * 2;
    }

}