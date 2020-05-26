package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Properties;
import net.makeswift.utilities.support.property.PropertiesBuilder;

import java.io.Serializable;

public class Pair<Value> implements Cloneable, Serializable {

    private static final long serialVersionUID = 1844809987437199261L;

    private static final Properties<Pair<?>> PROPERTIES = new PropertiesBuilder<Pair<?>>()
        .add("first", Pair::getFirst)
        .add("second", Pair::getSecond)
        .build();

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
    public Pair<Value> clone() {
        return new Pair<>(first, second);
    }

}
