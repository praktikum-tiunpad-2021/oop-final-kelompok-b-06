package snake.gui;

import snake.logic.*;
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
        gc.setFont(new Font("Montserrat", 70));
        gc.fillText("Game Over", 240, 330);
        gc.setFont(new Font("Montserrat", 40));
        gc.fillText("Sending score to leaderboard...", 50, 410);
    }
    public static void waiting(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Montserrat", 60));
        gc.fillText("Loading...", 250, 700);
    }
    public static void notLoaded1(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Montserrat", 60));
        gc.fillText("Loading Failed ...", 200, 500);
    }
    public static void notLoaded(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Montserrat", 60));
        gc.fillText("Loading Failed", 200, 600);
    }
    public static void leaderBoard(Board grid, GraphicsContext gc) {
        //clear board
        gc.setFill(Board.COLOR);
        gc.fillRect(0, 0, grid.getWidth(), grid.getHeight());

        //show leaderboard
        Snek snake = grid.getSnake();
        Score skor = new Score("AAA", ((100 * snake.getPoints().size())-500));
        Leaderboard lb = new Leaderboard(gc);
        
        
        lb.newScore(skor);
        gc.setFill(Color.GRAY);
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Montserrat", 60));
        gc.fillText("Leaderboard", 100, 200);
        gc.fillText(lb.getScore1().getName() + "  " + lb.getScore1().getScore(), 100, 300);
        gc.fillText(lb.getScore2().getName() + "  " + lb.getScore2().getScore(), 100, 380);
        gc.fillText(lb.getScore3().getName() + "  " + lb.getScore3().getScore(), 100, 460);

    }

    public static void lbExist(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.setFont(new Font("Montserrat", 30));
        gc.fillText("Leaderboard File Found", 200, 700);
    }
    ;
}