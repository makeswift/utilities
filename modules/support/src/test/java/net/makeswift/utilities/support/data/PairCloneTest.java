package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("The clone of a pair")
public class PairCloneTest {

    @Test
    @DisplayName("holds the same values as the original pair")
    public void holdsTheSameValueAsTheOriginalPair() {

        Object first = new Object();
        Object second = new Object();

        Pair<Object> pair = new Pair<>(first, second).clone();

        assertSame(first, pair.getFirst());
        assertSame(second, pair.getSecond());

    }


}
