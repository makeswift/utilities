package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Property;
import net.makeswift.utilities.support.property.PropertyHelper;
import net.makeswift.utilities.support.property.SimpleProperty;

import java.util.Arrays;
import java.util.List;

public class Box<Value> implements Cloneable {

    private static final List<Property<Box<?>>> PROPERTIES = Arrays.asList(
        new SimpleProperty<Box<?>>("value", Box::get)
    );

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
    public Box<Value> clone() {
        return new Box<>(value);
    }

}
