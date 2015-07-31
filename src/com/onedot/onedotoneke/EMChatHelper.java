package com.onedot.onedotoneke;

import android.content.Context;
import android.widget.Toast;

import com.easemob.EMError;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;

/*
 * author:莫胜磊
 * time：2015.7.31
 * class:EMChatHelper
 * function:环信的帮助类
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
}
