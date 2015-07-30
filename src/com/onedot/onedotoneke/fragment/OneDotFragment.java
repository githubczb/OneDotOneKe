package com.onedot.onedotoneke.fragment;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
public class OneDotFragment extends BaseFragment {

	private ListView mDotListView;
	
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
		return view;
	}
}
