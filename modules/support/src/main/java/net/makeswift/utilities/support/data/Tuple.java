package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Properties;
import net.makeswift.utilities.support.property.PropertiesBuilder;

import java.io.Serializable;

public class Tuple<First, Second> implements Cloneable, Serializable {

    private static final long serialVersionUID = -4461009431136919961L;

    private static final Properties<Tuple<?, ?>> PROPERTIES = new PropertiesBuilder<Tuple<?, ?>>()
        .add("first", Tuple::getFirst)
        .add("second", Tuple::getSecond)
        .build();

    private final First first;

    private final Second second;

    public Tuple(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public First getFirst() {
        return first;
    }

    public Second getSecond() {
        return second;
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
    public Tuple<First, Second> clone() {
        return new Tuple<>(first, second);
    }

}
