package fr.cafetux.score.combination;

import fr.cafetux.score.combination.rule.DiceRule;
import fr.cafetux.score.dice.DiceFace;

import java.util.*;

import static java.util.Optional.ofNullable;

/**
 * Created by fmaury on 15/06/17.
 */
public class Combinations {

    private final List<DiceRule> rules;

    public Combinations(List<DiceRule> rules){
        this.rules= ofNullable(rules)
                .orElse(new ArrayList<>());
    }

    public List<CombinationScore> find(List<DiceFace> dices){
        Set<CombinationScore> combinationScores = new HashSet<>();

        rules.stream()
                .flatMap(r -> r.apply(dices).stream())
                .forEach(combinationScores::add);

        return new ArrayList<>(combinationScores);
    }

}
