package net.makeswift.utilities.support.data;

import java.util.Objects;

public class Tuple<First, Second> implements Cloneable {

    private final First first;

    private final Second second;

    public Tuple(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public First getFirst() {
        return first;
    }

    public Second getSecond() {
        return second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Tuple
            && Objects.equals(first, ((Tuple) object).first)
            && Objects.equals(second, ((Tuple) object).second);
    }

    @Override
    public Tuple<First, Second> clone() {
        return new Tuple<>(first, second);
    }

}
