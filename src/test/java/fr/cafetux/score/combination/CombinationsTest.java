package fr.cafetux.score.combination;

import fr.cafetux.score.combination.rule.LargeStraigthRule;
import fr.cafetux.score.combination.rule.OccurencesDiceRule;
import fr.cafetux.score.combination.rule.SmallStraigthRule;
import fr.cafetux.score.dice.DiceFace;
import fr.cafetux.score.dice.NumericDiceFace;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static fr.cafetux.score.combination.YamsRule.SMALL_STRAIGTH;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by fmaury on 15/06/17.
 */
public class CombinationsTest {
    private DiceFace ONE= new NumericDiceFace(1);
    private DiceFace TWO= new NumericDiceFace(2);
    private DiceFace THREE= new NumericDiceFace(3);
    private DiceFace FOUR= new NumericDiceFace(4);
    private DiceFace FIVE= new NumericDiceFace(5);
    private DiceFace SIX= new NumericDiceFace(6);

    private Combinations combinations = new Combinations(Arrays.asList(new OccurencesDiceRule(),new LargeStraigthRule(),new SmallStraigthRule()));
    private List<DiceFace> dices;
    private List<CombinationScore> actualCombinations;

    @Test
    public void should_return_nothing_when_no_combinations(){

        given_dice_results(asList(ONE, TWO, THREE));
        when_we_check_combination();
        then_no_combination_found();
    }

    @Test
    public void should_return_sum_of_dices_when_more_than_two(){
        given_dice_results(asList(ONE, ONE, THREE));
        when_we_check_combination();
        assertThat(actualCombinations).hasSize(1);
        assertThat(actualCombinations.get(0).getScore()).isEqualTo(2);
    }

    @Test
    public void should_return_all_combinations_match_with_more_than_two(){
        given_dice_results(asList(ONE, ONE, THREE,TWO,TWO,TWO));
        when_we_check_combination();
        assertThat(actualCombinations).hasSize(2);
        assertThat(actualCombinations.get(0).getScore()).isEqualTo(1 + 1);
        assertThat(actualCombinations.get(1).getScore()).isEqualTo(2 + 2 + 2);
    }

    @Test
    public void should_return_small_Straight_combinations(){
        given_dice_results(asList(ONE, THREE,FIVE,TWO,FOUR));
        when_we_check_combination();
        assertThat(actualCombinations).hasSize(1);
        assertThat(actualCombinations.get(0).getRule()).isEqualTo(SMALL_STRAIGTH);
        assertThat(actualCombinations.get(0).getScore()).isEqualTo(25);
    }

    private void given_dice_results(List<DiceFace> dices) {
        this.dices = dices;
    }

    private void when_we_check_combination() {
        actualCombinations=combinations.find(dices);
    }

    private void then_no_combination_found() {
        assertThat(actualCombinations).isEmpty();
    }
}