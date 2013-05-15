
package jp.mixi.practice.listview.beg;

import java.util.ArrayList;

import jp.mixi.practice.listview.beg.CustomListItemAdapter;

import android.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	private MainActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i<20; i++) {
        	list.add("hoge" + i);
        }
        
        final ListView listView = (ListView) findViewById(R.id.ListView);
        CustomListItemAdapter adapter = new CustomListItemAdapter(mActivity, list);

        listView.setAdapter(adapter);
        // リストアイテムをタップした時の動作を定義する
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Adapterからタップした位置のデータを取得する
                String str = (String) parent.getItemAtPosition(position);
                Toast.makeText(mActivity, str, Toast.LENGTH_SHORT).show();
            }
        });
        
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                listView.smoothScrollToPosition(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
