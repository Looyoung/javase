package reflection_test;

import java.io.Serializable;
import java.util.List;

public class Reflection implements Serializable, Cloneable {
    private String string;
    private double aDouble;
    public boolean aBoolean;
    public short aShort;

    public Reflection() {

    }

    private Reflection(double aDouble, short aShort) {
        this.aDouble = aDouble;
        this.aShort = aShort;
    }

    public Reflection(String string) {
        this.string = string;
    }

    public Reflection(String string, double aDouble, boolean aBoolean) {
        this.string = string;
        this.aDouble = aDouble;
        this.aBoolean = aBoolean;
    }

    private void privateMethod() {

    }

    public String publicMethod() {
        privateMethod();
        return null;
    }

    public String publicMethod(String string, double aDouble, List<String> stringList) {
        return "Reflection.publicMethod(String string, double aDouble, List<String> stringList),string = " + string + ", aDouble = " + aDouble;
    }

    public int returnOne() {
        return 1;
    }

    @Override
    public String toString() {
        return "String = " + string + ", aDouble = " + aDouble + ", aBoolean = " + aBoolean;
    }
}
