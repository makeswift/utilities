package net.makeswift.utilities.support.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("The clone of the unit value")
public class UnitCloneTest {

    @Test
    @DisplayName("is the original value")
    public void isTheOriginalValue() {

        Unit unit = Unit.get();
        Unit clone = unit.clone();

        assertSame(unit, clone);

    }

}
