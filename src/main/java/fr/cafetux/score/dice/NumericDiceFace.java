package fr.cafetux.score.dice;

/**
 * Created by fmaury on 15/06/17.
 */
public class NumericDiceFace implements DiceFace{
    private int value;

    public NumericDiceFace(int value) {
        this.value = value;
    }

    @Override
    public boolean hasSameIDentity(DiceFace dice) {
        if(dice==null){
            return false;
        }
        return dice.getValue()==value;
    }

    public int getValue() {
        return value;
    }
}
