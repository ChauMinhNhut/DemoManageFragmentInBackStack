package com.nhutcm.demomanagefragmentinbackstack.withoutbackstack;

import com.nhutcm.demomanagefragmentinbackstack.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag_1 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.layout_fragment_1, container, false);
	}
}
