package org.cachestudy.writeitbyself.store;

public interface DataStore<K, V> {
	ValueHolder<V> get(K key) throws StoreAccessException;

	PutStatus put(K key, V value) throws StoreAccessException;

	ValueHolder<V> remove(K key) throws StoreAccessException;

	void clear() throws StoreAccessException;

	enum PutStatus {
		/**
		 * New value was put
		 */
		PUT,
		/**
		 * New value was put and replace old value
		 */
		UPDATE,
		/**
		 * New value was dropped
		 */
		NOOP
	}
}
