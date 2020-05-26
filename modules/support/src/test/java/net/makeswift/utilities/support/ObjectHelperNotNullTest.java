package net.makeswift.utilities.support;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("The 'notNull' object helper")
public class ObjectHelperNotNullTest {

	@Test
	@DisplayName("returns the passed value when it is not null")
	public void returnsThePassedValueWhenItIsNotNull() {

		Object object = new Object();

		Object returnedObject = ObjectHelper.notNull("object", object);

		assertSame(object, returnedObject);

	}

	@Test
	@DisplayName("fails when the passed value is null")
	public void failsWhenThePassedObjectIsNull() {

		assertThrows(IllegalArgumentException.class, () -> {
			ObjectHelper.notNull("object", null);
		});

	}

	@ParameterizedTest
	@ValueSource(strings = { "object", "value" })
	@DisplayName("uses the passed name when the passed value is null")
	public void usesThePassedNameWhenThePassedValueIsNull(String name) {

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			ObjectHelper.notNull(name, null);
		});

		assertTrue(exception.getMessage().contains(name));

	}

	@Test
	@DisplayName("uses a generic name when the passed name is null")
	public void usesAGenericNameWhenThePassedNameIsNull() {

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			ObjectHelper.notNull(null, null);
		});

		assertTrue(exception.getMessage().contains("value"));

	}

}
