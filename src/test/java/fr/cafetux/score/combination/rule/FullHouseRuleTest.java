package fr.cafetux.score.combination.rule;

import fr.cafetux.score.combination.CombinationScore;
import org.junit.Test;

import static fr.cafetux.score.combination.YamsRule.FULL_HOUSE;

/**
 */
public class FullHouseRuleTest extends AbstractDiceRuleTest {


    @Test
    public void should_return_nothing_when_have_not_full_house(){
        given_a_full_house_rule();
        when_we_apply_them_on(roll(3,6,9,2,3));
        then_we_have_no_score_result();
    }

    @Test
    public void should_return_score_match_when_have_full_house(){
        given_a_full_house_rule();
        when_we_apply_them_on(roll(3,6,6,3,3));
        then_we_have_result_count_of(1);
        then_we_have(new CombinationScore(FULL_HOUSE,40));
    }
    @Test
    public void should_not_require_exact_number_of_dice_face(){
        given_a_full_house_rule();
        when_we_apply_them_on(roll(3,6,6,3,3,3));
        then_we_have_result_count_of(1);
        then_we_have(new CombinationScore(FULL_HOUSE,40));
    }

    @Test
    public void should_have_pair_different_than_three(){
        given_a_full_house_rule();
        when_we_apply_them_on(roll(3,3,3));
        then_we_have_no_score_result();
    }

    private void given_a_full_house_rule() {
        super.rule=new FullHouseRule();
    }

}