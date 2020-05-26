package net.makeswift.utilities.support.property;

import net.makeswift.utilities.support.ObjectHelper;

import java.util.function.Function;

public final class SimpleProperty<Entity> implements Property<Entity> {

    private static final Properties<Property<?>> PROPERTIES = new PropertiesBuilder<Property<?>>()
        .add("name", Property::getName)
        .build();

    private final String name;

    private final Function<Entity, Object> accessor;

    public SimpleProperty(String name, Function<Entity, Object> accessor) {
        this.name = ObjectHelper.notNull("name", name);
        this.accessor = ObjectHelper.notNull("accessor", accessor);
    }

    @Override
    public String getName() {
        return name;
    }

    public Object apply(Entity entity) {
        return accessor.apply(entity);
    }

    @Override
    public String toString() {
        return PROPERTIES.toString(this);
    }

}