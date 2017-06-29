package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.dice.DiceFace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static fr.cafetux.score.combination.YamsRule.LARGE_STRAIGTH;
import static java.util.Collections.singletonList;
import static java.util.Collections.unmodifiableList;

/**
 */
public class LargeStraigthRule implements DiceRule{

    private static final List<CombinationScore> EMPTY_LIST = unmodifiableList(new ArrayList<>());
    private static final List<CombinationScore> RESULT = singletonList(new CombinationScore(LARGE_STRAIGTH, 25));

    @Override
    public List<CombinationScore> apply(List<DiceFace> dices){
        if(diceUniqueValues(dices).containsAll(Arrays.asList(2, 3, 4, 5, 6))){
            return RESULT;
        }
        return EMPTY_LIST;
    }

    private Set<Integer> diceUniqueValues(List<DiceFace> dices) {
        return dices.stream()
                .map(DiceFace::getValue)
                .collect(Collectors.toSet());
    }

}
