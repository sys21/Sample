/**
 * 
 */
package com.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author �C��
 * 
 */
public class SubActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		outputLog("��SubActivity#onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);
		final Button btn = (Button) findViewById(R.id.btn_move_activity);
		final SubActivity self = this;
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				final Intent intent = new Intent(self, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	@Override
	protected void onStart() {
		outputLog("��SubActivity#onStart()");
		super.onStart();
	}

	@Override
	protected void onResume() {
		outputLog("��SubActivity#onResume()");
		super.onResume();
	}

	@Override
	protected void onPause() {
		outputLog("��SubActivity#onPause()");
		super.onPause();
	}

	@Override
	protected void onStop() {
		outputLog("��SubActivity#onStop()");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		outputLog("��SubActivity#onDestroy()");
		super.onDestroy();
	}

	@Override
	protected void onRestart() {
		outputLog("��SubActivity#onRestart()");
		super.onRestart();
	}

	private void outputLog(final String mes) {
		Log.w(getResources().getString(R.string.tag_activity_sub), mes);
	}
}
