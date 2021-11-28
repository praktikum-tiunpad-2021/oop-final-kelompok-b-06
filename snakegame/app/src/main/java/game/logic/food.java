package game.logic;
import javafx.scene.paint.Color;

public class food {
    public static final Color COLOR = Color.RED;

    private point point;
    food(point point){
        this.point = point;
    }

    public point getPoint(){
        return point;
    }

    public void setPoint(point point){
        this.point = point;
    }
}
