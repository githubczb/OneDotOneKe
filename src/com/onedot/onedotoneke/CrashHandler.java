package com.onedot.onedotoneke;

import java.lang.Thread.UncaughtExceptionHandler;


import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;

/*
 * @author:莫胜磊
 * @time:2015.8.3
 * @function: 异常捕获类
 * @class:CrashHandler
 */
public class CrashHandler implements UncaughtExceptionHandler{

	private static CrashHandler mInstance;
	
	private Context mContext;
	@SuppressWarnings("unused")
	private Thread.UncaughtExceptionHandler mDefaultHandler;
	
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
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
	}
	
	/*
	 * @func:捕获异常
	 */
	@Override
	public void uncaughtException(Thread arg0, Throwable arg1) {
		AppManager.getInstance().exit();
		new Thread() {
			@Override
			public void run() {
				AlertDialog.Builder builder = new Builder(mContext);
				builder.setIcon(R.drawable.ic_launcher).setTitle(R.string.app_name)
						.setMessage("出了点小意外")
						.setPositiveButton("重新启动", new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Intent i = mContext.getPackageManager()
										.getLaunchIntentForPackage(
												mContext.getPackageName());
								i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								mContext.startActivity(i);
								AppManager.getInstance().exit();
							}
						}).setNegativeButton("取消", null).show();
			}
		}.start();
	}

}
