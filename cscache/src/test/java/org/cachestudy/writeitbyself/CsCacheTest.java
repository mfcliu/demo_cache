package org.cachestudy.writeitbyself;

import org.cachestudy.writeitbyself.store.impl.BasicDataStore;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CsCacheTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public CsCacheTest(String testName) {
		super(testName);
		CsCache<String, String> cache = new CsCache<String, String>(new BasicDataStore<String, String>());
		String key = "Hello";
		cache.put(key, "World!");
		System.out.println(key + " " + cache.get(key));
		assertTrue(true);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CsCacheTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
}
