package snake.logic;

public class Point {
    private final int x;   
    private final int y;    

    Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    //get
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //buat board
    public Point translate(int dx, int dy) {
        return new Point(x + dx, y + dy);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point)) return false;
        Point point = (Point) other;
        return x == point.x & y == point.y;
    }

    public String toString() {
        return x + ", " + y;
    }
}
