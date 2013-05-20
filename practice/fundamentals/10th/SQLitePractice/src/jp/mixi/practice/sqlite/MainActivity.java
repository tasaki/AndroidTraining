
package jp.mixi.practice.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Insert).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        findViewById(R.id.Delete).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });
        findViewById(R.id.Update).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        findViewById(R.id.Query).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });

    }

    private void insert() {
        // TODO:ここにinsert処理を実装してください
    	BookOpenHelper bookOpenHelper = new BookOpenHelper(this);
    	SQLiteDatabase db = bookOpenHelper.getWritableDatabase();

    	ContentValues values = new ContentValues();
        values.put(Book.COLUMN_NAME_BOOK_TITLE, "TITLE1");
        values.put(Book.COLUMN_NAME_BOOK_PUBLISHER, "PUBLISHER1");
        values.put(Book.COLUMN_NAME_BOOK_PRICE, "PRICE1");

        long rowId = db.insert(Book.BOOK_TABLE_NAME, null, values);
    }

    private void delete() {
        // TODO:ここにdelete処理を実装してください
    	BookOpenHelper bookOpenHelper = new BookOpenHelper(this);
    	SQLiteDatabase db = bookOpenHelper.getWritableDatabase();
    	
    	String selection = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
    	String[] selectionArgs = {
    		"PRICE1"
    	};
    	
    	int deleteCount = db.delete(Book.BOOK_TABLE_NAME, selection, selectionArgs);

    	Log.v("log", Integer.toString(deleteCount));
    }

    private void update() {
        // TODO:ここにupdate処理を実装してください
    	BookOpenHelper bookOpenHelper = new BookOpenHelper(this);
    	SQLiteDatabase db = bookOpenHelper.getWritableDatabase();

    	ContentValues values = new ContentValues();
    	values.put(Book.COLUMN_NAME_BOOK_TITLE, "NEW_TITLE");
    	
    	String selection = Book.COLUMN_NAME_BOOK_TITLE + " LIKE ?";
    	String[] selectionArgs = {
    		"TITLE%"
    	};
    	
    	int updatedCount = db.update(Book.BOOK_TABLE_NAME, values, selection, selectionArgs);
    	
    	Log.v("log", Integer.toString(updatedCount));
    }

    private void query() {
        // TODO:ここにquery処理を実装してください
    	BookOpenHelper bookOpenHelper = new BookOpenHelper(this);
    	SQLiteDatabase db = bookOpenHelper.getReadableDatabase();

    	String[] projection = {
    		Book._ID,
    		Book.COLUMN_NAME_BOOK_TITLE,
    		Book.COLUMN_NAME_BOOK_PUBLISHER,
    		Book.COLUMN_NAME_BOOK_PRICE
    	};
    	
    	String selection = Book.COLUMN_NAME_BOOK_PRICE + " = ?";
    	String[] selectionArgs = {
    		"PRICE1"
    	};
    	
    	Cursor cursor = db.query(Book.BOOK_TABLE_NAME, projection, selection, selectionArgs, null, null, null);
    	boolean moveToFirst = cursor.moveToFirst();
    	long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(Book._ID));
    	Log.v("log", Long.toString(itemId));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
