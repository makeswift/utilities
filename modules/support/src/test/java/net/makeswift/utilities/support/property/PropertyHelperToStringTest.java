package net.makeswift.utilities.support.property;

import net.makeswift.utilities.support.data.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("The 'toString' property helper")
public class PropertyHelperToStringTest {

    @Test
    @DisplayName("fails if the passed entity is null")
    public void failsIfThePassedEntityIsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            PropertyHelper.equals(null, new LinkedList<>(), new Object());
        });

    }

    @Test
    @DisplayName("fails if the passed properties are null")
    public void failsIfThePassedPropertiesAreNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            PropertyHelper.equals(new Object(), null, new Object());
        });

    }

    @Test
    @DisplayName("fails if the passed properties contain null")
    public void failsIfThePassedPropertiesContainNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            PropertyHelper.equals(new Object(), Collections.singletonList(null), new Object());
        });

    }

    @Test
    @DisplayName("comprise the class name and a parameter list")
    public void compriseTheClassNameAndAParameterList() {

        List<Property<Pair<String>>> properties = new LinkedList<>();

        String string = PropertyHelper.toString(new Pair<>(null, null), properties);

        assertEquals("Pair []", string);

    }

    @ParameterizedTest
    @CsvSource({"one,two,foo,bar", "one,two,bar,baz", "foo,bar,one,two", "bar,baz,one,two"})
    @DisplayName("use the property names and values")
    public void useThePropertyNamesAndValues(String firstName, String secondName, String firstValue, String secondValue) {

        List<Property<Pair<String>>> properties = new LinkedList<>();
        properties.add(new TypedProperty<>(firstName, Pair::getFirst));
        properties.add(new TypedProperty<>(secondName, Pair::getSecond));

        String string = PropertyHelper.toString(new Pair<>(firstValue, secondValue), properties);

        assertTrue(string.contains("[" + firstName + "=" + firstValue + ", " + secondName + "=" + secondValue + "]"));

    }

    @Test
    @DisplayName("use the parameter string representations")
    public void useTheParameterStringRepresentations() {

        List<Property<Pair<Object>>> properties = new LinkedList<>();
        properties.add(new TypedProperty<>("first", Pair::getFirst));
        properties.add(new TypedProperty<>("second", Pair::getSecond));

        String string = PropertyHelper.toString(new Pair<>(new Object() {

            @Override
            public String toString() {
                return "foo";
            }

        }, new Object() {

            @Override
            public String toString() {
                return "bar";
            }

        }), properties);

        assertEquals("Pair [first=foo, second=bar]", string);

    }

    @Test
    @DisplayName("use the null literal for null values")
    public void useTheNullLiteralForNullValues() {

        List<Property<Pair<String>>> properties = new LinkedList<>();
        properties.add(new TypedProperty<>("first", Pair::getFirst));
        properties.add(new TypedProperty<>("second", Pair::getSecond));

        String string = PropertyHelper.toString(new Pair<>(null, null), properties);

        assertEquals("Pair [first=null, second=null]", string);

    }


}
