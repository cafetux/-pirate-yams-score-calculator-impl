package fr.cafetux.score.dice;

/**
 */
public class PirateDiceFace implements DiceFace{

    public static final DiceFace GOLD=new PirateDiceFace("GOLD",5);
    public static final DiceFace DIAMOND=new PirateDiceFace("DIAMOND",5);
    public static final DiceFace PARROT=new PirateDiceFace("PARROT",1);
    public static final DiceFace MONKEY=new PirateDiceFace("MONKEY",1);
    public static final DiceFace SWORDS=new PirateDiceFace("SWORDS",1);
    public static final DiceFace DEAD_FACE=new PirateDiceFace("DEAD_FACE",1);


    private int value;
    private final String name;

    private PirateDiceFace(String name,int value) {
        this.name=name;
        this.value = value;
    }

    @Override
    public boolean hasSameIDentity(DiceFace dice) {
        if(dice==null){
            return false;
        }
        if(name.equals("DEAD_FACE")){
            return false;
        }
        if(isAnimal(name) && isAnimal(dice.getName())){
            return true;
        }
        return dice.equals(this);
    }

    private boolean isAnimal(String name) {
        return MONKEY.getName().equals(name) || PARROT.getName().equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PirateDiceFace that = (PirateDiceFace) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public int getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name;
    }
}
