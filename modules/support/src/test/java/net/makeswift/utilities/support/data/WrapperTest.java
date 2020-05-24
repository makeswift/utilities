package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("A wrapper")
public class WrapperTest {

    @Test
    @DisplayName("holds the value it was constructed with")
    public void holdsTheValueItWasConstructedWith() {

        Object value = new Object();

        Wrapper<Object> wrapper = new Wrapper<>(value);

        assertSame(value, wrapper.get());

    }

    @Test
    @DisplayName("equals another wrapper with the same value")
    public void equalsAnotherWrapperWithTheSameValue() {

        Object value = new Object();
        Wrapper<Object> anotherWrapper = new Wrapper<>(value);

        Wrapper<Object> wrapper = new Wrapper<>(value);

        assertEquals(anotherWrapper, wrapper);

    }

    @Test
    @DisplayName("has the same has value asa another wrapper with the same value")
    public void hasTheSameHashValueAsAnotherWrapperWithTheSameValue() {

        Object value = new Object();
        Wrapper<Object> anotherWrapper = new Wrapper<>(value);

        Wrapper<Object> wrapper = new Wrapper<>(value);

        assertEquals(anotherWrapper.hashCode(), wrapper.hashCode());

    }

}
