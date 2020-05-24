package net.makeswift.utilities.support.property;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.function.Function;

@Data
public final class TypedProperty<Entity, Value> implements Property<Entity> {

	private final String name;

	@ToString.Exclude
	@Getter(AccessLevel.PRIVATE)
	private final Function<Entity, Value> accessor;

	public Value apply(Entity entity) {
		return accessor.apply(entity);
	}

}