package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("The clone of a triple")
public class TripleCloneTest {

    @Test
    @DisplayName("holds the same values as the original triple")
    public void holdsTheSameValueAsTheOriginalTriple() {

        Object first = new Object();
        Object second = new Object();
        Object third = new Object();

        Triple<Object, Object, Object> triple = new Triple<>(first, second, third).clone();

        assertSame(first, triple.getFirst());
        assertSame(second, triple.getSecond());
        assertSame(third, triple.getThird());

    }


}
