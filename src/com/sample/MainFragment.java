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
 * @author 修平
 * 
 */
public class MainFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_main, container);
		// SubActivityへの遷移ボタン
		final Button btn = (Button) view.findViewById(R.id.btn_move_sub_activity);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// インテントのインスタンス生成
				final Intent intent = new Intent(getActivity(), SubActivity.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
			}
		});
		// EditText
		final EditText editText = (EditText) view.findViewById(R.id.edit_text);
		editText.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(final View v, final boolean hasFocus) {
				if (hasFocus) {
					// フォーカス時
				} else {
					// フォーカスアウト時
					final TextView textView = (TextView) view.findViewById(R.id.edit_text_label);
					textView.setText(((EditText) v).getText().toString());
				}
			}
		});
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
