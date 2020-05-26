package net.makeswift.utilities.support.property;

import net.makeswift.utilities.support.CollectionHelper;
import net.makeswift.utilities.support.ObjectHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class Properties<Entity> {

    private static final Properties<Properties<?>> PROPERTIES = new PropertiesBuilder<Properties<?>>()
        .add("properties", properties -> CollectionHelper.toString(properties.properties, Property::getName))
        .build();

    private final List<Property<Entity>> properties;

    public Properties(List<Property<Entity>> properties) {
        this.properties = new ArrayList<>(CollectionHelper.notNull("properties", properties));
    }

    public int hashCode(Entity entity) {
        ObjectHelper.notNull("entity", entity);
        return Objects.hash(mapProperties(entity));
    }

    private Object[] mapProperties(Entity entity) {
        Object[] objects = new Object[properties.size()];
        Iterator<? extends Property<Entity>> iterator = properties.iterator();
        for (int i = 0, n = properties.size(); i < n; i++) {
            objects[i] = iterator.next().apply(entity);
        }
        return objects;
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Entity entity, Object object) {
        ObjectHelper.notNull("entity", entity);
        Class<Entity> type = (Class<Entity>) entity.getClass();
        if (entity == object) {
            return true;
        } else if (null == object) {
            return false;
        } else if (!type.isInstance(object)) {
            return false;
        }
        Entity other = type.cast(object);
        for (Property<Entity> property : properties) {
            if (!Objects.equals(property.apply(entity), property.apply(other))) {
                return false;
            }
        }
        return true;
    }

    public String toString(Entity entity) {
        ObjectHelper.notNull("entity", entity);
        StringBuilder builder = new StringBuilder();
        builder.append(entity.getClass().getSimpleName());
        builder.append(" [");
        Iterator<? extends Property<Entity>> iterator = properties.iterator();
        if (iterator.hasNext()) {
            Property<Entity> first = iterator.next();
            builder.append(first.getName());
            builder.append("=");
            builder.append(first.apply(entity));
            while (iterator.hasNext()) {
                Property<Entity> following = iterator.next();
                builder.append(", ");
                builder.append(following.getName());
                builder.append("=");
                builder.append(following.apply(entity));
            }
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public String toString() {
        return PROPERTIES.toString(this);
    }

}
