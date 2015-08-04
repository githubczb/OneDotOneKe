package com.onedot.onedotoneke.activity;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.easemob.chat.EMMessage.ChatType;
import com.onedot.onedotoneke.NotificationHandler;
import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;
import com.onedot.onedotoneke.fragment.ChatFragment;
import com.onedot.onedotoneke.fragment.CircleFragment;
import com.onedot.onedotoneke.fragment.OneDotFragment;
import com.onedot.onedotoneke.fragment.OneKeFragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/*
 * @author:莫胜磊
 * @class��MainActivity
 * @time:2015/7/29
 * @function: 主界面
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

	private OneDotFragment mOneDotFragment;
	private OneKeFragment mOneKeFragment;
	private CircleFragment mCircleFragment;
	private ChatFragment mChatFragment;
	
	private View mtab1,mtab2,mtab3,mtab4;
	
	private TextView mTitleText;
	private int mCurTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initTabs();
        mOneDotFragment = new OneDotFragment();
        mOneKeFragment = new OneKeFragment();
        mCircleFragment = new CircleFragment();
        mChatFragment = new ChatFragment();
        
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, mOneDotFragment);
        ft.commit();
        
    }

	private void initTabs() {
		
		mtab1 = findViewById(R.id.tab1);
		mtab2 = findViewById(R.id.tab2);
		mtab3 = findViewById(R.id.tab3);
		mtab4 = findViewById(R.id.tab4);
		
		mtab1.setOnClickListener(this);
		mtab2.setOnClickListener(this);
		mtab3.setOnClickListener(this);
		mtab4.setOnClickListener(this);
		
		mTitleText = (TextView)findViewById(R.id.title_text);
		mTitleText.setText(getString(R.string.onedot));
		
		mCurTab = 1;
	}

	public View getAddView(){
		
		return findViewById(R.id.add);
	}
	@Override
	public void onClick(View view) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		switch (view.getId()) {
		case R.id.tab1:
			if(mCurTab == 1)break;
	        ft.replace(R.id.container, mOneDotFragment);
	        ft.commit();
	        mTitleText.setText(getString(R.string.onedot));
	        mCurTab = 1;
			break;
		case R.id.tab2:
			if(mCurTab == 2)break;
	        ft.replace(R.id.container, mOneKeFragment);
	        ft.commit();
	        mTitleText.setText(getString(R.string.oneke));
	        mCurTab = 2;
			break;
		case R.id.tab3:
			if(mCurTab == 3)break;
	        ft.replace(R.id.container, mChatFragment);
	        ft.commit();
	        mTitleText.setText(getString(R.string.chat));
	        mCurTab = 3;
			break;
		case R.id.tab4:
			if(mCurTab == 4)break;
	        ft.replace(R.id.container, mCircleFragment);
	        ft.commit();
	        mTitleText.setText(getString(R.string.circle));
	        mCurTab = 4;
			break;
		default:
			break;
		}
	}

}
