package net.makeswift.utilities.support.property;

public interface Property<Entity> {

    public String getName();

    public Object apply(Entity entity);

}
