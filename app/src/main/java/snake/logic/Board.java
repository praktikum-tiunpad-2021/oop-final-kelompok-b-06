package snake.logic;

import javafx.scene.paint.Color;

import java.util.Random;


public class Board {

    public static final int SIZE = 8;
    public static final Color COLOR = Color.CORNSILK;

    private final int cols;     
    private final int rows;    

    private Snek snake;
    private Fuud food;

    public Board(final double width, final double height) {
        rows = (int) width / SIZE;
        cols = (int) height / SIZE;

        // menginisasi snake di tengah-tengah layar
        snake = new Snek(this, new Point(((rows / 2)-4), cols / 2));
        food = new Fuud(getRandomPoint());
    }

    // public Point wall(Point point) {
    //     int x = point.getX();
    //     int y = point.getY();
    //     if (x >= rows) x = 0;
    //     if (y >= cols) y = 0;
    //     if (x < 0) x = rows - 1;
    //     if (y < 0) y = cols - 1;
    //     return new Point(x, y);
    // }

    private Point getRandomPoint() {
        Random random = new Random();
        Point point;
        do {
            point = new Point(random.nextInt(rows), random.nextInt(cols));
        } while (point.equals(snake.getHead()));
        return point;
    }

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

    public Snek getSnake() {
        return snake;
    }

    public Fuud getFood() {
        return food;
    }
}