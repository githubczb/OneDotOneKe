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

	private static final String TAG = "OneDotApplication";
	
	private static OneDotApplication instance;
	
	private EMChatHandler mEmChatHelper;
	
	private NotificationHandler mNotificationHelper;
	
	private Context mContext;
	
	private XinGePushHandler mXinGePushHandler;
	
    public static OneDotApplication sharedApplication() {
    	assert(instance != null);
    	return instance;
    	}
	    
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		mContext = getApplicationContext();
		mEmChatHelper = EMChatHandler.getInstance();
		mEmChatHelper.init(mContext);
		
		mNotificationHelper = NotificationHandler.getInstance();
		mNotificationHelper.init(mContext);
		
		mXinGePushHandler = XinGePushHandler.getInstance();
		mXinGePushHandler.init(mContext);
		
	}
}
