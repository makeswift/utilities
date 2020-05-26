package net.makeswift.utilities.support.property;

import net.makeswift.utilities.support.ObjectHelper;

import java.util.function.Function;

public final class TypedProperty<Entity, Value> implements Property<Entity> {

    private static final Properties<Property<?>> PROPERTIES = new PropertiesBuilder<Property<?>>()
        .add("name", Property::getName)
        .build();

    private final String name;

    private final Function<Entity, Value> accessor;

    public TypedProperty(String name, Function<Entity, Value> accessor) {
        this.name = ObjectHelper.notNull("name", name);
        this.accessor = ObjectHelper.notNull("accessor", accessor);
    }

    @Override
    public String getName() {
        return name;
    }

    public Value apply(Entity entity) {
        return accessor.apply(entity);
    }

    @Override
    public String toString() {
        return PROPERTIES.toString(this);
    }

}