package fr.cafetux.score.dice;

/**
 * Created by fmaury on 15/06/17.
 */
public interface DiceFace {

    boolean hasSameIDentity(DiceFace dice);
    int getValue();
}
