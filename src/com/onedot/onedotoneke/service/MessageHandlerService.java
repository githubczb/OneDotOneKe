package com.onedot.onedotoneke.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/*
 * @author:莫胜磊
 * @time:2015.8.5
 * @class:MessageHandlerService
 * @function:处理消息的Service
 */
public class MessageHandlerService extends IntentService {

	 public MessageHandlerService(){
		 super("MessageHandlerService");
	 }

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		Toast.makeText(this, "onStartCommand", Toast.LENGTH_LONG).show();
		Intent intent2 = new Intent("intent to receive message");
		sendBroadcast(intent2);
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	protected void onHandleIntent(Intent arg0) {
		
		Toast.makeText(this, "service", Toast.LENGTH_LONG).show();
		Toast.makeText(this, "send broad cast", Toast.LENGTH_LONG).show();
		Intent intent = new Intent("intent to receive message");
		sendBroadcast(intent);
	}

}
