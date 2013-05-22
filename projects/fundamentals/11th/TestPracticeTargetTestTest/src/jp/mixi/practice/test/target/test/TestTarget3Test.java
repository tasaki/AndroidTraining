package jp.mixi.practice.test.target.test;

import jp.mixi.practice.test.target.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ProviderTestCase2;

public class TestTarget3Test extends ActivityInstrumentationTestCase2<MainActivity> {

	public TestTarget3Test(Class<MainActivity> activityClass) {
		super(activityClass);
	}

	public void testTarget3Main() throws Exception {
		assertEquals(1,1);
	}
}
