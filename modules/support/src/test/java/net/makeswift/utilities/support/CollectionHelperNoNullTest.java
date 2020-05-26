package net.makeswift.utilities.support;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("The 'noNull' collection helper")
public class CollectionHelperNoNullTest {

    @Test
    @DisplayName("returns the passed value when it is null")
    public void returnsThePassedCollectionWhenItNull() {

        Collection<Object> returnedCollection = CollectionHelper.noNull("collection", null);

        assertNull(returnedCollection);

    }

    @Test
    @DisplayName("returns the passed value when it is empty")
    public void returnsThePassedCollectionWhenItIsEmpty() {

        Collection<Object> collection = Collections.emptyList();

        Collection<Object> returnedCollection = CollectionHelper.noNull("collection", collection);

        assertSame(collection, returnedCollection);

    }

    @Test
    @DisplayName("returns the passed value when it contains no null")
    public void returnsThePassedCollectionWhenItContainsNoNull() {

        Collection<Object> collection = Collections.singletonList(new Object());

        Collection<Object> returnedCollection = CollectionHelper.noNull("collection", collection);

        assertSame(collection, returnedCollection);

    }

    @Test
    @DisplayName("fails when the passed collection contains null")
    public void failsWhenTheCollectionContainsNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            CollectionHelper.noNull("collection", Collections.singletonList(null));
        });

    }

    @ParameterizedTest
    @ValueSource(strings = {"object", "value"})
    @DisplayName("uses the passed name when the passed collection contains null")
    public void usesThePassedNameWhenThePassedCollectionContainsNull(String name) {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CollectionHelper.noNull(name, Collections.singletonList(null));
        });

        assertTrue(exception.getMessage().contains(name));

    }

    @Test
    @DisplayName("uses a generic name when the passed name is null")
    public void usesAGenericNameWhenThePassedValueIsNull() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            CollectionHelper.noNull(null, Collections.singletonList(null));
        });

        assertTrue(exception.getMessage().contains("value"));

    }

}
