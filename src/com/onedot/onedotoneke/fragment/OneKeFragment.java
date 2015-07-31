package com.onedot.onedotoneke.fragment;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 * @author:ÄªÊ¤ÀÚ
 * @time£º2015.7.30
 * @class:OneKeFragment
 * @function:Ò»¿Ì
 */
public class OneKeFragment extends BaseFragment {

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
		return view;
	}
}
