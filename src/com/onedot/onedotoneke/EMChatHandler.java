package com.onedot.onedotoneke;

import android.content.Context;
import android.util.Log;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;

/*
 * @author:Īʤ��
 * @time��2015.7.31
 * @class:EMChatHelper
 * @function:���ŵİ�����
 */
public class EMChatHandler {
	
	private static EMChatHandler mEmChatHandler;
	
	private EMChatHandler(){}
	
	private Context mContext;
	
	public static synchronized EMChatHandler getInstance(){
		
		if(mEmChatHandler == null){
			mEmChatHandler = new EMChatHandler();
		}
		return mEmChatHandler;
	}
	
	/*
	 * ��ʼ��
	 */
	public void init(Context context) {
		
		mContext = context;
		EMChat.getInstance().init(mContext);
		/**
		 * debugMode == true ʱΪ�򿪣�sdk ����log�����������Ϣ
		 * @param debugMode
		 * �������������ʱ����Ҫ���ó�false
		 */
		EMChat.getInstance().setDebugMode(true);
	}
	
	/*
	 * �ͻ���ע�ᣬ�����ڲ��Ի�����
	 */
	public void register(final String name,final String password){
		new Thread(new Runnable() {
		    public void run() {
		      try {
		         // ����sdkע�᷽��
		         EMChatManager.getInstance().createAccountOnServer(name, password);
		      } catch (final Exception e) {
		    	  
		   }
		}}).start();
	}
	
	/*
	 * �ͻ��˵�¼
	 */
	public void login(final String name,final String password){
		
		EMChatManager.getInstance().login(name,password,new EMCallBack() {//�ص�
			@Override
			public void onSuccess() {
				EMGroupManager.getInstance().loadAllGroups();
				EMChatManager.getInstance().loadAllConversations();
				Log.d("main", "��½����������ɹ���");
			}
		 
			@Override
			public void onProgress(int progress, String status) {
		 
			}
		 
			@Override
			public void onError(int code, String message) {
				Log.d("main", "��½���������ʧ�ܣ�");
			}
		});
	}
	
	public interface CallBack{
		
		public void onSuccess();
		
		public void onError();
		
	}
}
