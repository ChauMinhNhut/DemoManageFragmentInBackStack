package com.nhutcm.demomanagefragmentinbackstack.withoutbackstack;

import java.io.Serializable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.nhutcm.demomanagefragmentinbackstack.R;

/**
 * Phuong phap luu instance cua tung fragment lai de tranh truong hop load lai
 * du lieu tu cac nguon: internet, SQLite...lam giam tinh toi uu
 * 
 * Khuyet diem: do khong luu vao backstack nen khi an nut Back thi se skill
 * activity chua cac fragment
 * 
 * @author Chau Minh Nhut
 * @since 14/12/2013
 * @version 1.0
 * 
 */
public class ManageBySavingInstance extends FragmentActivity {

	FragmentManager manager = getSupportFragmentManager();
	Fragment[] arr = new Fragment[3];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_home);
	}

	public void loadFrag_1(View v) {
		FragmentTransaction tran_1 = manager.beginTransaction();
		if (arr[0] == null) {
			// LAY DATA FROM INTERNET
			Data data = executeLongTask();

			Bundle bundle = new Bundle();
			bundle.putSerializable("KEY_1", data);

			Frag_1 f1 = new Frag_1();
			f1.setArguments(bundle);

			tran_1.replace(R.id.ln_content, f1, "f1");

			// SAVE 1 INSTANCE CUA FRAGMENT 1 LAI
			arr[0] = f1;
		} else {
			tran_1.replace(R.id.ln_content, arr[0], "f1");
		}
		tran_1.commit();
	}

	public void loadFrag_2(View v) {
		FragmentTransaction tran_2 = manager.beginTransaction();
		if (arr[1] == null) {

			// LAY DATA FROM INTERNET
			Data data = executeLongTask();

			Bundle bundle = new Bundle();
			bundle.putSerializable("KEY_2", data);

			Frag_2 f2 = new Frag_2();
			f2.setArguments(bundle);

			tran_2.replace(R.id.ln_content, f2, "f2");

			// SAVE 1 INSTANCE CUA FRAGMENT 2 LAI
			arr[1] = f2;
		} else {
			tran_2.replace(R.id.ln_content, arr[1], "f2");
		}

		tran_2.commit();

	}

	public void loadFrag_3(View v) {

		FragmentTransaction tran_3 = manager.beginTransaction();
		if (arr[2] == null) {

			// LAY DATA FROM INTERNET
			Data data = executeLongTask();

			Bundle bundle = new Bundle();
			bundle.putSerializable("KEY_3", data);

			Frag_3 f3 = new Frag_3();
			f3.setArguments(bundle);

			tran_3.replace(R.id.ln_content, f3, "f3");

			// SAVE 1 INSTANCE CUA FRAGMENT 3 LAI
			arr[2] = f3;
		} else {
			tran_3.replace(R.id.ln_content, arr[2], "f3");
		}
		tran_3.commit();

	}

	@SuppressWarnings("serial")
	class Data implements Serializable {
		Object values;
	}

	Data executeLongTask() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new Data();
	}

}
