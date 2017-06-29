package fr.cafetux.score.combination.rule;

import fr.cafetux.score.dice.NumericDiceFace;
import org.junit.Test;

import static fr.cafetux.score.combination.YamsRule.OCCURENCES;
import static fr.cafetux.score.combination.YamsRule.SQUARE;
import static fr.cafetux.score.dice.PirateDiceFace.*;

/**
 */
public class PirateDicesRuleTest extends AbstractDiceRuleTest {


    public static final NumericDiceFace FIVE = new NumericDiceFace(5);
    public static final NumericDiceFace TWO = new NumericDiceFace(2);
    public static final NumericDiceFace FOUR = new NumericDiceFace(4);

    @Test
    public void should_be_basis_on_the_identity_and_not_into_the_value(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(DIAMOND, GOLD, SWORDS,DEAD_FACE,PARROT));
        then_we_have_no_score_result();
    }

    @Test
    public void should_return_double_of_dice_value_when_found_two_occurences(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(MONKEY, SWORDS, DIAMOND, MONKEY, GOLD));
        then_we_have(score_result(OCCURENCES, 2));
    }


    @Test
    public void should_return_triple_of_dice_value_when_found_three_occurences(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(MONKEY, SWORDS, DIAMOND, MONKEY, GOLD,MONKEY));
        then_we_have(score_result(OCCURENCES, 3));
    }

    @Test
    public void should_DIAMOND_have_value_of_5(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(DIAMOND, SWORDS, DIAMOND, DIAMOND, GOLD,MONKEY));
        then_we_have(score_result(OCCURENCES, 15));
    }

    @Test
    public void should_GOLD_have_value_of_5(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(GOLD, SWORDS, GOLD, DIAMOND, GOLD,MONKEY));
        then_we_have(score_result(OCCURENCES, 15));
    }

    @Test
    public void should_works_with_square_rule(){
        given_an_square_rule();
        when_we_apply_them_on(roll(SWORDS, SWORDS, SWORDS, DIAMOND, GOLD,MONKEY,SWORDS));
        then_we_have(score_result(SQUARE, 50));
    }

    @Test
    public void should_MONKEY_and_PARROT_was_same_diceFace(){
        given_an_square_rule();
        when_we_apply_them_on(roll(SWORDS, PARROT, PARROT, DIAMOND, GOLD,MONKEY,MONKEY));
        then_we_have(score_result(SQUARE, 50));
    }

    @Test
    public void should_DEAD_is_a_dead_dice_face(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(DEAD_FACE, SWORDS, DEAD_FACE, DIAMOND, DEAD_FACE,MONKEY));
        then_we_have_no_score_result();
    }

    @Test
    public void should_mix_symbol_and_numerics_values(){
        given_an_occurence_rule();
        when_we_apply_them_on(roll(FIVE, TWO, DIAMOND, DIAMOND, FOUR,MONKEY));
        then_we_have(score_result(OCCURENCES, 15));
    }


    void given_an_occurence_rule() {
        rule = new OccurencesDiceRule();
    }

    void given_an_square_rule() {
        rule = new SquareRule();
    }

}