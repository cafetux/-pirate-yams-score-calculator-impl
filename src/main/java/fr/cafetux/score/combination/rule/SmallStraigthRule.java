package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.dice.DiceFace;

import java.util.*;
import java.util.stream.Collectors;

import static fr.cafetux.score.combination.YamsRule.SMALL_STRAIGTH;
import static java.util.Collections.singletonList;
import static java.util.Collections.unmodifiableList;

/**
 */
public class SmallStraigthRule implements DiceRule{


    private static final List<CombinationScore> EMPTY_LIST = unmodifiableList(new ArrayList<>());
    private static final List<CombinationScore> RESULT = singletonList(new CombinationScore(SMALL_STRAIGTH, 25));


    @Override
    public List<CombinationScore> apply(DiceFaces dices){
        if(dices.distinct().toList().stream().map(DiceFace::getValue).collect(Collectors.toList()).containsAll(Arrays.asList(1, 2, 3, 4, 5))){
            return RESULT;
        }
        return EMPTY_LIST;
    }

}
