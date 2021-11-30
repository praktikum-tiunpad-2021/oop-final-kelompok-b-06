package snake.logic;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Snek {
    public static final Color COLOR = new Color(0.1, 0.1, 0.1, 1);
    public static final Color DEAD = Color.RED;
    private Board grid;
    private int length;
    private boolean safe;
    private List<Point> points;
    private Point head;
    private int xVelocity;
    private int yVelocity;

    //Constructor
    public Snek(Board grid, Point initialPoint) {
        length = 1;
        points = new LinkedList<>();
        points.add(initialPoint);
        head = initialPoint;
        safe = true;
        this.grid = grid;
        xVelocity = 0;
        yVelocity = 0;
        Point in1 = new Point((initialPoint.getX()+1),initialPoint.getY());
        growTo(in1);
        Point in2 = new Point((initialPoint.getX()+2),initialPoint.getY());
        growTo(in2);
        Point in3 = new Point((initialPoint.getX()+3),initialPoint.getY());
        growTo(in3);
        Point in4 = new Point((initialPoint.getX()+4),initialPoint.getY());
        growTo(in4);
    }

    //Logic
    private void growTo(Point point) {
        length++;
        checkAndAdd(point);
    }

    private void shiftTo(Point point) {
        // The head goes to the new location
        checkAndAdd(point);
        // The last/oldest position is dropped
        points.remove(0);
    }

    private void checkAndAdd(Point point) {
        // point = grid.wall(point);
        safe &= !points.contains(point);
        if (point.getX() >= grid.getRows() || point.getY() >= grid.getCols()) safe = false;
        if (point.getX() < 0 || point.getY() < 0) safe = false;
        points.add(point);
        head = point;
    }

    //get n set
    public List<Point> getPoints() {
        return points;
    }

    public boolean isSafe() {
        return safe;
    }

    public Point getHead() {
        return head;
    }

    private boolean isStill() {
        return xVelocity == 0 & yVelocity == 0;
    }

    //Movement
    public void move() {
        if (!isStill()) {
            shiftTo(head.translate(xVelocity, yVelocity));
        }
    }

    public void extend() {
        if (!isStill()) {
            growTo(head.translate(xVelocity, yVelocity));
        }
    }

    public void setUp(GameLoop loop) {
        if (yVelocity == 1 && length > 1) return;
        if (loop.isKeyPressed()) return;
        if (isStill()) return;
        xVelocity = 0;
        yVelocity = -1;
        loop.setKeyPressed();
    }

    public void setDown(GameLoop loop) {
        if (yVelocity == -1 && length > 1) return;
        if (loop.isKeyPressed()) return;
        if (isStill()) return;
        xVelocity = 0;
        yVelocity = 1;
        loop.setKeyPressed();
    }

    public void setLeft(GameLoop loop) {
        if (xVelocity == 1 && length > 1) return;
        if (loop.isKeyPressed()) return;
        if (isStill()) return;
        xVelocity = -1;
        yVelocity = 0;
        loop.setKeyPressed();
    }

    public void setRight(GameLoop loop) {
        if (xVelocity == -1 && length > 1) return;
        if (loop.isKeyPressed()) return;
        if (isStill()) return;
        xVelocity = 1;
        yVelocity = 0;
        loop.setKeyPressed();
    }

    public void go() {
        xVelocity = 1;
        yVelocity = 0;
    }
}