package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Property;
import net.makeswift.utilities.support.property.PropertyHelper;

import java.util.Collections;
import java.util.List;

public class Unit implements Cloneable, Comparable<Unit> {

    private static final List<Property<Unit>> PROPERTIES = Collections.emptyList();

    private static final Unit INSTANCE = new Unit();

    private Unit() {
    }

    public static Unit get() {
        return INSTANCE;
    }

    @Override
    public int hashCode() {
        return PropertyHelper.hashCode(this, PROPERTIES);
    }

    @Override
    public boolean equals(Object object) {
        return PropertyHelper.equals(this, PROPERTIES, object);
    }

    @Override
    public String toString() {
        return PropertyHelper.toString(this, PROPERTIES);
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
