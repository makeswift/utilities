package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A triple")
public class TripleTest {

    @Test
    @DisplayName("holds the values it was constructed with")
    public void holdsTheValuesItWasConstructedWith() {

        Object first = new Object();
        Object second = new Object();
        Object third = new Object();

        Triple<Object, Object, Object> triple = new Triple<>(first, second, third);

        assertSame(first, triple.getFirst());
        assertSame(second, triple.getSecond());
        assertSame(third, triple.getThird());

    }

    @Test
    @DisplayName("equals another triple with the same values")
    public void equalsAnotherTripleWithTheSameValues() {

        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        Triple<Object, Object, Object> anotherTriple = new Triple<>(first, second, third);

        Triple<Object, Object, Object> triple = new Triple<>(first, second, third);

        assertEquals(anotherTriple, triple);

    }

    @Test
    @DisplayName("doesn't equals another triple with a different value at the first position")
    public void doesntEqualAnotherTripleWithADifferentValueAtTheFirstPosition() {

        Object second = new Object();
        Object third = new Object();
        Triple<Object, Object, Object> anotherTriple = new Triple<>(new Object(), second, third);

        Triple<Object, Object, Object> triple = new Triple<>(new Object(), second, third);

        assertNotEquals(anotherTriple, triple);

    }

    @Test
    @DisplayName("doesn't equals another triple with a different value at the second position")
    public void doesntEqualAnotherTripleWithADifferentValueAtTheSecondPosition() {

        Object first = new Object();
        Object third = new Object();
        Triple<Object, Object, Object> anotherTriple = new Triple<>(first, new Object(), third);

        Triple<Object, Object, Object> triple = new Triple<>(first, new Object(), third);

        assertNotEquals(anotherTriple, triple);

    }

    @Test
    @DisplayName("doesn't equals another triple with a different value at the third position")
    public void doesntEqualAnotherTripleWithADifferentValueAtTheThirdPosition() {

        Object first = new Object();
        Object second = new Object();
        Triple<Object, Object, Object> anotherTriple = new Triple<>(first, second, new Object());

        Triple<Object, Object, Object> triple = new Triple<>(first, second, new Object());

        assertNotEquals(anotherTriple, triple);

    }

    @Test
    @DisplayName("has the same has value asa another triple with the same values")
    public void hasTheSameHashValueAsAnotherTripleWithTheSameValues() {

        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        Triple<Object, Object, Object> anotherTriple = new Triple<>(first, second, third);

        Triple<Object, Object, Object> triple = new Triple<>(first, second, third);

        assertEquals(anotherTriple.hashCode(), triple.hashCode());

    }

}
