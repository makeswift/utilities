package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("The unit value")
public class UnitTest {

    @Test
    @DisplayName("is not null")
    public void isNotNull() {

        assertNotNull(Unit.get());

    }

    @Test
    @DisplayName("is a singleton")
    public void isASingleton() {

        assertSame(Unit.get(), Unit.get());

    }

    @Test
    @DisplayName("is equal to itself")
    public void isEqualsToItself() {

        Unit unit = Unit.get();

        assertEquals(unit, unit);

    }

    @Test
    @DisplayName("is indicated as equal to itself")
    public void isIndicatedAsEqualToItself() {

        Unit unit = Unit.get();

        assertEquals(0, unit.compareTo(unit));

    }

}
