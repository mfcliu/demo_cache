package org.cachestudy.writeitbyself.store.impl;

import java.util.concurrent.ConcurrentHashMap;

import org.cachestudy.writeitbyself.store.DataStore;
import org.cachestudy.writeitbyself.store.StoreAccessException;
import org.cachestudy.writeitbyself.store.ValueHolder;

public class WeakValueDataStore<K, V> implements DataStore<K, V> {

	ConcurrentHashMap<K, ValueHolder<V>> map = new ConcurrentHashMap<K, ValueHolder<V>>();

	@Override
	public ValueHolder<V> get(K key) throws StoreAccessException {
		return map.get(key);
	}

	@Override
	public PutStatus put(K key, V value) throws StoreAccessException {
		ValueHolder<V> v = new WeakValueHolder<V>(value);
		map.put(key, v);
		return PutStatus.PUT;
	}

	@Override
	public ValueHolder<V> remove(K key) throws StoreAccessException {
		return map.remove(key);
	}

	@Override
	public void clear() throws StoreAccessException {
		map.clear();
	}

}
