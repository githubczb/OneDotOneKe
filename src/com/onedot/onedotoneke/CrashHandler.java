package com.onedot.onedotoneke;

import java.lang.Thread.UncaughtExceptionHandler;


import android.content.Context;
import android.content.Intent;

/*
 * @author:莫胜磊
 * @time:2015.8.3
 * @function: 全局捕获 异常
 * @class:CrashHandler
 */
public class CrashHandler implements UncaughtExceptionHandler{

	private static CrashHandler mInstance;
	
	private Context mContext;
	
	private CrashHandler(){}
	
	public static synchronized CrashHandler getInstance(){
		
		if(mInstance == null){
			mInstance = new CrashHandler();
		}
		return mInstance;
	}
	
	/*
	 * @func:初始化
	 * @param:context
	 */
	public void init(Context ctx) {
		mContext = ctx;
		Thread.setDefaultUncaughtExceptionHandler(this);
	}
	
	/*
	 * @func:捕获异常
	 */
	@Override
	public void uncaughtException(Thread arg0, Throwable arg1) {
		new Thread() {
			@Override
			public void run() {
				Intent i = mContext.getPackageManager()
						.getLaunchIntentForPackage(
								mContext.getPackageName());
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				mContext.startActivity(i);
				AppManager.getInstance().exit();
			}
		}.start();
	}

}
