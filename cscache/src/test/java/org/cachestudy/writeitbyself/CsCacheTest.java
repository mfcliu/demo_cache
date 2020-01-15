package org.cachestudy.writeitbyself;

import org.cachestudy.writeitbyself.bean.User;
import org.cachestudy.writeitbyself.store.impl.BasicDataStore;
import org.cachestudy.writeitbyself.store.impl.LRUDataStore;
import org.cachestudy.writeitbyself.store.impl.WeakValueDataStore;
import org.junit.Assert;
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

	@Test
	public void TestLRU() {
		CsCache<String, User> cache = new CsCache<String, User>(new LRUDataStore<String, User>(2));
		String key = "leo";
		User user = new User();
		user.setName("leo");

		User oldUser = cache.remove(key);
		Assert.assertTrue(oldUser == null);

		String key1 = "liu";
		User user1 = new User();
		user1.setName("liu");

		String key2 = "robin";
		User user2 = new User();
		user2.setName("robin");

		cache.put(key, user);
		cache.put(key1, user1);
		cache.get(key);
		cache.put(key2, user2);

		if (cache.get(key) != null) {
			System.out.println("Hello " + cache.get(key).getName());
		}
		if (cache.get(key1) != null) {
			System.out.println("Hello " + cache.get(key1).getName());
		}
		if (cache.get(key2) != null) {
			System.out.println("Hello " + cache.get(key2).getName());
		}
	}
}
