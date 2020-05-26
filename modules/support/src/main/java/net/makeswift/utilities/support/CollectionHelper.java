package net.makeswift.utilities.support;

import lombok.experimental.UtilityClass;

import java.util.Collection;

@UtilityClass
public class CollectionHelper {

	public <Entity> Collection<Entity> notNull(String name, Collection<Entity> collection) {
		if (ObjectHelper.notNull(name, collection).contains(null)) {
			throw new IllegalArgumentException("The given " + ObjectHelper.nonNull(name, "value") + " contains null");
		}
		return collection;
	}

}
