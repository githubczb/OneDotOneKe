package com.onedot.onedotoneke;

import com.easemob.chat.EMChatManager;
import com.onedot.onedotoneke.receiver.NewMessageReceiver;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;

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
		
		//ֻ��ע���˹㲥���ܽ��յ�����Ϣ��Ŀǰ������Ϣ��������Ϣ�����߽�����Ϣ�Ĺ㲥��������ϢĿǰ�޷��������ڵ�¼�Ժ󣬽�����Ϣ�㲥��ִ��һ���õ����е�������Ϣ��
        msgReceiver = new NewMessageReceiver();
        IntentFilter intentFilter = new IntentFilter(EMChatManager.getInstance().getNewMessageBroadcastAction());
        intentFilter.setPriority(3);
        registerReceiver(msgReceiver, intentFilter);
	}
}
