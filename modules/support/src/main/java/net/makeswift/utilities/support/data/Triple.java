package net.makeswift.utilities.support.data;

import net.makeswift.utilities.support.property.Property;
import net.makeswift.utilities.support.property.PropertyHelper;
import net.makeswift.utilities.support.property.SimpleProperty;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Triple<First, Second, Third> implements Cloneable, Serializable {

    private static final long serialVersionUID = 6242634213407249631L;

    private static final List<Property<Triple<?, ?, ?>>> PROPERTIES = Arrays.asList(
        new SimpleProperty<Triple<?, ?, ?>>("first", Triple::getFirst),
        new SimpleProperty<Triple<?, ?, ?>>("second", Triple::getSecond),
        new SimpleProperty<Triple<?, ?, ?>>("third", Triple::getThird)
    );

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
    public Triple<First, Second, Third> clone() {
        return new Triple<>(first, second, third);
    }

}
