package fr.cafetux.score.combination;

import fr.cafetux.score.combination.rule.DiceFaces;
import fr.cafetux.score.combination.rule.DiceRule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;

/**
 */
public class Combinations {

    private final List<DiceRule> rules;

    public Combinations(List<DiceRule> rules){
        this.rules= ofNullable(rules)
                .orElse(new ArrayList<>());
    }

    public List<CombinationScore> find(DiceFaces dices){
        Set<CombinationScore> combinationScores = new HashSet<>();

        rules.stream()
                .flatMap(r -> r.apply(dices).stream())
                .forEach(combinationScores::add);

        return new ArrayList<>(combinationScores);
    }

}
