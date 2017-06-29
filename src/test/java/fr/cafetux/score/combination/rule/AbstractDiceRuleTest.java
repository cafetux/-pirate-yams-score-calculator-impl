package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.combination.YamsRule;
import fr.cafetux.score.dice.DiceFace;
import fr.cafetux.score.dice.NumericDiceFace;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 */
public class AbstractDiceRuleTest {

    List<CombinationScore> result;
    DiceRule rule;

    void when_we_apply_them_on(List<DiceFace> roll) {
        result = rule.apply(new DiceFaces(roll));
    }

    List<DiceFace> roll(Integer... diceValues) {
        return stream(diceValues)
                .map(NumericDiceFace::new)
                .collect(toList());
    }

    List<DiceFace> roll(DiceFace... diceValues) {
        return stream(diceValues)
                .collect(toList());
    }

    NumericDiceFace dice(int value) {
        return new NumericDiceFace(value);
    }


    void then_we_have_no_score_result() {
        assertThat(result).isEmpty();
    }

    void then_we_have(CombinationScore expectedValue) {
        assertThat(result).isNotEmpty();
        assertThat(result).contains(expectedValue);
    }

    void then_we_have_result_count_of(int expectedResultSize) {
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(expectedResultSize);
    }

    CombinationScore score_result(YamsRule type, int score) {
        return new CombinationScore(type, score);
    }


}