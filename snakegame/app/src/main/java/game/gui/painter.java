package game.gui;

import game.logic.food;
import game.logic.grid;
import game.logic.point;
import game.logic.snake;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static game.logic.grid.SIZE;

public class painter {
    public static void paint(grid grid, GraphicsContext gc) {
        gc.setFill(grid.COLOR);
        gc.fillRect(0, 0, grid.getWidth(), grid.getHeight());

        // Now the Food
        gc.setFill(food.COLOR);
        paintPoint(grid.getFood().getPoint(), gc);

        // Now the snake
        snake snake = grid.getSnake();
        gc.setFill(snake.COLOR);
        snake.getPoints().forEach(point -> paintPoint(point, gc));
        if (!snake.isSafe()) {
            gc.setFill(snake.DEAD);
            paintPoint(snake.getHead(), gc);
        }

        // The score
        gc.setFill(Color.BEIGE);
        gc.fillText("Score : " + 100 * snake.getPoints().size(), 10, 490);
    }

    private static void paintPoint(point point, GraphicsContext gc) {
        gc.fillRect(point.getX() * SIZE, point.getY() * SIZE, SIZE, SIZE);
    }

    public static void paintResetMessage(GraphicsContext gc) {
        gc.setFill(Color.AQUAMARINE);
        gc.fillText("Hit RETURN to reset.", 10, 10);
    }
}
