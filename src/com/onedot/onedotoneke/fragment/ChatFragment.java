package com.onedot.onedotoneke.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.activity.AddFriendActivity;
import com.onedot.onedotoneke.activity.ChatContentActivity;
import com.onedot.onedotoneke.activity.FriendsActivity;
import com.onedot.onedotoneke.activity.MainActivity;
import com.onedot.onedotoneke.adapter.ChatListAdapter;
import com.onedot.onedotoneke.base.BaseFragment;

/*
 * @author:ÄªÊ¤ÀÚ
 * @time£º2015.7.30
 * @class£ºChatFragment
 * @function£ºÁÄÌì½çÃæ
 */
public class ChatFragment extends BaseFragment implements View.OnClickListener,OnItemClickListener{

	private View mAddView;
	private MainActivity mMainActivity;
	
	private ListView mListView;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mMainActivity = (MainActivity)activity;
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mAddView.setVisibility(View.GONE);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View view = inflater.inflate(R.layout.fragment_chat, null);
		mListView = (ListView)view.findViewById(R.id.list_chat);
		
		mListView.setAdapter(new ChatListAdapter(getActivity()));
		mListView.setOnItemClickListener(this);
		
		mAddView = mMainActivity.getAddView();
		mAddView.setVisibility(View.VISIBLE);
		mAddView.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.add:
			startActivity(new Intent(getActivity(),AddFriendActivity.class));
			break;
		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		startActivity(new Intent(getActivity(),ChatContentActivity.class));
	}
}
