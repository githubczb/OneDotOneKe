package com.onedot.onedotoneke.receiver;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.easemob.chat.EMMessage.ChatType;
import com.onedot.onedotoneke.NotificationHandler;
import com.onedot.onedotoneke.service.MessageHandlerService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/*
 * @author:莫胜磊
 * @time:2015.8.3
 * @class:NewMessageReceiver
 * @function: 新消息 接听器
 */
public class NewMessageReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		abortBroadcast();
		Toast.makeText(context, "receiver", Toast.LENGTH_LONG).show();
		NotificationHandler.getInstance().setUpNormalNotification();
		String msgId = intent.getStringExtra("msgid");
		String username = intent.getStringExtra("from");
		EMMessage message = EMChatManager.getInstance().getMessage(msgId);
		EMConversation	conversation = EMChatManager.getInstance().getConversation(username);
		if (message.getChatType() == ChatType.GroupChat) {
			username = message.getTo();
		}else if(message.getChatType() == ChatType.Chat){
			Toast.makeText(context, "chat", Toast.LENGTH_LONG).show();
		}else if(message.getChatType() == ChatType.ChatRoom){
			Toast.makeText(context, "chat_room", Toast.LENGTH_LONG).show();
		}
		
		Intent intent2 = new Intent(context,MessageHandlerService.class);
		context.startService(intent2);
	}

}
