package net.makeswift.utilities.support.data;

import java.util.Objects;

public class Wrapper<Value> implements Cloneable {

    private final Value value;

    public Wrapper(Value value) {
        this.value = value;
    }

    public Value get() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Wrapper && Objects.equals(value, ((Wrapper) object).value);
    }

    @Override
    public Wrapper<Value> clone() {
        return new Wrapper<>(value);
    }

}
