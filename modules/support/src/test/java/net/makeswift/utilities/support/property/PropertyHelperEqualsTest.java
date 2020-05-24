package net.makeswift.utilities.support.property;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import net.makeswift.utilities.support.data.Pair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("The 'equals' property helper")
public class PropertyHelperEqualsTest {

	@Test
	@DisplayName("equates equal objects when properties are not present")
	public void equatesEqualObjectsWhenPropertiesAreNotPresent() {

		List<Property<Pair<String>>> properties = new LinkedList<>();

		Pair<String> pair = new Pair<>(null, null);
		boolean result = PropertyHelper.equals(pair, properties, pair.clone());

		assertTrue(result);
	}

	@ParameterizedTest
	@CsvSource({"one,two,foo,bar", "one,two,bar,baz", "foo,bar,one,two", "bar,baz,one,two"})
	@DisplayName("equates equal objects when properties are present")
	public void equatesEqualObjectsWhenNullPropertiesArePresent(String firstName, String secondName, String firstValue, String secondValue) {

		List<Property<Pair<String>>> properties = new LinkedList<>();
		properties.add(new TypedProperty<>(firstName, Pair::getFirst));
		properties.add(new TypedProperty<>(secondName, Pair::getSecond));

		Pair<String> pair = new Pair<>(firstValue, secondValue);
		boolean result = PropertyHelper.equals(pair, properties, pair.clone());

		assertTrue(result);

	}

	@Test
	@DisplayName("equates equal objects when null values are present")
	public void equatesEqualObjectsWhenNullValuesArePresent() {

		List<Property<Pair<String>>> properties = new LinkedList<>();
		properties.add(new TypedProperty<>("first", Pair::getFirst));
		properties.add(new TypedProperty<>("second", Pair::getSecond));

		Pair<String> pair = new Pair<>(null, null);
		boolean result = PropertyHelper.equals(pair, properties, pair.clone());

		assertTrue(result);
	}

	@Test
	@DisplayName("equates an object with itself")
	public void equatesAnObjectWithItself() {

		List<Property<Pair<String>>> properties = new LinkedList<>();
		properties.add(new TypedProperty<>("first", Pair::getFirst));
		properties.add(new TypedProperty<>("second", Pair::getSecond));

		Pair<String> pair = new Pair<>("first", "second");
		boolean result = PropertyHelper.equals(pair, properties, pair);

		assertTrue(result);

	}

	@Test
	@DisplayName("doesn't equates an object with null")
	public void doesntEquateAnObjectWithNull() {

		List<Property<Pair<String>>> properties = new LinkedList<>();
		properties.add(new TypedProperty<>("first", Pair::getFirst));
		properties.add(new TypedProperty<>("second", Pair::getSecond));

		Pair<String> pair = new Pair<>("first", "second");
		boolean result = PropertyHelper.equals(pair, properties, null);

		assertFalse(result);

	}

	@Test
	@DisplayName("doesn't equates an object with an incompatible object")
	public void doesntEquateAnObjectWithAnIncompatibleObject() {

		List<Property<Pair<String>>> properties = new LinkedList<>();
		properties.add(new TypedProperty<>("first", Pair::getFirst));
		properties.add(new TypedProperty<>("second", Pair::getSecond));

		Pair<String> pair = new Pair<>("first", "second");
		boolean result = PropertyHelper.equals(pair, properties, new Object());

		assertFalse(result);

	}

	@Test
	@DisplayName("doesn't equate unequal objects")
	public void doesntEquateUnequalObjects() {

		List<Property<Pair<String>>> properties = new LinkedList<>();
		properties.add(new TypedProperty<>("first", Pair::getFirst));
		properties.add(new TypedProperty<>("second", Pair::getSecond));

		Pair<String> pair = new Pair<>("first", "second");
		boolean result = PropertyHelper.equals(pair, properties, new Pair<>("foo", "bar"));

		assertFalse(result);

	}

}
