package org.cachestudy.writeitbyself;

import org.cachestudy.writeitbyself.store.impl.BasicDataStore;
import org.junit.Test;

public class CsCacheTest {
	@Test
	public void TestHelloWorld() {
		CsCache<String, String> cache = new CsCache<String, String>(new BasicDataStore<String, String>());
		String key = "Hello";
		cache.put(key, "World!");
		System.out.println(key + " " + cache.get(key));
	}
}
