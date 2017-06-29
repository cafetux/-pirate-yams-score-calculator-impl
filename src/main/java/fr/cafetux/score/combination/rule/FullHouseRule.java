package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.combination.YamsRule;
import fr.cafetux.score.dice.DiceFace;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class FullHouseRule implements DiceRule{

    @Override
    public List<CombinationScore> apply(DiceFaces dices){
        List<CombinationScore> ruleMatches = new ArrayList<>();

        List<DiceFace> threeCandidats = dices
                .distinct()
                .filter(diceFace -> dices.count(diceFace)>=3)
                .toList();

        List<DiceFace> pairCandidats = dices
                .distinct()
                .filter(diceFace -> dices.count(diceFace)>=2)
                .toList();

        pairCandidats.forEach(c->{
            for (DiceFace threeCandidat : threeCandidats) {
                if (!c.hasSameIDentity(threeCandidat)) {
                    ruleMatches.add(new CombinationScore(YamsRule.FULL_HOUSE, 40));
                }
            }
        });

        return ruleMatches;
    }

}
