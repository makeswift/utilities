package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Properties;
import net.makeswift.utilities.support.property.PropertiesBuilder;

import java.io.Serializable;

public class Unit implements Comparable<Unit>, Cloneable, Serializable {

    private static final long serialVersionUID = -571480973265861585L;

    private static final Properties<Unit> PROPERTIES = new PropertiesBuilder<Unit>().build();

    private static final Unit INSTANCE = new Unit();

    private Unit() {
    }

    public static Unit get() {
        return INSTANCE;
    }

    @Override
    public int hashCode() {
        return PROPERTIES.hashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return PROPERTIES.equals(this, object);
    }

    @Override
    public String toString() {
        return PROPERTIES.toString(this);
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
