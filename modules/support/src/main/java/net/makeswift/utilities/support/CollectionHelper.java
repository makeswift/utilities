package net.makeswift.utilities.support;

import lombok.experimental.UtilityClass;

import java.util.Collection;

@UtilityClass
public class CollectionHelper {

	public <Entity> Collection<Entity> noNull(String name, Collection<Entity> entities) {
		if (null != entities && entities.contains(null)) {
			throw new IllegalArgumentException("The given " + ObjectHelper.nonNull(name, "value") + " contains null");
		}
		return entities;
	}

}
