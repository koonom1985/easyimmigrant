package com.yijia.easyimmigrant.frags;

import com.yijia.easyimmigrant.R;
import com.yijia.easyimmigrant.utils.CustomWebViewClient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WelcomeFragment extends Fragment {
	
//	public static final String HOME_URL = "http://m.baidu.com";
	public static final String HOME_URL = "http://192.241.176.62:8080";

	WebView webView = null;
	
	public WelcomeFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_welcome,
				container, false);
		webView = (WebView) rootView.findViewById(R.id.webhome);
		webView.setWebViewClient(new CustomWebViewClient());
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(HOME_URL);
		return rootView;
	}

	public WebView getwebView() {
		return webView;
	}
	
}
