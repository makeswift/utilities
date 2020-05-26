package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Properties;
import net.makeswift.utilities.support.property.PropertiesBuilder;

import java.io.Serializable;

public class Wrapper<Value> implements Cloneable, Serializable {

    private static final long serialVersionUID = 4354943973975212929L;

    private static final Properties<Wrapper<?>> PROPERTIES = new PropertiesBuilder<Wrapper<?>>()
        .add("value", Wrapper::get)
        .build();

    private final Value value;

    public Wrapper(Value value) {
        this.value = value;
    }

    public Value get() {
        return value;
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
    public Wrapper<Value> clone() {
        return new Wrapper<>(value);
    }

}
