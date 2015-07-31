package com.onedot.onedotoneke;


import com.onedot.onedotoneke.activity.LoginActivity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

/*
 * @author:Īʤ��
 * @time:2015.7.31
 * @function:���Ѱ�����
 * @class:NotificationHelper
 */
public class NotificationHandler {

	private static NotificationHandler mNotificationHander;
	
	private NotificationHandler(){}
	
	private Context mContext;
	
	private NotificationManager mNotificationManager;
	
	public static synchronized NotificationHandler getInstance(){
		if(mNotificationHander == null){
			mNotificationHander = new NotificationHandler();
		}
		return mNotificationHander;
	}
	
	public void init(Context context) {
		this.mContext = context;
		mNotificationManager =
				(NotificationManager) mContext.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
	}
	
	/*
	 * ����֪ͨ
	 */
	public void setUpNormalNotification(){
		Intent resultIntent = new Intent(mContext, LoginActivity.class);
	    // Creating a artifical activity stack for the notification activity
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(mContext);
		stackBuilder.addParentStack(LoginActivity.class);
		stackBuilder.addNextIntent(resultIntent);
		// Pending intent to the notification manager
		PendingIntent resultPending = stackBuilder
		.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		// Building the notification
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext)
		.setSmallIcon(R.drawable.ic_launcher) // notification icon
		.setContentTitle("I'm a simple notification") // main title of the notification
		.setContentText("I'm the text of the simple notification") // notification text
		.setContentIntent(resultPending); // notification intent
		mNotificationManager.notify(10, mBuilder.build());
	}
}
