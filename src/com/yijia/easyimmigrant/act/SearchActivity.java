package com.yijia.easyimmigrant.act;

import com.yijia.easyimmigrant.MainActivity;
import com.yijia.easyimmigrant.R;
import com.yijia.easyimmigrant.R.id;
import com.yijia.easyimmigrant.R.layout;
import com.yijia.easyimmigrant.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends ActionBarActivity {
	
	public static final String SEARCH_KEY = "search_key";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_search);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		EditText editText = (EditText)findViewById(R.id.search_string);
		
		final CharSequence searchStr = editText.getText();
		
		Button searchBtn = (Button)findViewById(R.id.search_button);
		
		searchBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(),
					searchStr, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
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
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		
		
		EditText editText = (EditText)findViewById(R.id.search_string);
		
		CharSequence searchStr = editText.getText();
		outState.putCharSequence(SEARCH_KEY, searchStr);
		
		Log.i(getLocalClassName(), "onSaveInstanceState::searchStr::"+searchStr);
		
		// Always call the superclass so it can save the view hierarchy state
		super.onSaveInstanceState(outState);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// Always call the superclass so it can restore the view hierarchy
		super.onRestoreInstanceState(savedInstanceState);
		
		EditText editText = (EditText)findViewById(R.id.search_string);
		CharSequence searchStr = savedInstanceState.getCharSequence(SEARCH_KEY);
		Log.i(getLocalClassName(), "onSaveInstanceState::searchStr::"+searchStr);
		editText.setText(searchStr);
	}
	
	@Override
	public boolean onNavigateUp() {
		Log.i(getLocalClassName(), getLocalClassName() + "::onNavigateUp is called");
		return super.onNavigateUp();
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Log.i(getLocalClassName(), getLocalClassName() + "::onBackPressed is called");
	}
}
