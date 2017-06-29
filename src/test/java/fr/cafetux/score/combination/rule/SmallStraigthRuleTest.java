package fr.cafetux.score.combination.rule;

import org.junit.Test;

import static fr.cafetux.score.combination.YamsRule.SMALL_STRAIGTH;

/**
 */
public class SmallStraigthRuleTest extends AbstractDiceRuleTest{

    @Test
    public void should_return_nothing_when_no_small_straigth(){
        given_an_small_straigt_rule();
        when_we_apply_them_on(roll(1,3,4,5,6));
        then_we_have_no_score_result();
    }

    @Test
    public void should_return_score_when_found_small_straigth(){
        given_an_small_straigt_rule();
        when_we_apply_them_on(roll(1,2,3,4,5));
        then_we_have(score_result(SMALL_STRAIGTH, 25));
    }


    public void given_an_small_straigt_rule(){
        this.rule=new SmallStraigthRule();
    }
}