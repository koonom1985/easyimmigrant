package com.yijia.easyimmigrant;

import com.yijia.easyimmigrant.act.SearchActivity;
import com.yijia.easyimmigrant.frags.ProductListFragment;
import com.yijia.easyimmigrant.frags.WelcomeFragment;
import com.yijia.easyimmigrant.utils.CustomWebViewClient;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.FindListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	public final static String EXTRA_MESSAGE = "com.yijia.easyimmigrant.MESSAGE";
	
	private WelcomeFragment welcomeFragment;
	private ProductListFragment productListFragment;
	
	long exitTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(getLocalClassName(), "onCreate is called");
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			welcomeFragment = new WelcomeFragment();
			productListFragment = new ProductListFragment();
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, productListFragment).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i(getLocalClassName(), "onCreateOptionsMenu is called");
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i(getLocalClassName(), "onOptionsItemSelected is called");
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		switch (id) {
			case R.id.action_search:
				Intent intent = new Intent(this, SearchActivity.class);
				intent.putExtra(EXTRA_MESSAGE, "search");
				startActivity(intent);
				return true;
			case R.id.action_for_sale:
				Log.i(getLocalClassName(), "onOptionsItemSelected::"+R.string.action_for_sale+" is called");
				Toast.makeText(getApplicationContext(),
						R.string.action_for_sale, Toast.LENGTH_SHORT).show();
				return true;
			case R.id.action_news:
				Log.i(getLocalClassName(), "onOptionsItemSelected::"+R.string.action_news+" is called");
				Toast.makeText(getApplicationContext(),
						R.string.action_news, Toast.LENGTH_SHORT).show();
				return true;
			case R.id.action_shopping_cart:
				Log.i(getLocalClassName(), "onOptionsItemSelected::"+R.string.action_shopping_cart+" is called");
				Toast.makeText(getApplicationContext(),
						R.string.action_shopping_cart, Toast.LENGTH_SHORT).show();
				return true;
			case R.id.action_my_account:
				Log.i(getLocalClassName(), "onOptionsItemSelected::"+R.string.action_my_account+" is called");
				Toast.makeText(getApplicationContext(),
						R.string.action_my_account, Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		Log.i(getLocalClassName(), "::onBackPressed::exitTime::" + exitTime);
		
		Log.i(getLocalClassName(), "::onKeyDown::event.getRepeatCount::" + 
			event.getRepeatCount());
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			if(welcomeFragment != null && welcomeFragment.getwebView() != null) {
				Log.i(getLocalClassName(), "::onKeyDown::canGoBack::" + 
					welcomeFragment.getwebView().canGoBack());
				if(welcomeFragment.getwebView().canGoBack()) {
					Log.i(getLocalClassName(), "::onKeyDown::webview going back");
					welcomeFragment.getwebView().goBack();
					return true;
				} else {
					exitPrograme();
				}
			}
			exitPrograme();
		}
		
		return true;
	}

	private void exitPrograme() {
		if( (System.currentTimeMillis() - exitTime) > 2000) {
			Toast toast = Toast.makeText(
				getApplicationContext(), R.string.exit_programe, 
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 250);
			toast.show();
			exitTime = System.currentTimeMillis();
		} else {
			finish();
			System.exit(0);
		}
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(getLocalClassName(), "onRestart is called");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.i(getLocalClassName(), "onResume is called");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.i(getLocalClassName(), "onPause is called");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.i(getLocalClassName(), "onStop is called");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(getLocalClassName(), "onDestroy is called");
	}

}
