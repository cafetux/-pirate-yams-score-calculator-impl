package fr.cafetux.score.dice;

import java.util.List;

/**
* Parse dice faces from text input
 */
public interface DiceFaces {

    List<DiceFace> from(String input);
}
