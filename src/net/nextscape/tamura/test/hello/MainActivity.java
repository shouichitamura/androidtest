package net.nextscape.tamura.test.hello;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	private Button buttonOK; // ボタン用変数(1)
	private Button buttonNG; // ボタン用変数(1)

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonOK = (Button) findViewById(R.id.buttonOK);
		buttonNG = (Button) findViewById(R.id.buttonNG);

		buttonOK.setOnClickListener(this);
		buttonNG.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		String title;
		String message;

		//
		// 処理：ダイアログを表示します。
		//
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(
				MainActivity.this);
		// 確認ボタンん処理を設定する
		alertDialog.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						setResult(RESULT_OK);
					}
				});
		switch (v.getId()) {
		case R.id.buttonOK:
			title = "OK";
			message = "OKが押下されました";
			break;
		case R.id.buttonNG:
			title = "NG";
			message = "NGが押下されました";
			break;
		default:
			title = "";
			message = "";
			break;
		}
		// タイトルを設定する
		alertDialog.setTitle(title);
		// メッセージ内容を設定する
		alertDialog.setMessage(message);
		alertDialog.create();
		alertDialog.show();
	}
}
