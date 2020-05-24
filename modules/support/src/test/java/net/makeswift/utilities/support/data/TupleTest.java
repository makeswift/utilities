package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("doesn't equals another tuple with a different value at the first position")
    public void doesntEqualAnotherTupleWithADifferentValueAtTheFirstPosition() {

        Object second = new Object();
        Tuple<Object, Object> anotherTuple = new Tuple<>(new Object(), second);

        Tuple<Object, Object> tuple = new Tuple<>(new Object(), second);

        assertNotEquals(anotherTuple, tuple);

    }

    @Test
    @DisplayName("doesn't equals another tuple with a different value at the second position")
    public void doesntEqualAnotherTupleWithADifferentValueAtTheSecondPosition() {

        Object first = new Object();
        Tuple<Object, Object> anotherTuple = new Tuple<>(first, new Object());

        Tuple<Object, Object> tuple = new Tuple<>(first, new Object());

        assertNotEquals(anotherTuple, tuple);

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
