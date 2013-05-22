package jp.mixi.sample.test.test;

import android.test.AndroidTestCase;

public class TestTarget1Test extends AndroidTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testIsValidIntent() throws Exception {
		assertEquals(1,1);
		assertEquals(1,2);
	}
}