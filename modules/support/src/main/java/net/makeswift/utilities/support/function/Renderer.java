package net.makeswift.utilities.support.function;

@FunctionalInterface
public interface Renderer<Value> {

	public String render(Value value);

}
