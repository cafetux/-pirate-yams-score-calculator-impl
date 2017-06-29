package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;

import java.util.List;

/**
 */
public interface DiceRule {
    List<CombinationScore> apply(DiceFaces dices);
}
