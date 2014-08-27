package net.nextscape.tamura.test.hello;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	private Button buttonOK; // ボタン用変数
	private Button buttonNG; // ボタン用変数
	private TextView text1;

	AlertDialog.Builder alertDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonOK = (Button) findViewById(R.id.buttonOK);
		buttonNG = (Button) findViewById(R.id.buttonNG);
		text1 = (TextView) findViewById(R.id.textView1);

		buttonOK.setOnClickListener(this);
		buttonNG.setOnClickListener(this);

		alertDialog = new AlertDialog.Builder(MainActivity.this);
		// 確認ボタンん処理を設定する
		alertDialog.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						setResult(RESULT_OK);
					}
				});
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
		int request = 0;

		Log.d(this.getClass().getName() + ":clicked", v.getClass().getName());

		switch (v.getId()) {
		case R.id.buttonOK:
			title = "OK";
			message = "OKが押下されました";
			request = ActivityCode.REQUEST_MAIN_OK;
			break;
		case R.id.buttonNG:
			title = "NG";
			message = "NGが押下されました";
			request = ActivityCode.REQUEST_MAIN_NG;
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

		Intent intent = new Intent(this, ButtonActivity.class);
		intent.putExtra(ButtonActivity.INTENT_EXTRA_PARAM1, title);
		startActivityForResult(intent, request);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		Log.d(this.getClass().getName() + ":requestCode",
				String.valueOf(requestCode));
		Log.d(this.getClass().getName() + ":resultCode",
				String.valueOf(resultCode));

		String text = "";
		if (requestCode == ActivityCode.REQUEST_MAIN_OK
				|| requestCode == ActivityCode.REQUEST_MAIN_NG) {
			switch (resultCode) {
			case ActivityCode.RESULT_BUTTON_1:
				text = "No1 is pressed.";
				break;
			case ActivityCode.RESULT_BUTTON_2:
				text = "No2 is pressed.";
				break;
			default:
				text = "Nothing!!";
				break;
			}
			text1.setText(text);
		}
	}
}
