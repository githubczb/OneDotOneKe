package com.onedot.onedotoneke;

import android.app.Application;
import android.content.Context;

/*
 * @author:Īʤ��
 * @time:2015.7.31
 * @class��OneDotApplication
 * @function:һ��һ�� Appliction
 */
public class OneDotApplication extends Application {

	private EMChatHandler mEmChatHelper;
	
	private NotificationHandler mNotificationHelper;
	
	private Context mContext;
	
	private XinGePushHandler mXinGePushHandler;
	
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
		mEmChatHelper = EMChatHandler.getInstance();
		mEmChatHelper.init(mContext);
		
		mNotificationHelper = NotificationHandler.getInstance();
		mNotificationHelper.init(mContext);
		
		mXinGePushHandler = XinGePushHandler.getInstance();
		mXinGePushHandler.init(mContext);
		
	}
}
