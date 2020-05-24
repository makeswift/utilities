package net.makeswift.utilities.support.data;

import java.util.Objects;

public class Triple<First, Second, Third> implements Cloneable {

    private final First first;

    private final Second second;

    private final Third third;

    public Triple(First first, Second second, Third third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public First getFirst() {
        return first;
    }

    public Second getSecond() {
        return second;
    }

    public Third getThird() {
        return third;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Triple
            && Objects.equals(first, ((Triple) object).first)
            && Objects.equals(second, ((Triple) object).second)
            && Objects.equals(third, ((Triple) object).third);
    }

    @Override
    public Triple<First, Second, Third> clone() {
        return new Triple<>(first, second, third);
    }

}
