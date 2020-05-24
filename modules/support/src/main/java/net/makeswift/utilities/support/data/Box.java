package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Property;
import net.makeswift.utilities.support.property.PropertyHelper;
import net.makeswift.utilities.support.property.SimpleProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Box<Value> implements Cloneable, Serializable {

    private static final long serialVersionUID = 6227185449958370051L;

    private static final List<Property<Box<?>>> PROPERTIES = Collections.singletonList(
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
