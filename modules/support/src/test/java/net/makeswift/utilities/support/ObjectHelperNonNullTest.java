package net.makeswift.utilities.support;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The 'nonNull' object helper")
public class ObjectHelperNonNullTest {

	@Test
	@DisplayName("returns the passed value when it is not null")
	public void returnsThePassedValueWhenItIsNotNull() {

		Object object = new Object();

		Object returnedObject = ObjectHelper.nonNull(object, new Object());

		assertSame(object, returnedObject);

	}

	@Test
	@DisplayName("returns the passed fallback when the passed value is null")
	public void returnsThePassedFallbackWhenThePassedValueIsNull() {

		Object fallback = new Object();

		Object returnedObject = ObjectHelper.nonNull(null, fallback);

		assertSame(fallback, returnedObject);

	}

	@Test
	@DisplayName("fails when the passed fallback is null")
	public void failsWhenThePassedFallbackIsNull() {

		assertThrows(IllegalArgumentException.class, () -> {
			ObjectHelper.nonNull(null, null);
		});

	}

}
