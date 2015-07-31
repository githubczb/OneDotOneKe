package com.onedot.onedotoneke;

import android.app.Application;
import android.content.Context;

/*
 * author:Īʤ��
 * time:2015.7.31
 * class��OneDotApplication
 * function:һ��һ�� Appliction
 */
public class OneDotApplication extends Application {

	private EMChatHelper mEmChatHelper;
	
	private Context mContext;
	
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
		mEmChatHelper = EMChatHelper.getInstance();
		mEmChatHelper.init(mContext);
	}
}
