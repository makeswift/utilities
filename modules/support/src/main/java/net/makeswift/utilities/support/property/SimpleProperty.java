package net.makeswift.utilities.support.property;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Function;

@Data
public final class SimpleProperty<Entity> implements Property<Entity> {

	private final String name;

	@ToString.Exclude
	@Getter(AccessLevel.PRIVATE)
	private final Function<Entity, Object> accessor;

	public Object apply(Entity entity) {
		return accessor.apply(entity);
	}

}