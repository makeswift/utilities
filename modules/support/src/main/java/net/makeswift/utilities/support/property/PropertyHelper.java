package net.makeswift.utilities.support.property;

import lombok.experimental.UtilityClass;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class PropertyHelper {

    public <Entity> int hashCode(Entity entity, List<? extends Property<Entity>> properties) {
        return Objects.hash(mapProperties(entity, properties));
    }

    private <Entity> Object[] mapProperties(Entity entity, List<? extends Property<Entity>> properties) {
        Object[] objects = new Object[properties.size()];
        for (int i = 0, n = properties.size(); i < n; i++) {
            objects[i] = properties.get(i).apply(entity);
        }
        return objects;
    }

    @SuppressWarnings("unchecked")
    public <Entity> boolean equals(Entity entity, List<? extends Property<Entity>> properties, Object object) {
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

    public <Entity> String toString(Entity entity, List<? extends Property<Entity>> properties) {
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

}
