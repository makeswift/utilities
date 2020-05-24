package net.makeswift.utilities.support.data;

public class Unit implements Comparable<Unit>, Cloneable {

    private static final Unit INSTANCE = new Unit();

    private Unit() {
    }

    public static Unit get() {
        return INSTANCE;
    }

    @Override
    protected Unit clone() {
        return this;
    }

    @Override
    public int compareTo(Unit other) {
        return 0;
    }

}
