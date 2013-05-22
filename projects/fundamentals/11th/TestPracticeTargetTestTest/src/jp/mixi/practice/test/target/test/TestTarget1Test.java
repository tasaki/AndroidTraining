package jp.mixi.practice.test.target.test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.util.Log;
import jp.mixi.practice.test.target.TestTarget1;

public class TestTarget1Test extends AndroidTestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	// test method1
	public void testStartSubActivity() throws Exception {
		TestTarget1 target = new TestTarget1();
		target.startSubActivity(new TestTarget1Context(getContext()), "hoge");
	}
	
	// test method2
	public void testIsValidIntent() throws Exception {
		TestTarget1 target = new TestTarget1();
		Intent thisIntent = new Intent();
		
		assertFalse(target.isValidIntent(thisIntent));
		thisIntent.putExtra(Intent.EXTRA_TEXT, Intent.EXTRA_TEXT);
		assertFalse(target.isValidIntent(thisIntent));
		thisIntent.setData(Uri.parse("http://mixi.jp"));
		assertTrue(target.isValidIntent(thisIntent));
	}
	
	// mock for test method1
	private static class TestTarget1Context extends MockContext {
		private Context mContext;
		
		public TestTarget1Context(Context baseContext) {
			mContext = baseContext;
		}
		
		@Override
		public String getPackageName() {
			return mContext.getPackageName();
		}
		
		@Override
		public void startActivity(Intent intent) {
			assertEquals("hoge", intent.getStringExtra(Intent.EXTRA_SUBJECT));
		}
	}
}
