package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.combination.YamsRule;
import fr.cafetux.score.dice.DiceFace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 */
public class FullHouseRule implements DiceRule{

    @Override
    public List<CombinationScore> apply(List<DiceFace> dices){
        List<CombinationScore> ruleMatches = new ArrayList<>();

        List<DiceFace> threeCandidats = dices
                .stream()
                .distinct()
                .filter(diceFace -> searchThree(dices, diceFace))
                .distinct()
                .collect(Collectors.toList());

        List<DiceFace> pairCandidats = dices
                .stream()
                .distinct()
                .filter(diceFace -> searchPair(dices, diceFace))
                .distinct()
                .collect(Collectors.toList());

        pairCandidats.forEach(c->{
            for (DiceFace threeCandidat : threeCandidats) {
                if(!c.hasSameIDentity(threeCandidat)){
                    ruleMatches.add(new CombinationScore(YamsRule.FULL_HOUSE,40));
                }
            }
        });

        return ruleMatches;
    }

    private boolean searchThree(List<DiceFace> dices, DiceFace diceFace) {
        Long nbOccurences = dices.stream().filter(x -> x.hasSameIDentity(diceFace)).count();
        if (nbOccurences >= 3) {
            return true;
        }
        return false;
    }

    private boolean searchPair(List<DiceFace> dices, DiceFace diceFace) {
        Long nbOccurences = dices.stream().filter(x -> x.hasSameIDentity(diceFace)).count();
        if (nbOccurences >= 2) {
            return true;
        }
        return false;
    }


}
