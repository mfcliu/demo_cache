package org.cachestudy.writeitbyself;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;

import org.cachestudy.writeitbyself.bean.User;
import org.junit.Test;

public class CsCache107Test {
	@Test
	public void test01() {
		CachingProvider cachingProvider = Caching.getCachingProvider();
		CacheManager manager = cachingProvider.getCacheManager();
		Cache<String, User> cache = (Cache<String, User>) manager
				.<String, User, Configuration<String, User>> createCache("Test",
						new MutableConfiguration<String, User>());
		String key = "leo";
		User user = new User();
		user.setName("leo");
		cache.put(key, user);
		System.out.println("Hello " + cache.get(key).getName());

	}
}
