package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.dice.DiceFace;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static fr.cafetux.score.combination.YamsRule.SQUARE;

/**
 */
public class SquareRule implements DiceRule{

    @Override
    public List<CombinationScore> apply(List<DiceFace> dices){
        List<CombinationScore> ruleMatches = new ArrayList<>();

        diceUniqueValues(dices)
                .stream()
                .map(diceFace -> searchSquare(dices, diceFace))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(ruleMatches::add);

        return ruleMatches;
    }

    private Optional<CombinationScore> searchSquare(List<DiceFace> dices, DiceFace diceFace) {
        Long nbOccurences = dices.stream().filter(x -> x.hasSameIDentity(diceFace)).count();
        if (nbOccurences == 4) {
            return Optional.of(new CombinationScore(SQUARE, 50));
        }
        return Optional.empty();
    }

    private Set<DiceFace> diceUniqueValues(List<DiceFace> dices) {
        return dices.stream()
                .collect(Collectors.toSet());
    }

}
