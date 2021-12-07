package snake.gui;

import snake.logic.*;
import snake.gui.Painter;
import java.io.*;
import java.lang.Exception.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.concurrent.TimeUnit;

public class SnakeGame extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    private GameLoop loop;
    private Board grid;
    private static GraphicsContext context;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane root = new StackPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        context = canvas.getGraphicsContext2D();

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {
            Snek snake = grid.getSnake();
            switch (e.getCode()) {
                case UP:
                    snake.setUp(loop);
                    break;
                case DOWN:
                    snake.setDown(loop);
                    break;
                case LEFT:
                    snake.setLeft(loop);
                    break;
                case RIGHT:
                    snake.setRight(loop);
                    break;
                case SPACE:
                    snake.go();
                    break;
                case ENTER:
                    if (loop.isPaused()) {
                        try {
                            File myObj = new File("filename.txt");
                            if (myObj.createNewFile()) {
                                Painter.waiting(context);
                            } else {
                                Painter.lbExist(context);
                            }
                        } catch (IOException f) {
                            Painter.notLoaded(context);
                        }
                        // File file = new File("D:/College/Sem 3/Praktikum/Pemrograman Berorientasi Objek/oop-final-kelompok-b-06/app/src/main/java/snake/sampleFile.txtsampleFile.txt");
                        // if(file.exists()){
                        //     Painter.waiting(context);
                        // }else{
                        //     Painter.notLoaded(context);
                        // }
                        try {
                            TimeUnit.SECONDS.sleep(1);
                            loop.stop();
                        } catch (InterruptedException ignore) {
                        }
                        reset();
                        (new Thread(loop)).start();
                    }
                default :
                    break;
            }
        });

        reset();

        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snek");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();

        (new Thread(loop)).start();
    }

    private void reset() {
        grid = new Board(WIDTH, HEIGHT);
        loop = new GameLoop(grid, context);
        Painter.paint(grid, context);
    }
}
