package com.onedot.onedotoneke;

import com.easemob.chat.EMChatManager;
import com.onedot.onedotoneke.receiver.NewMessageReceiver;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;

/*
 * @author:莫胜磊
 * @time:2015.7.31
 * @class：OneDotApplication
 * @function:一点一刻 Appliction
 */
public class OneDotApplication extends Application {

	private static final String TAG = "OneDotApplication";
	
	private static OneDotApplication instance;
	
	private EMChatHandler mEmChatHelper;
	
	private NotificationHandler mNotificationHelper;
	
	private Context mContext;
	
	private XinGePushHandler mXinGePushHandler;
	
	private NewMessageReceiver msgReceiver;
	
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
		
		CrashHandler crashHandler = CrashHandler.getInstance();
		crashHandler.init(mContext);
		
		//只有注册了广播才能接收到新消息，目前离线消息，在线消息都是走接收消息的广播（离线消息目前无法监听，在登录以后，接收消息广播会执行一次拿到所有的离线消息）
        msgReceiver = new NewMessageReceiver();
        IntentFilter intentFilter = new IntentFilter(EMChatManager.getInstance().getNewMessageBroadcastAction());
        intentFilter.setPriority(3);
        registerReceiver(msgReceiver, intentFilter);
	}
}
