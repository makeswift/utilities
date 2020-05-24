package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("The clone of a tuple")
public class TupleCloneTest {

    @Test
    @DisplayName("holds the same values as the original tuple")
    public void holdsTheSameValueAsTheOriginalTuple() {

        Object first = new Object();
        Object second = new Object();

        Tuple<Object, Object> tuple = new Tuple<>(first, second).clone();

        assertSame(first, tuple.getFirst());
        assertSame(second, tuple.getSecond());

    }


}
