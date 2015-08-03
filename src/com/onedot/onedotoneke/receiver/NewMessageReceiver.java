package com.onedot.onedotoneke.receiver;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.easemob.chat.EMMessage.ChatType;
import com.onedot.onedotoneke.NotificationHandler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/*
 * @author:Īʤ��
 * @time:2015.8.3
 * @class:NewMessageReceiver
 * @function: ������Ϣ�Ľ�����
 */
public class NewMessageReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		// ע���㲥
		abortBroadcast();
 
		Log.d("ee","receive");
		Toast.makeText(context, "receiver", Toast.LENGTH_LONG).show();
		NotificationHandler.getInstance().setUpNormalNotification();
		// ��Ϣid��ÿ����Ϣ��������Ψһ��һ��id��Ŀǰ��SDK���ɣ�
		String msgId = intent.getStringExtra("msgid");
		//���ͷ�
		String username = intent.getStringExtra("from");
		// �յ�����㲥��ʱ��message�Ѿ���db���ڴ����ˣ�����ͨ��id��ȡmesage����
		EMMessage message = EMChatManager.getInstance().getMessage(msgId);
		EMConversation	conversation = EMChatManager.getInstance().getConversation(username);
		// �����Ⱥ����Ϣ����ȡ��group id
		if (message.getChatType() == ChatType.GroupChat) {
			username = message.getTo();
		}
		if (!username.equals(username)) {
			// ��Ϣ���Ƿ�����ǰ�Ự��return
			return;
		}
	}

}
