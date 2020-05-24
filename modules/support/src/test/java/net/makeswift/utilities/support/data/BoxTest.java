package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A box")
public class BoxTest {

    @Test
    @DisplayName("holds the value it was constructed with")
    public void holdsTheValueItWasConstructedWith() {

        Object value = new Object();

        Box<Object> box = new Box<>(value);

        assertSame(value, box.get());

    }

    @Test
    @DisplayName("holds the last value that was put inside of it")
    public void holdsTheLastValueThatWasPutInsideOfIt() {

        Object newValue = new Object();

        Box<Object> box = new Box<>(new Object());
        box.set(newValue);

        assertSame(newValue, box.get());

    }

    @Test
    @DisplayName("equals another box with the same value")
    public void equalsAnotherBoxWithTheSameValue() {

        Object value = new Object();
        Box<Object> anotherBox = new Box<>(value);

        Box<Object> box = new Box<>(value);

        assertEquals(anotherBox, box);

    }

    @Test
    @DisplayName("has the same has value asa another box with the same value")
    public void hasTheSameHashValueAsAnotherBoxWithTheSameValue() {

        Object value = new Object();
        Box<Object> anotherBox = new Box<>(value);

        Box<Object> box = new Box<>(value);

        assertEquals(anotherBox.hashCode(), box.hashCode());

    }

}
