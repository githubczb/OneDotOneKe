package com.onedot.onedotoneke;

import android.content.Context;

/*
 * @author:莫胜磊
 * @time:2015.7.31
 * @function: 信鸽推送处理类
 * @class:XinGePushHandler
 */
public class XinGePushHandler {

	
	private static XinGePushHandler mXinGePushHandler;
	
	private XinGePushHandler(){}
	
	private Context mContext;
	
	public static synchronized XinGePushHandler getInstance(){
		
		if(mXinGePushHandler == null){
			mXinGePushHandler = new XinGePushHandler();
		}
		return mXinGePushHandler;
	}
	
	/*
	 * 初始化
	 */
	public void init(Context context) {
		this.mContext = context;
	}
	
}
