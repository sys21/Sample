/**
 * 
 */
package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author �C��
 * 
 */
public class MainFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_main, container);
		// SubActivity�ւ̑J�ڃ{�^��
		final Button btn = (Button) view.findViewById(R.id.btn_move_sub_activity);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// �C���e���g�̃C���X�^���X����
				final Intent intent = new Intent(getActivity(), SubActivity.class);
				// ����ʂ̃A�N�e�B�r�e�B�N��
				startActivity(intent);
			}
		});
		// EditText
		final EditText editText = (EditText) view.findViewById(R.id.edit_text);
		editText.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(final View v, final boolean hasFocus) {
				if (hasFocus) {
					// �t�H�[�J�X��
				} else {
					// �t�H�[�J�X�A�E�g��
					final TextView textView = (TextView) view.findViewById(R.id.edit_text_label);
					textView.setText(((EditText) v).getText().toString());
				}
			}
		});
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
