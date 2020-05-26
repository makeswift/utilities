package net.makeswift.utilities.support.function;

@FunctionalInterface
public interface Builder<Value> {

	public Value build();

}