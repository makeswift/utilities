package net.makeswift.utilities.support;

import lombok.experimental.UtilityClass;
import net.makeswift.utilities.support.function.Renderer;

import java.util.Collection;
import java.util.Iterator;

@UtilityClass
public class CollectionHelper {

    public <Value> Collection<Value> notNull(String name, Collection<Value> collection) {
        return Implementation.notNull(
            name,
            ObjectHelper.notNull(name, collection)
        );
    }

    public <Value> String toString(Collection<Value> collection, Renderer<Value> renderer) {
        return Implementation.toString(
            ObjectHelper.notNull("collection", collection),
            ObjectHelper.notNull("renderer", renderer),
            ", "
        );
    }

    public <Value> String toString(Collection<Value> collection, Renderer<Value> renderer, String delimiter) {
        return Implementation.toString(
            ObjectHelper.notNull("collection", collection),
            ObjectHelper.notNull("renderer", renderer),
            ObjectHelper.notNull("delimiter", delimiter)
        );
    }

    @UtilityClass
    private class Implementation {

        public <Value> Collection<Value> notNull(String name, Collection<Value> collection) {
            if (collection.contains(null)) {
                throw new IllegalArgumentException("The given " + ObjectHelper.nonNull(name, "value") + " contains null");
            }
            return collection;
        }

        public <Value> String toString(Collection<Value> collection, Renderer<Value> renderer, String delimiter) {
            StringBuilder builder = new StringBuilder();
            Iterator<Value> iterator = collection.iterator();
            if (iterator.hasNext()) {
                Value first = iterator.next();
                builder.append(renderer.render(first));
                while (iterator.hasNext()) {
                    Value following = iterator.next();
                    builder.append(delimiter);
                    builder.append(renderer.render(following));
                }
            }
            return builder.toString();
        }

    }

}
