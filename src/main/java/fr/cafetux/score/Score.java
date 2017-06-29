package fr.cafetux.score;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.combination.Combinations;
import fr.cafetux.score.dice.DiceFace;
import fr.cafetux.score.dice.DiceFaces;

import java.util.List;

/**
 * Created by fmaury on 15/06/17.
 */
public class Score {

    private DiceFaces parser;
    private Combinations combinations;

    public Integer calculate(String input){
        if(input.isEmpty()){
            return 0;
        }
        List<DiceFace> dicesFace = parser.from(input);
        List<CombinationScore> results = combinations.find(dicesFace);
        return results.stream().mapToInt(CombinationScore::getScore).max().orElse(0);
    }

}
