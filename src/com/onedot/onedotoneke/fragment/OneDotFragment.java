package com.onedot.onedotoneke.fragment;
/**
 * @author ˧
 * 2015.7.30
 */

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.onedot.onedotoneke.activity.OneDotDetailActivity;
import com.onedot.onedotoneke.adapter.OneDotAdapter;
public class OneDotFragment extends BaseFragment {

	private ListView mDotListView;
	private OneDotAdapter oneDotAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_onedot, null);
		mDotListView = (ListView)view.findViewById(R.id.dot_list_view);
		mDotListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				startActivity(new Intent(getActivity(),
						OneDotDetailActivity.class));
			}
		});
		oneDotAdapter = new OneDotAdapter(getActivity());
		mDotListView.setAdapter(oneDotAdapter);
		return view;
	}
	
	
}
