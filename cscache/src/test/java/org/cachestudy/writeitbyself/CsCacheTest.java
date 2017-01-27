package org.cachestudy.writeitbyself;

import org.cachestudy.writeitbyself.bean.User;
import org.cachestudy.writeitbyself.store.impl.BasicDataStore;
import org.cachestudy.writeitbyself.store.impl.WeakValueDataStore;
import org.junit.Test;

public class CsCacheTest {
	@Test
	public void TestHelloWorld() {
		CsCache<String, String> cache = new CsCache<String, String>(new BasicDataStore<String, String>());
		String key = "Hello";
		cache.put(key, "World!");
		System.out.println(key + " " + cache.get(key));
	}

	@Test
	public void TestWeakValue() throws InterruptedException {
		CsCache<String, User> cache = new CsCache<String, User>(new WeakValueDataStore<String, User>());
		String key = "leo";
		User user = new User();
		user.setName("leo");
		cache.put(key, user);
		user = null;
		System.out.println("Hello " + cache.get(key).getName());
		System.gc();
		Thread.sleep(1000);
		System.out.println("Hello " + cache.get(key));
	}
}
