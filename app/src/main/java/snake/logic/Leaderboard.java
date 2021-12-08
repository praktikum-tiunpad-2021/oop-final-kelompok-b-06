package snake.logic;

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.lang.Exception.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javafx.scene.canvas.GraphicsContext;

import snake.gui.Painter;

public class Leaderboard implements Serializable {
    private List<Score> data;
    private Score head;
    private GraphicsContext context;

    public Leaderboard(GraphicsContext context){
        this.context = context;
        data = new ArrayList<>();
        try {
            File myObj = new File("leaderboard.txt");
            if (myObj.createNewFile()) {
                Painter.waiting(context);
                Score high1 = new Score("XXX",300);
                data.add(high1);
                head = high1;
                Score high2 = new Score("YYY",200);
                data.add(high2);
                Score high3 = new Score("ZZZ",100);
                data.add(high3);
                inputz();
            } else {
                Scanner myReader = new Scanner(myObj);
                Painter.lbExist(context);
                String a = myReader.nextLine();
                int b = Integer.parseInt(myReader.nextLine());
                Score high1 = new Score(a, b);
                data.add(high1);
                head = high1;
                a = myReader.nextLine();
                b = Integer.parseInt(myReader.nextLine());
                Score high2 = new Score(a, b);
                data.add(high2);
                a = myReader.nextLine();
                b = Integer.parseInt(myReader.nextLine());
                Score high3 = new Score(a, b);
                data.add(high3);
                myReader.close();
                inputz();
            }
        } catch (IOException f) {
            Painter.notLoaded1(context);
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ignore) {
        }
        ;}
    //get n set
    public Score getScore1(){
        return data.get(0);}
    public Score getScore2(){
        return data.get(1);}
    public Score getScore3(){
        return data.get(2);}
    public void inputz(){
        try {
            File myObj = new File("leaderboard.txt");
            Scanner myReader = new Scanner(myObj);
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write(getScore1().getName() + "\n");
            myWriter.write(getScore1().getScore() + "\n");
            myWriter.write(getScore2().getName() + "\n");
            myWriter.write(getScore2().getScore() + "\n");
            myWriter.write(getScore3().getName() + "\n");
            myWriter.write(getScore3().getScore() + "\n");
            myWriter.close();
        } catch (IOException f) {
            Painter.notLoaded(context);
        }}
    public void newScore(Score high){
        if(data.get(2).getScore() < high.getScore()){
            try {
            File myObj = new File("leaderboard.txt");
            Scanner myReader = new Scanner(myObj);
            this.data.remove(2);
            if(this.data.get(0).getScore() < high.getScore()){
                this.data.add(0, high);
                head = high;}else if(this.data.get(1).getScore() < high.getScore()){
                this.data.add(1, high);}else{
                this.data.add(2, high);}
            
            myObj.delete();
            inputz();
            myReader.close();
            } catch (FileNotFoundException f) {
            Painter.notLoaded(context);}}}}
