package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A pair")
public class PairTest {

    @Test
    @DisplayName("holds the values it was constructed with")
    public void holdsTheValuesItWasConstructedWith() {

        Object first = new Object();
        Object second = new Object();

        Pair<Object> pair = new Pair<>(first, second);

        assertSame(first, pair.getFirst());
        assertSame(second, pair.getSecond());

    }

    @Test
    @DisplayName("equals another pair with the same values")
    public void equalsAnotherPairWithTheSameValues() {

        Object first = new Object();
        Object second = new Object();
        Pair<Object> anotherPair = new Pair<>(first, second);

        Pair<Object> pair = new Pair<>(first, second);

        assertEquals(anotherPair, pair);

    }

    @Test
    @DisplayName("doesn't equals another pair with a different value at the first position")
    public void doesntEqualAnotherPairWithADifferentValueAtTheFirstPosition() {

        Object second = new Object();
        Pair<Object> anotherPair = new Pair<>(new Object(), second);

        Pair<Object> pair = new Pair<>(new Object(), second);

        assertNotEquals(anotherPair, pair);

    }

    @Test
    @DisplayName("doesn't equals another pair with a different value at the second position")
    public void doesntEqualAnotherPairWithADifferentValueAtTheSecondPosition() {

        Object first = new Object();
        Pair<Object> anotherPair = new Pair<>(first, new Object());

        Pair<Object> pair = new Pair<>(first, new Object());

        assertNotEquals(anotherPair, pair);

    }

    @Test
    @DisplayName("has the same has value asa another pair with the same values")
    public void hasTheSameHashValueAsAnotherPairWithTheSameValues() {

        Object first = new Object();
        Object second = new Object();
        Pair<Object> anotherPair = new Pair<>(first, second);

        Pair<Object> pair = new Pair<>(first, second);

        assertEquals(anotherPair.hashCode(), pair.hashCode());

    }

}
