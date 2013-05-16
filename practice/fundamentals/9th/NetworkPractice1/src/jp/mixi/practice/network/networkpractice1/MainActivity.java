package jp.mixi.practice.network.networkpractice1;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View buttonGet = findViewById(R.id.buttonGet);
        buttonGet.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // http getの処理を書く
            	try {
					URL url = new URL("http://mixi.jp");
					HttpURLConnection connection = null;
					try {
						connection = (HttpURLConnection) url.openConnection();
						connection.connect();
						InputStream is = connection.getInputStream();
						
						StringBuilder src = new StringBuilder();
						while (true) {
							byte[] line = new byte[1024];
							int size = is.read(line);
							if (size <= 0)
								break;
							src.append(new String(line, "euc-jp"));
						}
						TextView tv = (TextView) findViewById(R.id.responce);
						tv.setText(src);
						
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						connection.disconnect();
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
            }
        });
        View buttonPost = findViewById(R.id.buttonPost);
        buttonPost.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // http postの処理を書く
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
