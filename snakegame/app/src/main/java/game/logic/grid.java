package game.logic;
import javafx.scene.paint.Color;

import java.util.Random;
public class grid {
    /**
     * The side length of each square point in the grid.
     */
    public static final int SIZE = 10;
    public static final Color COLOR = new Color(0.1, 0.1, 0.1, 1);

    private final int cols;     // The number of columns
    private final int rows;     // The number of rows

    private snake snake;
    private food food;

    public grid(final double width, final double height) {
        rows = (int) width / SIZE;
        cols = (int) height / SIZE;

        // initialize the snake at the centre of the screen
        snake = new snake(this, new point(rows / 2, cols / 2));

        // put the food at a random location
        food = new food(getRandomPoint());
    }

    public point wrap(point point) {
        int x = point.getX();
        int y = point.getY();
        if (x >= rows) x = 0;
        if (y >= cols) y = 0;
        if (x < 0) x = rows - 1;
        if (y < 0) y = cols - 1;
        return new point(x, y);
    }

    private point getRandomPoint() {
        Random random = new Random();
        point point;
        do {
            point = new point(random.nextInt(rows), random.nextInt(cols));
        } while (point.equals(snake.getHead()));
        return point;
    }

    /**
     * This method is called in every cycle of execution.
     */
    public void update() {
        if (food.getPoint().equals(snake.getHead())) {
            snake.extend();
            food.setPoint(getRandomPoint());
        } else {
            snake.move();
        }
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
    public double getWidth() {
        return rows * SIZE;
    }

    public double getHeight() {
        return cols * SIZE;
    }

    public snake getSnake() {
        return snake;
    }

    public food getFood() {
        return food;
    }
}
