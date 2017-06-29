package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.dice.DiceFace;

import java.util.List;
import java.util.Optional;

/**
 */
public interface DiceRule {
    List<CombinationScore> apply(List<DiceFace> dices);
}
