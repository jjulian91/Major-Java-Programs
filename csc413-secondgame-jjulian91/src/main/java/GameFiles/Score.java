package GameFiles;

public class Score {
    private String name;
    private int score;

    public Score(String name, int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name+"             "+score;
    }

    public String getName(){return this.name;}

    public int getScore() {
        return score;
    }

    public String getScoreString(){return Integer.toString(score);}
}
