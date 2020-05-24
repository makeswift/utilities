package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("The clone of a box")
public class BoxCloneTest {

    @Test
    @DisplayName("holds the same value as the original box")
    public void holdsTheSameValueAsTheOriginalBox() {

        Object value = new Object();

        Box<Object> box = new Box<>(value).clone();

        assertSame(value, box.get());

    }


}
