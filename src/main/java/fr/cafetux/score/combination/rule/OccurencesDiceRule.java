package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.dice.DiceFace;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static fr.cafetux.score.combination.YamsRule.OCCURENCES;

/**
 */
public class OccurencesDiceRule implements DiceRule{


    @Override
    public List<CombinationScore> apply(List<DiceFace> dices){
        List<CombinationScore> ruleMatches = new ArrayList<>();

        dices.stream()
                .map(diceFace -> checkOccurenceRule(dices, diceFace))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(ruleMatches::add);

        return ruleMatches;
    }

    private Optional<CombinationScore> checkOccurenceRule(List<DiceFace> dices, DiceFace diceFace) {
        Long nbOccurences = dices.stream().filter(x -> x.hasSameIDentity(diceFace)).count();
        if (nbOccurences > 1) {
            return Optional.of(new CombinationScore(OCCURENCES, nbOccurences.intValue()*diceFace.getValue()));
        }
        return Optional.empty();
    }
}
