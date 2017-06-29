package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.combination.YamsRule;
import org.junit.Test;

/**
 */
public class SquareRuleTest extends AbstractDiceRuleTest {


    @Test
    public void should_return_nothing_when_only_unique_values(){
        given_an_square_rule();
        when_we_apply_them_on(roll(2,5,3,7,8));
        then_we_have_no_score_result();
    }

    @Test
    public void should_return_nothing_when_less_than_4_identical_values(){
        given_an_square_rule();
        when_we_apply_them_on(roll(2,5,2,7,2));
        then_we_have_no_score_result();
    }

    @Test
    public void should_return_score_when_found_4_identical_values(){
        given_an_square_rule();
        when_we_apply_them_on(roll(2,5,2,2,2));
        then_we_have(new CombinationScore(YamsRule.SQUARE,50));
    }

    @Test
    public void should_return_all_square_combination_score(){
        given_an_square_rule();
        when_we_apply_them_on(roll(3,2,5,2,2,2,3,3,3));
        then_we_have(new CombinationScore(YamsRule.SQUARE,50));
        then_we_have_result_count_of(2);
    }


    private void given_an_square_rule(){
        super.rule=new SquareRule();
    }

}