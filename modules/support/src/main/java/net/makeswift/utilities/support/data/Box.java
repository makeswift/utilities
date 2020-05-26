package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Properties;
import net.makeswift.utilities.support.property.PropertiesBuilder;

import java.io.Serializable;

public final class Box<Value> implements Cloneable, Serializable {

    private static final long serialVersionUID = 6227185449958370051L;

    private static final Properties<Box<?>> PROPERTIES = new PropertiesBuilder<Box<?>>()
        .add("value", Box::get)
        .build();

    private Value value;

    public Box(Value value) {
        this.value = value;
    }

    public Value get() {
        return value;
    }

    public void set(Value value) {
        this.value = value;
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
    public Box<Value> clone() {
        return new Box<>(value);
    }

}
