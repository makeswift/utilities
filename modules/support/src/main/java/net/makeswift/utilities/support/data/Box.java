package net.makeswift.utilities.support.data;

import java.util.Objects;

public class Box<Value> implements Cloneable {

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
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Box && Objects.equals(value, ((Box) object).value);
    }

    @Override
    public Box<Value> clone() {
        return new Box<>(value);
    }

}
