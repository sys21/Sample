/**
 * 
 */
package com.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author 修平
 * 
 */
public class MainFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View v = inflater.inflate(R.layout.fragment_main, container);
		// SubActivityへの遷移ボタン
		final Button btn = (Button) v.findViewById(R.id.btn_move_sub_activity);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// インテントのインスタンス生成
				final Intent intent = new Intent(getActivity(), SubActivity.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
			}
		});
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
