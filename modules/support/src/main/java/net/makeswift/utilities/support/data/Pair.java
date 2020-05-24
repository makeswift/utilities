package net.makeswift.utilities.support.data;

import java.util.Objects;

public class Pair<Value> implements Cloneable {

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
        return Objects.hash(first, second);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Pair
            && Objects.equals(first, ((Pair) object).first)
            && Objects.equals(second, ((Pair) object).second);
    }

    @Override
    public Pair<Value> clone() {
        return new Pair<>(first, second);
    }

}
