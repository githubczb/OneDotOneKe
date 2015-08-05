package com.onedot.onedotoneke;

import com.easemob.chat.EMChatManager;
import com.onedot.onedotoneke.receiver.NewMessageReceiver;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;

/*
 * @author:莫胜磊
 * @time:2015.7.31
 * @class OneDotApplication
 * @function:应用程序 Application
 */
public class App extends Application {

	private static App instance;
	
	private EMChatHandler mEmChatHelper;
	
	private NotificationHandler mNotificationHelper;
	
	private Context mContext;
	
	private XinGePushHandler mXinGePushHandler;
	
	private NewMessageReceiver msgReceiver;
	
	/*
	 * 获取实例
	 */
    public synchronized static App sharedApplication() {
    	assert(instance != null);
    	return instance;
    	}
	/*
	 * 获取context
	 */
    public Context getContext(){
    	return mContext;
    }
    
    /*
     * (non-Javadoc)
     * @see android.app.Application#onCreate()
     */
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
		
        msgReceiver = new NewMessageReceiver();
        IntentFilter intentFilter = new IntentFilter(EMChatManager.getInstance().getNewMessageBroadcastAction());
        intentFilter.setPriority(3);
        registerReceiver(msgReceiver, intentFilter);
	}

	/*
	 * 获取app 缓存目录
	 */
	public static String getAppCacheDir() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED))
			return Environment.getExternalStorageDirectory().toString()
					+ "/Health/Cache";
		else
			return "/System/com.juns.Walk/Walk/Cache";
	}
}
