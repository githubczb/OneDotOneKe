package com.onedot.onedotoneke;

import android.content.Context;
import android.widget.Toast;

import com.easemob.EMError;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;

/*
 * author:Īʤ��
 * time��2015.7.31
 * class:EMChatHelper
 * function:���ŵİ�����
 */
public class EMChatHelper {
	
	private static EMChatHelper mEmChatHelper;
	
	private EMChatHelper(){}
	
	private Context mContext;
	
	public static synchronized EMChatHelper getInstance(){
		
		if(mEmChatHelper == null){
			mEmChatHelper = new EMChatHelper();
		}
		return mEmChatHelper;
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
}
