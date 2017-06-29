package fr.cafetux.score;

import fr.cafetux.score.combination.CombinationScore;
import fr.cafetux.score.combination.Combinations;
import fr.cafetux.score.dice.DiceFaces;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static fr.cafetux.score.combination.YamsRule.OCCURENCES;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


/**
 * Created by fmaury on 15/06/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ScoreTest {

    private CombinationScore ONE= new CombinationScore(OCCURENCES,1);
    private CombinationScore TWO= new CombinationScore(OCCURENCES,2);
    private CombinationScore THREE= new CombinationScore(OCCURENCES,3);


    @InjectMocks
    private Score score;
    @Mock
    private DiceFaces parser;
    @Mock
    private Combinations combinations;

    private Integer actualScore;
    private String input="1;2;3;4";

    @Test
    public void should_return_0_when_no_input(){
        given_empty_input();
        when_we_calcul_score();
        then_score_is(0);
    }

    @Test
    public void should_return_the_better_score(){
        given_dice_score_results(asList(ONE, TWO, THREE, TWO));
        when_we_calcul_score();
        then_score_is(3);
    }

    private void given_dice_score_results(List<CombinationScore> input) {
        when(combinations.find(any())).thenReturn(input);
    }

    private void then_score_is(int expected) {
        assertThat(actualScore).isEqualTo(expected);
    }

    private void when_we_calcul_score() {
        actualScore = score.calculate(input);
    }

    private void given_empty_input() {
        input = "";
    }

}