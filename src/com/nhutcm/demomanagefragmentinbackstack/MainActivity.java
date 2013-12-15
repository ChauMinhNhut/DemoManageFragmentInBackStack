package com.nhutcm.demomanagefragmentinbackstack;

import com.nhutcm.demomanagefragmentinbackstack.withbackstack.ManageByBackStack;
import com.nhutcm.demomanagefragmentinbackstack.withoutbackstack.ManageBySavingInstance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Huong dan cach lam viec voi fragment de toi uu hoa viec load du lieu tu:
 * Internet, SQLite...
 * 
 * @author Chau Minh Nhut
 * @since 14/12/2013
 * @version 1.0
 * 
 */
public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
	}

	public void load_1(View v) {
		startActivity(new Intent(this, ManageBySavingInstance.class));
	}

	public void load_2(View v) {
		startActivity(new Intent(this, ManageByBackStack.class));
	}
}
