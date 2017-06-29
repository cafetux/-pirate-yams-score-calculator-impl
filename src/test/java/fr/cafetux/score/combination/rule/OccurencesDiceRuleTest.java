package fr.cafetux.score.combination.rule;

import org.junit.Test;

import static fr.cafetux.score.combination.YamsRule.OCCURENCES;

/**
 */
public class OccurencesDiceRuleTest extends AbstractDiceRuleTest {


    @Test
    public void should_return_nothing_when_only_one_occurences(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(5, 6, 1, 2, 3, 4));
        then_we_have_no_score_result();
    }

    @Test
    public void should_return_double_of_dice_value_when_found_two_occurences(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(5, 6, 5, 4, 3, 4));
        then_we_have(score_result(OCCURENCES, 8));
    }


    @Test
    public void should_return_triple_of_dice_value_when_found_three_occurences(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(5, 3, 5, 4, 3, 3));
        then_we_have(score_result(OCCURENCES, 9));
        then_we_have(score_result(OCCURENCES, 10));
    }

    void given_an_occurence_rule() {
        rule = new OccurencesDiceRule();
    }

}