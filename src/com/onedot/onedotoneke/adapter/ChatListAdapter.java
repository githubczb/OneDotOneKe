package com.onedot.onedotoneke.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseAdapter;
/*
 * @author:Īʤ��
 * @time:2015.7.31
 * @function:�����б��Adapter
 * @class:ChatListAdapter
 */
public class ChatListAdapter extends BaseAdapter {

	private Context mContext;
	
	public ChatListAdapter(Context context) {
		this.mContext = context;
	}
	
	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		View view = LayoutInflater.from(mContext).inflate(R.layout.layout_chat_list_item, null,false);
		return view;
	}

}
