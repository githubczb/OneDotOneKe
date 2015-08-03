package com.onedot.onedotoneke;

import android.content.Context;
import android.util.Log;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;

/*
 * @author:莫胜磊
 * @time：2015.7.31
 * @class:EMChatHelper
 * @function:环信的帮助类
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
		/**
		 * debugMode == true 时为打开，sdk 会在log里输入调试信息
		 * @param debugMode
		 * 在做代码混淆的时候需要设置成false
		 */
		EMChat.getInstance().setDebugMode(true);
	}
	
	/*
	 * 客户端注册，仅用在测试环境下
	 */
	public void register(final String name,final String password){
		new Thread(new Runnable() {
		    public void run() {
		      try {
		         // 调用sdk注册方法
		         EMChatManager.getInstance().createAccountOnServer(name, password);
		      } catch (final Exception e) {
		    	  
		   }
		}}).start();
	}
	
	/*
	 * 客户端登录
	 */
	public void login(final String name,final String password){
		
		EMChatManager.getInstance().login(name,password,new EMCallBack() {//回调
			@Override
			public void onSuccess() {
				EMGroupManager.getInstance().loadAllGroups();
				EMChatManager.getInstance().loadAllConversations();
				Log.d("main", "登陆聊天服务器成功！");
			}
		 
			@Override
			public void onProgress(int progress, String status) {
		 
			}
		 
			@Override
			public void onError(int code, String message) {
				Log.d("main", "登陆聊天服务器失败！");
			}
		});
	}
	
	public interface CallBack{
		
		public void onSuccess();
		
		public void onError();
		
	}
}
