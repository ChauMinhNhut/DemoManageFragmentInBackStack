package com.nhutcm.demomanagefragmentinbackstack.withoutbackstack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhutcm.demomanagefragmentinbackstack.R;

public class Frag_2 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.layout_fragment_2, container, false);
	}
}
