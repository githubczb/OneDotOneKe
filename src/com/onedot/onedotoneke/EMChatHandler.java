package com.onedot.onedotoneke;

import android.content.Context;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;

/*
 * @author:莫胜磊
 * @time��2015.7.31
 * @class:EMChatHelper
 * @function:环信帮助类
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
	 * 初始化
	 */
	public void init(Context context) {
		
		mContext = context;
		EMChat.getInstance().init(mContext);
		EMChat.getInstance().setDebugMode(true);
	}
	
	/*
	 * 环信注册
	 */
	public void register(final String name,final String password){
		new Thread(new Runnable() {
		    public void run() {
		      try {
		         EMChatManager.getInstance().createAccountOnServer(name, password);
		      } catch (final Exception e) {
		    	  
		   }
		}}).start();
	}
	
	/*
	 * 环信登录
	 */
	public void login(final String name,final String password){
		
		EMChatManager.getInstance().login(name,password,new EMCallBack() {//�ص�
			@Override
			public void onSuccess() {
				EMGroupManager.getInstance().loadAllGroups();
				EMChatManager.getInstance().loadAllConversations();
			}
		 
			@Override
			public void onProgress(int progress, String status) {
		 
			}
		 
			@Override
			public void onError(int code, String message) {
			}
		});
	}
	
	public interface CallBack{
		
		public void onSuccess();
		
		public void onError();
		
	}
}
