package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Property;
import net.makeswift.utilities.support.property.PropertyHelper;
import net.makeswift.utilities.support.property.SimpleProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Wrapper<Value> implements Cloneable, Serializable {

    private static final long serialVersionUID = 4354943973975212929L;

    private static final List<Property<Wrapper<?>>> PROPERTIES = Collections.singletonList(
        new SimpleProperty<Wrapper<?>>("value", Wrapper::get)
    );

    private final Value value;

    public Wrapper(Value value) {
        this.value = value;
    }

    public Value get() {
        return value;
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
    public Wrapper<Value> clone() {
        return new Wrapper<>(value);
    }

}
