/**
 * 
 */
package net.nextscape.tamura.test.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.appcompat.R.string;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author tamura
 * 
 */
public class ButtonActivity extends Activity implements OnClickListener {
	public static final String INTENT_EXTRA_PARAM1 = ButtonActivity.class
			.getName() + ":INTENT_EXTRA_PARAM1";

	private Button button1; // ボタン用変数
	private Button button2; // ボタン用変数
	private TextView text1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button);

		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		text1 = (TextView) findViewById(R.id.textViewButton1);

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		text1.setText(getIntent().getStringExtra(INTENT_EXTRA_PARAM1));
	}

	@Override
	public void onClick(View v) {
		Log.d(this.getClass().getName() + ":clicked", v.getClass().getName());

		int result;
		switch (v.getId()) {
		case R.id.button1:
			result = ActivityCode.RESULT_BUTTON_1;
			break;
		case R.id.button2:
			result = ActivityCode.RESULT_BUTTON_2;
			break;
		default:
			result = 0;
			break;
		}
		setResult(result);
		finish();
	}
}
