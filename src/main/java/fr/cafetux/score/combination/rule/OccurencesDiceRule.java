package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;

import java.util.ArrayList;
import java.util.List;

import static fr.cafetux.score.combination.YamsRule.OCCURENCES;

/**
 */
public class OccurencesDiceRule implements DiceRule{


    @Override
    public List<CombinationScore> apply(DiceFaces dices){
        List<CombinationScore> ruleMatches = new ArrayList<>();

        dices
                .distinct()
                .filter(f -> dices.count(f) > 1)
                .forEach(f -> ruleMatches.add(new CombinationScore(OCCURENCES, f.getValue() * dices.count(f).intValue())));

        return ruleMatches;
    }

}
