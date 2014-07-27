package com.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends ActionBarActivity {
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		outputLog("šMainActivity#onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction().add(R.id.container, new MainFragment()).commit();
		}
		// GIT‚Ìà–¾‚Ì‚½‚ß‚É’Ç‰Á
		System.out.println("GIT test");
	}

	@Override
	protected void onStart() {
		outputLog("šMainActivity#onStart()");
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// ‚±‚±‚©‚ç“Æ©À‘•‚ğs‚¤
		outputLog("šMainActivity#onResume()");
	}

	@Override
	protected void onPause() {
		outputLog("šMainActivity#onPause()");
		super.onPause();
	}

	@Override
	protected void onStop() {
		outputLog("šMainActivity#onStop()");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		outputLog("šMainActivity#onDestroy()");
		super.onDestroy();
	}

	@Override
	protected void onRestart() {
		outputLog("šMainActivity#onRestart()");
		super.onRestart();
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
			final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}
	}

	private void outputLog(final String mes) {
		Log.i(getResources().getString(R.string.tag_activity_main), mes);
	}
}
