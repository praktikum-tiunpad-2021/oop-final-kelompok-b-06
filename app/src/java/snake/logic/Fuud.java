package snake.logic;

import javafx.scene.paint.Color;

public class Fuud {
    public static final Color COLOR = Color.RED;

    private Point point;

    Fuud(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
