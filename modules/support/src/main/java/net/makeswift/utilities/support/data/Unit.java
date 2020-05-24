package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Property;
import net.makeswift.utilities.support.property.PropertyHelper;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Unit implements Comparable<Unit>, Cloneable, Serializable {

    private static final long serialVersionUID = -571480973265861585L;

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
    public int compareTo(Unit other) {
        return 0;
    }

    @Override
    public Unit clone() {
        return this;
    }

}
