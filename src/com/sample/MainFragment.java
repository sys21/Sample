/**
 * 
 */
package com.sample;

import java.util.Calendar;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * @author 修平
 * 
 */
public class MainFragment extends Fragment {
	private TextView countDownView;
	private MyCountDownTimer myCountDownTimer;

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		final View fragmentView = inflater.inflate(R.layout.fragment_main, container);
		// SubActivityへの遷移ボタン
		final Button btn = (Button) fragmentView.findViewById(R.id.btn_move_sub_activity);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				// インテントのインスタンス生成
				final Intent intent = new Intent(getActivity(), SubActivity.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
			}
		});
		// EditText
		final EditText editText = (EditText) fragmentView.findViewById(R.id.edit_text);
		editText.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(final View v, final boolean hasFocus) {
				if (hasFocus) {
					// フォーカス時
				} else {
					// フォーカスアウト時
					final TextView textView = (TextView) fragmentView.findViewById(R.id.label_edit_text);
					textView.setText(((EditText) v).getText().toString());
				}
			}
		});
		// ダイアログ表示ボタン
		final Button btnDialog = (Button) fragmentView.findViewById(R.id.btn_dialog_open);
		btnDialog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				showTimePickerDialog(fragmentView);
			}
		});
		// カウントダウンView
		countDownView = (TextView) fragmentView.findViewById(R.id.label_count_down);
		myCountDownTimer = new MyCountDownTimer(10000l, 1000l);
		myCountDownTimer.start();
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	/**
	 * タイムピッカーダイアログ表示
	 */
	private void showTimePickerDialog(final View fragmentView) {
		// 現在時刻を取得
		final Calendar calendar = Calendar.getInstance();
		final int hour = calendar.get(Calendar.HOUR_OF_DAY);
		final int minute = calendar.get(Calendar.MINUTE);
		// 時間選択ダイアログの生成
		final TimePickerDialog timepick = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(final TimePicker view, final int hourOfDay, final int minute) {
				// 設定 ボタンクリック時の処理
				final TextView textView = (TextView) fragmentView.findViewById(R.id.label_dialog_text);
				textView.setText(String.format("%02d : %02d", hourOfDay, minute));
			}
		}, hour, minute, true);
		// 表示
		timepick.show();
	}

	/**
	 * カウントダウンタイマー
	 */
	private class MyCountDownTimer extends CountDownTimer {
		MyCountDownTimer(final long millisInFuture, final long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onTick(final long millisUntilFinished) {
			countDownView.setText(String.format("%s:%s", Long.toString(millisUntilFinished / 1000 / 60),
					Long.toString(millisUntilFinished / 1000 % 60)));
		}

		@Override
		public void onFinish() {
			countDownView.setText(getResources().getString(R.string.time_up));
		}
	}
}
