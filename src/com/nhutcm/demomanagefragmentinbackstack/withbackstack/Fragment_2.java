package com.nhutcm.demomanagefragmentinbackstack.withbackstack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhutcm.demomanagefragmentinbackstack.R;

public class Fragment_2 extends Fragment {

	static Fragment_2 instance = null;
	static String data = "";

	public static Fragment_2 getInstance() {
		if (instance == null) {
			instance = new Fragment_2();
		}
		return instance;
	}

	public static void setInstance(Fragment_2 f) {
		instance = new Fragment_2();
		Bundle bundle = f.getArguments();
		if(bundle!=null){
			data = bundle.getString("KEY_2");
		}
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		Bundle bundle = getArguments();
		if(bundle!=null){
			data = bundle.getString("KEY_2");
		}
		
		View v = inflater.inflate(R.layout.layout_fragment_2, container, false);
		TextView tv = (TextView)v.findViewById(R.id.textView2);
		tv.setText(data);
		return v;
	}
}
