package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("The clone of a wrapper")
public class WrapperCloneTest {

    @Test
    @DisplayName("holds the same value as the original wrapper")
    public void holdsTheSameValueAsTheOriginalWrapper() {

        Object value = new Object();

        Wrapper<Object> wrapper = new Wrapper<>(value).clone();

        assertSame(value, wrapper.get());

    }


}
