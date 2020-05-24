package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("A tuple")
public class TupleTest {

    @Test
    @DisplayName("holds the values it was constructed with")
    public void holdsTheValuesItWasConstructedWith() {

        Object first = new Object();
        Object second = new Object();

        Tuple<Object, Object> tuple = new Tuple<>(first, second);

        assertSame(first, tuple.getFirst());
        assertSame(second, tuple.getSecond());

    }

    @Test
    @DisplayName("equals another tuple with the same values")
    public void equalsAnotherTupleWithTheSameValues() {

        Object first = new Object();
        Object second = new Object();
        Tuple<Object, Object> anotherTuple = new Tuple<>(first, second);

        Tuple<Object, Object> tuple = new Tuple<>(first, second);

        assertEquals(anotherTuple, tuple);

    }

    @Test
    @DisplayName("has the same has value asa another tuple with the same values")
    public void hasTheSameHashValueAsAnotherTupleWithTheSameValues() {

        Object first = new Object();
        Object second = new Object();
        Tuple<Object, Object> anotherTuple = new Tuple<>(first, second);

        Tuple<Object, Object> tuple = new Tuple<>(first, second);

        assertEquals(anotherTuple.hashCode(), tuple.hashCode());

    }

}
