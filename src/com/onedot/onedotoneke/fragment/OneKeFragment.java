package com.onedot.onedotoneke.fragment;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.activity.ContactContentActivity;
import com.onedot.onedotoneke.adapter.OneKeAdapter;
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

/*
 * @author:ÄªÊ¤ÀÚ
 * @time£º2015.7.30
 * @class:OneKeFragment
 * @function:Ò»¿Ì
 */
public class OneKeFragment extends BaseFragment implements View.OnClickListener,OnItemClickListener {

	private ListView mListView;
	private OneKeAdapter mOneKeAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
		
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_oneke, null);
		mListView = (ListView)view.findViewById(R.id.list_oneke);
		mListView.setAdapter(new OneKeAdapter(getActivity()));
		mListView.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		startActivity(new Intent(getActivity(),ContactContentActivity.class));
	}

	@Override
	public void onClick(View arg0) {
		
	}
}
