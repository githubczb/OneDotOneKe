package com.onedot.onedotoneke;

import android.content.Context;

/*
 * @author:ÄªÊ¤ÀÚ
 * @time:2015.7.31
 * @function:ÐÅ¸ëÍÆËÍHandler
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
	
	public void init(Context context) {
		this.mContext = context;
	}
	
}
