package com.nhutcm.demomanagefragmentinbackstack.withbackstack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nhutcm.demomanagefragmentinbackstack.R;

public class Fragment_3 extends Fragment {
	
	static Fragment_3 instance = null;
	static String data = "";

	public static Fragment_3 getInstance() {
		if (instance == null) {
			instance = new Fragment_3();
		}
		return instance;
	}

	public static void setInstance(Fragment_3 f) {
		instance = new Fragment_3();
		Bundle bundle = f.getArguments();
		if(bundle!=null){
			data = bundle.getString("KEY_3");
		}
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		Bundle bundle = getArguments();
		if(bundle!=null){
			data = bundle.getString("KEY_3");
		}
		
		View v = inflater.inflate(R.layout.layout_fragment_3, container, false);
		TextView tv = (TextView)v.findViewById(R.id.textView3);
		tv.setText(data);
		return v;
	}
}
