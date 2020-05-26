package net.makeswift.utilities.support.property;

import net.makeswift.utilities.support.ObjectHelper;
import net.makeswift.utilities.support.function.Builder;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PropertiesBuilder<Entity> implements Builder<Properties<Entity>> {

    private static final Properties<PropertiesBuilder<?>> PROPERTIES = new PropertiesBuilder<PropertiesBuilder<?>>()
        .add("properties", propertiesBuilder -> {
            return propertiesBuilder.properties.stream().map(Property::getName).collect(Collectors.joining(", "));
        })
        .build();

    private final List<Property<Entity>> properties = new LinkedList<>();

    public PropertiesBuilder<Entity> add(Property<Entity> property) {
        this.properties.add(
            ObjectHelper.notNull("property", property)
        );
        return this;
    }

    public PropertiesBuilder<Entity> add(String name, Function<Entity, Object> accessor) {
        this.properties.add(
            new SimpleProperty<>(
                ObjectHelper.notNull("name", name),
                ObjectHelper.notNull("accessor", accessor)
            )
        );
        return this;
    }

    public Properties<Entity> build() {
        return new Properties<>(properties);
    }

    @Override
    public String toString() {
        return PROPERTIES.toString(this);
    }

}
