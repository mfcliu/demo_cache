package org.cachestudy.writeitbyself.store.impl;

import java.util.Map.Entry;

import org.cachestudy.writeitbyself.store.ValueHolder;

public class LRUEntry<K, V extends ValueHolder<?>> implements Entry<K, ValueHolder<?>> {

	final K key; // non-null
	ValueHolder<?> v; // non-null

	LRUEntry<K, ValueHolder<?>> pre;
	LRUEntry<K, ValueHolder<?>> next;

	public LRUEntry<K, ValueHolder<?>> getPre() {
		return pre;
	}

	public void setPre(LRUEntry<K, ValueHolder<?>> pre) {
		this.pre = pre;
	}

	public LRUEntry<K, ValueHolder<?>> getNext() {
		return next;
	}

	public void setNext(LRUEntry<K, ValueHolder<?>> next) {
		this.next = next;
	}

	public LRUEntry(K key, V value) {
		super();

		this.key = key;
		this.v = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public ValueHolder<?> getValue() {
		return this.v;
	}

	@Override
	public ValueHolder<?> setValue(ValueHolder<?> value) {
		ValueHolder<?> oldValue = this.v;
		this.v = value;
		return oldValue;
	}

}
