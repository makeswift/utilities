package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Properties;
import net.makeswift.utilities.support.property.PropertiesBuilder;

import java.io.Serializable;

public class Triple<First, Second, Third> implements Cloneable, Serializable {

    private static final long serialVersionUID = 6242634213407249631L;

    private static final Properties<Triple<?, ?, ?>> PROPERTIES = new PropertiesBuilder<Triple<?, ?, ?>>()
        .add("first", Triple::getFirst)
        .add("second", Triple::getSecond)
        .add("third", Triple::getThird)
        .build();

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
    public Triple<First, Second, Third> clone() {
        return new Triple<>(first, second, third);
    }

}
