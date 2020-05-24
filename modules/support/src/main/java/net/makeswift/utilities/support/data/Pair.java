package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Property;
import net.makeswift.utilities.support.property.PropertyHelper;
import net.makeswift.utilities.support.property.SimpleProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Pair<Value> implements Cloneable, Serializable {

    private static final long serialVersionUID = 1844809987437199261L;

    private static final List<Property<Pair<?>>> PROPERTIES = Arrays.asList(
        new SimpleProperty<Pair<?>>("first", Pair::getFirst),
        new SimpleProperty<Pair<?>>("second", Pair::getSecond)
    );

    private final Value first;

    private final Value second;

    public Pair(Value first, Value second) {
        this.first = first;
        this.second = second;
    }

    public Value getFirst() {
        return first;
    }

    public Value getSecond() {
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
    public Pair<Value> clone() {
        return new Pair<>(first, second);
    }

}
