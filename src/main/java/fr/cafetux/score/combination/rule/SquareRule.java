package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;

import java.util.ArrayList;
import java.util.List;

import static fr.cafetux.score.combination.YamsRule.SQUARE;

/**
 */
public class SquareRule implements DiceRule{

    @Override
    public List<CombinationScore> apply(DiceFaces dices){
        List<CombinationScore> ruleMatches = new ArrayList<>();

        dices.distinct()
                .filter(diceFace -> dices.count(diceFace)>=4)
                .forEach(f->ruleMatches.add(new CombinationScore(SQUARE,50)));

        return ruleMatches;
    }

}
