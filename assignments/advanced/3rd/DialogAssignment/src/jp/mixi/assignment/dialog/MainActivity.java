
package jp.mixi.assignment.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_assignmentdialog).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showAssignmentDialog();
            }
        });
    }

    private void showAssignmentDialog() {
        // TODO:ダイアログを表示する処理を実装してください
    	DialogFragment myDialogFragment = new AssignmentDialogFragment();
    	myDialogFragment.show(getSupportFragmentManager(), "aaa");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // TODO:独自DialogFragmentを実装してください
    // TODO:コンテンツ領域にはEditTextを配置した独自レイアウトを使用してください。また、そのためのレイアウトxmlを作成してください。
    public static class AssignmentDialogFragment extends DialogFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // 独自のレイアウトをコンテンツ領域表示する場合、ここでViewをinfrateして返却する
            return inflater.inflate(R.layout.edit_content, container, false);
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setMessage("ooo")
                    // OKボタン
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getActivity(), "Positive", Toast.LENGTH_SHORT).show();
                        }
                    })
                    // Cancelボタン
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getActivity(), "Negative", Toast.LENGTH_SHORT).show();
                        }
                    });
            // Dialogを作成して返却
            return builder.create();
        }
    }
}
