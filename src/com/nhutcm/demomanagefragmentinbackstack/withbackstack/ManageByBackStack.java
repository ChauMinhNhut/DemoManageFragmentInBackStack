package com.nhutcm.demomanagefragmentinbackstack.withbackstack;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.nhutcm.demomanagefragmentinbackstack.R;

/**
 * Su dung fragment da add trong backstack de lay du lieu
 * 
 * @author Chau Minh Nhut
 * @since 14/12/2013
 * @version 1.0
 * 
 */
public class ManageByBackStack extends FragmentActivity {

	FragmentManager manager = getSupportFragmentManager();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_home);
	}

	void showFrag(Fragment fShow) {
		String tagName = fShow.getTag();
		int count = manager.getBackStackEntryCount();
		for (int i = count - 1; i >= 0; i--) {
			BackStackEntry entry = manager.getBackStackEntryAt(i);
			if (!entry.getName().equals(tagName)) {
				Fragment fHide = manager.findFragmentByTag(tagName);
				manager.beginTransaction().hide(fHide).commit();
			} else {
				manager.beginTransaction().show(fShow).commit();
				break;
			}
		}
	}

	void swapFragmentInBackStack(Fragment fShow) {

		List<Fragment> lst = new ArrayList<Fragment>();

		// B1 : DEM NHUNG FRAGMENT NAM TREN RA LIST
		String tagName = fShow.getTag();
		int count = manager.getBackStackEntryCount();
		for (int i = count - 1; i >= 0; i--) {
			BackStackEntry entry = manager.getBackStackEntryAt(i);
			Fragment f = manager.findFragmentByTag(entry.getName());
			lst.add(f);

			if (entry.getName().equals(tagName)) {
				break;
			}
		}

		// B2 : POP DEN CAI FRAGMENT CAN HIEN THI RA (KE CA NO)
		manager.popBackStack(tagName, FragmentManager.POP_BACK_STACK_INCLUSIVE);

		// B3 : CHUYEN FRAGMENT CAN SHOW VE DAU
		count = lst.size();

		Fragment f = lst.get(0);
		lst.set(0, lst.get(count - 1));
		lst.set(count - 1, f);

		// B4 : ADD CHUNG TRO LAI BACKSTACK

		for (int i = count - 1; i >= 0; i--) {

			Fragment fragment = lst.get(i);
			Fragment fNew;

			if (fragment.getTag().equals("f1")) {
				Fragment_1.setInstance((Fragment_1) fragment);
				fNew = Fragment_1.getInstance();

			} else if (fragment.getTag().equals("f2")) {
				Fragment_2.setInstance((Fragment_2) fragment);
				fNew = Fragment_2.getInstance();

			} else {
				Fragment_3.setInstance((Fragment_3) fragment);
				fNew = Fragment_3.getInstance();
			}

			FragmentTransaction tran = manager.beginTransaction();
			tran.replace(R.id.ln_content, fNew, fragment.getTag());
			tran.addToBackStack(fNew.getTag()).commit();
		}

	}

	public void loadFrag_1(View v) {
		Fragment fShow = manager.findFragmentByTag("f1");
		if (fShow != null) {
			swapFragmentInBackStack(fShow);
		} else {
			// LAY DATA FROM INTERNET
			String data = executeLongTask(1);

			Bundle bundle = new Bundle();
			bundle.putString("KEY_1", data);

			Fragment_1 f1 = Fragment_1.getInstance();
			f1.setArguments(bundle);

			FragmentTransaction tran_1 = manager.beginTransaction();
			tran_1.replace(R.id.ln_content, f1, "f1");
			tran_1.addToBackStack("f1");
			tran_1.commit();
		}
	}

	public void loadFrag_2(View v) {
		Fragment fShow = manager.findFragmentByTag("f2");
		if (fShow != null) {
			swapFragmentInBackStack(fShow);
		} else {
			// LAY DATA FROM INTERNET
			String data = executeLongTask(2);

			Bundle bundle = new Bundle();
			bundle.putString("KEY_2", data);

			Fragment_2 f2 = new Fragment_2();
			f2.setArguments(bundle);

			FragmentTransaction tran_2 = manager.beginTransaction();
			tran_2.replace(R.id.ln_content, f2, "f2");
			tran_2.addToBackStack("f2");
			tran_2.commit();
		}

	}

	public void loadFrag_3(View v) {
		Fragment fShow = manager.findFragmentByTag("f3");
		if (fShow != null) {
			swapFragmentInBackStack(fShow);
		} else {
			// LAY DATA FROM INTERNET
			String data = executeLongTask(3);

			Bundle bundle = new Bundle();
			bundle.putString("KEY_3", data);

			Fragment_3 f3 = new Fragment_3();
			f3.setArguments(bundle);

			FragmentTransaction tran_3 = manager.beginTransaction();
			tran_3.replace(R.id.ln_content, f3, "f3");
			tran_3.addToBackStack("f3");
			tran_3.commit();
		}
	}

	String executeLongTask(int requestCode) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Respone of request code " + requestCode;
	}

}
