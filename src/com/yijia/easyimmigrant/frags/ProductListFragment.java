package com.yijia.easyimmigrant.frags;

import java.util.ArrayList;
import java.util.List;

import com.yijia.easyimmigrant.R;
import com.yijia.easyimmigrant.utils.CustomWebViewClient;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductListFragment extends Fragment {
	
	private List<String> mDataSourceList = new ArrayList<String>();
	
	public ProductListFragment() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_product_list,
				container, false);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		for(int i=0, count=10; i<count; i++){
			mDataSourceList.add("留学资料--" + i + "    (购买:10元)");
		}
		
		ListView listView = (ListView) getActivity().findViewById(R.id.productlist);
		listView.setAdapter(
			new ArrayAdapter<String>(
				getActivity(), R.layout.product_list_item,
				mDataSourceList));
		
		listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getActivity().getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();				
			}
			
		});
	}
	
}
