package com.pasanlive.android.utility.animator;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private TextView textView1;
		private TextView textView2;
		private TextView textView3;
		private TextView textView4;
		private Button button1;
		private Button button2;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			
			textView1 = (TextView) rootView.findViewById(R.id.textView1);
			textView2 = (TextView) rootView.findViewById(R.id.textView2);
			textView3 = (TextView) rootView.findViewById(R.id.textView3);
			textView4 = (TextView) rootView.findViewById(R.id.textView4);
			button1 = (Button) rootView.findViewById(R.id.button1);
			button2 = (Button) rootView.findViewById(R.id.button2);			
			
			animateLayout();
			
			return rootView;
		}
		
		private void animateLayout() {
			List<View> viewList = new ArrayList<View>();
			viewList.add(textView1);
			viewList.add(textView2);
			viewList.add(textView3);
			viewList.add(textView4);
			viewList.add(button1);
			viewList.add(button2);
			
			Animator animator = new Animator(getActivity(), viewList, R.anim.fade_in);
			animator.start();
		}
	}

}
