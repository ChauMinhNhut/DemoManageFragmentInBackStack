package com.nhutcm.demomanagefragmentinbackstack.withbackstack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhutcm.demomanagefragmentinbackstack.R;

public class Fragment_1 extends Fragment {

	static Fragment_1 instance = null;
	static String data = "";

	public static Fragment_1 getInstance() {
		if (instance == null) {
			instance = new Fragment_1();
		}
		return instance;
	}

	public static void setInstance(Fragment_1 f) {
		instance = new Fragment_1();
		Bundle bundle = f.getArguments();
		if (bundle != null) {
			data = bundle.getString("KEY_1");
		}
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Bundle bundle = getArguments();
		if (bundle != null) {
			data = bundle.getString("KEY_1");
		}

		View v = inflater.inflate(R.layout.layout_fragment_1, container, false);
		TextView tv = (TextView) v.findViewById(R.id.textView1);
		tv.setText(data);
		return v;
	}

}
