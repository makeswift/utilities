package net.makeswift.utilities.support;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ObjectHelper {

	public <Entity> Entity nonNull(Entity entity, Entity fallback) {
		return null != entity ? entity : notNull("fallback", fallback);
	}

	public <Entity> Entity notNull(String name, Entity entity) {
		if (null == entity) {
			throw new IllegalArgumentException("The given " + nonNull(name, "value") + " is null");
		}
		return entity;
	}

}
