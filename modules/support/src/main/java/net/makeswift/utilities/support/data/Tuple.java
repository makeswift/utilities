package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Property;
import net.makeswift.utilities.support.property.PropertyHelper;
import net.makeswift.utilities.support.property.SimpleProperty;

import java.util.Arrays;
import java.util.List;

public class Tuple<First, Second> implements Cloneable {

    private static final List<Property<Tuple<?, ?>>> PROPERTIES = Arrays.asList(
        new SimpleProperty<Tuple<?, ?>>("first", Tuple::getFirst),
        new SimpleProperty<Tuple<?, ?>>("second", Tuple::getSecond)
    );

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
    public Tuple<First, Second> clone() {
        return new Tuple<>(first, second);
    }

}
