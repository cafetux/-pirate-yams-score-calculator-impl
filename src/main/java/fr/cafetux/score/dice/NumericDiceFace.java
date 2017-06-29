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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumericDiceFace that = (NumericDiceFace) o;

        return value == that.value;

    }

    @Override
    public int hashCode() {
        return value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return String.valueOf(value);
    }
}
