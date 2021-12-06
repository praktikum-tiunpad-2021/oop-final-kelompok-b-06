package snake.gui;

import snake.logic.Fuud;
import snake.logic.Board;
import snake.logic.Point;
import snake.logic.Snek;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static snake.logic.Board.SIZE;

public class Painter {
    public static void paint(Board grid, GraphicsContext gc) {
        gc.setFill(Board.COLOR);
        gc.fillRect(0, 0, grid.getWidth(), grid.getHeight());

        // Food
        gc.setFill(Fuud.COLOR);
        paintPoint(grid.getFood().getPoint(), gc);

        // Snake
        Snek snake = grid.getSnake();
        gc.setFill(Snek.COLOR);
        snake.getPoints().forEach(point -> paintPoint(point, gc));
        if (!snake.isSafe()) {
            gc.setFill(Snek.DEAD);
            paintPoint(snake.getHead(), gc);
        }

        // Score
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Montserrat", 40));
        gc.fillText("Score : " + ((100 * snake.getPoints().size())-500), 10, 40);
    }

    // private static void paintLine(Line line) {
    //     for(int i = 0; i < WIDTH/SIZE; i++){
    //         line.setStartX(i);
    //         line.setStartY(i);
    //         line.setEndX(100);
    //         line.setEndY(100);
    //     }
    // }

    //painter
    private static void paintPoint(Point point, GraphicsContext gc) {
        gc.fillRect(point.getX() * SIZE, point.getY() * SIZE, SIZE, SIZE);
    }

    //aftermath
    public static void paintResetMessage(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Montserrat", 60));
        gc.fillText("Game Over", 240, 330);
        gc.fillText("Press Enter to reset.", 150, 410);
    }
    public static void waiting(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Montserrat", 60));
        gc.fillText("Loading...", 250, 500);
    }
    public static void notLoaded(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Montserrat", 60));
        gc.fillText("Loading Failed", 200, 500);
    }
    public static void leaderBoard(Board grid, GraphicsContext gc) {
        //clear board
        gc.setFill(Board.COLOR);
        gc.fillRect(0, 0, grid.getWidth(), grid.getHeight());

        //show leaderboard
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Montserrat", 60));
        gc.fillText("Leaderboard", 100, 200);
        gc.fillText("XXX  300", 100, 300);
        gc.fillText("XXX  300", 100, 380);
        gc.fillText("XXX  300", 100, 460);

    }
}