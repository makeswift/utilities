package net.makeswift.utilities.support.property;

import net.makeswift.utilities.support.data.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("The 'hashCode' property helper")
public class PropertyHelperHashCodeTest {

    @Test
    @DisplayName("equals the hash code of an array when properties are not present")
    public void thatEqualsTheHashCodeOfAnArrayWhenPropertiesAreNotPresent() {

        List<Property<Pair<String>>> properties = new LinkedList<>();

        int hash = PropertyHelper.hashCode(new Pair<>(null, null), properties);

        assertEquals(Objects.hash(), hash);

    }

    @ParameterizedTest
    @CsvSource({"one,two,foo,bar", "one,two,bar,baz", "foo,bar,one,two", "bar,baz,one,two"})
    @DisplayName("equals the hash code of an array when properties are present")
    public void thatEqualsTheHashCodeOfAnArrayWhenPropertiesArePresent(String firstName, String secondName, String firstValue, String secondValue) {

        List<Property<Pair<String>>> properties = new LinkedList<>();
        properties.add(new TypedProperty<>(firstName, Pair::getFirst));
        properties.add(new TypedProperty<>(secondName, Pair::getSecond));

        int hash = PropertyHelper.hashCode(new Pair<>(firstValue, secondValue), properties);

        assertEquals(Objects.hash(firstValue, secondValue), hash);

    }

    @Test
    @DisplayName("use the parameter values hash values")
    public void useTheParameterHashCodes() {

        List<Property<Pair<Object>>> properties = new LinkedList<>();
        properties.add(new TypedProperty<>("first", Pair::getFirst));
        properties.add(new TypedProperty<>("second", Pair::getSecond));

        int hash = PropertyHelper.hashCode(new Pair<>(new Object() {

            @Override
            public int hashCode() {
                return 23;
            }
        }, new Object() {

            @Override
            public int hashCode() {
                return 42;
            }
        }), properties);

        assertEquals(Objects.hash(23, 42), hash);


    }

    @Test
    @DisplayName("use zero for null values")
    public void useZeroForNullValues() {

        List<Property<Pair<String>>> properties = new LinkedList<>();
        properties.add(new TypedProperty<>("first", Pair::getFirst));
        properties.add(new TypedProperty<>("second", Pair::getSecond));

        int hash = PropertyHelper.hashCode(new Pair<>(null, null), properties);

        assertEquals(Objects.hash(0, 0), hash);

    }


}
