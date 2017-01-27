package org.cachestudy.writeitbyself.store.impl;

import org.cachestudy.writeitbyself.store.ValueHolder;

public class BasicValueHolder<V> implements ValueHolder<V> {
	private final V refValue;

	public BasicValueHolder(final V value) {
		refValue = value;
	}

	public V value() {
		return refValue;
	}
}
