package com.onedot.onedotoneke.fragment;
/**
 * @author 帅
 * 2015.7.30
 */
import java.util.ArrayList;
import java.util.List;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.adapter.OneDotAdapter;
import com.onedot.onedotoneke.api.OneDotAPI;
import com.onedot.onedotoneke.api.OneDotAPI.OneDotInfo;
public class OneDotFragment extends BaseFragment {

	private ListView mDotListView;
	private OneDotAdapter oneDotAdapter;
	private List<String> oneDotInfo = new ArrayList<String>();
	private String[] a = {"小磊","江苏南京","24分钟前","我是信息"};
	
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
				
			}
		});
		for(int i = 0;i < a.length;i++) {
			oneDotInfo.add(a[i]);
		}
		oneDotAdapter = new OneDotAdapter(oneDotInfo,OneDotFragment.this.getActivity());
		mDotListView.setAdapter(oneDotAdapter);
//		getOneDot();
		return view;
	}
//	protected void getOneDot() {
//		
//	}
	
	
}
