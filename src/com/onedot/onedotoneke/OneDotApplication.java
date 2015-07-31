package com.onedot.onedotoneke;

import android.app.Application;
import android.content.Context;

/*
 * author:ÄªÊ¤ÀÚ
 * time:2015.7.31
 * class£ºOneDotApplication
 * function:Ò»µãÒ»¿Ì Appliction
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
