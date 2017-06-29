package fr.cafetux.score.combination;

/**
 * Created by fmaury on 15/06/17.
 */
public class CombinationScore {

    private int score;
    private YamsRule rule;

    public CombinationScore(YamsRule rule,int score)
    {
        this.rule=rule;
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CombinationScore that = (CombinationScore) o;

        return score == that.score;

    }

    @Override
    public int hashCode() {
        return score;
    }

    public YamsRule getRule() {
        return rule;
    }

    @Override
    public String toString() {
        return "{" +
                "score=" + score +
                ", rule=" + rule +
                '}';
    }
}
