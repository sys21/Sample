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
 * @author �C��
 * 
 */
public class MainFragment extends Fragment {
	private TextView countDownView;
	private MyCountDownTimer myCountDownTimer;

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
		final View fragmentView = inflater.inflate(R.layout.fragment_main, container);
		// SubActivity�ւ̑J�ڃ{�^��
		final Button btn = (Button) fragmentView.findViewById(R.id.btn_move_sub_activity);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				// �C���e���g�̃C���X�^���X����
				final Intent intent = new Intent(getActivity(), SubActivity.class);
				// ����ʂ̃A�N�e�B�r�e�B�N��
				startActivity(intent);
			}
		});
		// EditText
		final EditText editText = (EditText) fragmentView.findViewById(R.id.edit_text);
		editText.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(final View v, final boolean hasFocus) {
				if (hasFocus) {
					// �t�H�[�J�X��
				} else {
					// �t�H�[�J�X�A�E�g��
					final TextView textView = (TextView) fragmentView.findViewById(R.id.label_edit_text);
					textView.setText(((EditText) v).getText().toString());
				}
			}
		});
		// �_�C�A���O�\���{�^��
		final Button btnDialog = (Button) fragmentView.findViewById(R.id.btn_dialog_open);
		btnDialog.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View v) {
				showTimePickerDialog(fragmentView);
			}
		});
		// �J�E���g�_�E��View
		countDownView = (TextView) fragmentView.findViewById(R.id.label_count_down);
		myCountDownTimer = new MyCountDownTimer(10000l, 1000l);
		myCountDownTimer.start();
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	/**
	 * �^�C���s�b�J�[�_�C�A���O�\��
	 */
	private void showTimePickerDialog(final View fragmentView) {
		// ���ݎ������擾
		final Calendar calendar = Calendar.getInstance();
		final int hour = calendar.get(Calendar.HOUR_OF_DAY);
		final int minute = calendar.get(Calendar.MINUTE);
		// ���ԑI���_�C�A���O�̐���
		final TimePickerDialog timepick = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
			@Override
			public void onTimeSet(final TimePicker view, final int hourOfDay, final int minute) {
				// �ݒ� �{�^���N���b�N���̏���
				final TextView textView = (TextView) fragmentView.findViewById(R.id.label_dialog_text);
				textView.setText(String.format("%02d : %02d", hourOfDay, minute));
			}
		}, hour, minute, true);
		// �\��
		timepick.show();
	}

	/**
	 * �J�E���g�_�E���^�C�}�[
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
