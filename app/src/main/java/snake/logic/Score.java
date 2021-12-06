package snake.logic;

public class Score{
    private String name;
    private int score;

    public Score(String nama, int skor){
        this.name = nama;
        this.score = skor;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public String toString() {
        return name + ", " + score;
    }
}