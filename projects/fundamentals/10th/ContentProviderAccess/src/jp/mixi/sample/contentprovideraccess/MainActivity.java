package jp.mixi.sample.contentprovideraccess;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    Uri uri = Uri.parse("content://" + "jp.mixi.sample.contentprovider.Book" + "/book");
	    Cursor cursor = getContentResolver().query(uri, null, null, null, null);
	    while (cursor.moveToNext()) {
	      Log.d("tagggg", "call:" + cursor.getString(cursor.getColumnIndexOrThrow("title")));
	    }
	    // ˆ—‚ªŠ®—¹‚µ‚½‚çCursor‚ğ•Â‚¶‚Ü‚·
	    cursor.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
