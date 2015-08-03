package com.onedot.onedotoneke.activity;

import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMMessage;
import com.easemob.chat.EMMessage.ChatType;
import com.onedot.onedotoneke.NotificationHandler;
import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;
import com.onedot.onedotoneke.fragment.ChatFragment;
import com.onedot.onedotoneke.fragment.CircleFragment;
import com.onedot.onedotoneke.fragment.OneDotFragment;
import com.onedot.onedotoneke.fragment.OneKeFragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/*
 * @author:莫胜磊
 * @class：MainActivity
 * @time:2015/7/29
 * @function:主界面MainActivity
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

	private OneDotFragment mOneDotFragment;
	private OneKeFragment mOneKeFragment;
	private CircleFragment mCircleFragment;
	private ChatFragment mChatFragment;
	
	private View mtab1,mtab2,mtab3,mtab4;
	
	private TextView mTitleText;
	private int mCurTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initTabs();
        mOneDotFragment = new OneDotFragment();
        mOneKeFragment = new OneKeFragment();
        mCircleFragment = new CircleFragment();
        mChatFragment = new ChatFragment();
        
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, mOneDotFragment);
        ft.commit();
        
      //只有注册了广播才能接收到新消息，目前离线消息，在线消息都是走接收消息的广播（离线消息目前无法监听，在登录以后，接收消息广播会执行一次拿到所有的离线消息）
        NewMessageBroadcastReceiver msgReceiver = new NewMessageBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(EMChatManager.getInstance().getNewMessageBroadcastAction());
        intentFilter.setPriority(3);
        registerReceiver(msgReceiver, intentFilter);
    }

    private class NewMessageBroadcastReceiver extends BroadcastReceiver {
    	@Override
    	public void onReceive(Context context, Intent intent) {
    	    // 注销广播
    		abortBroadcast();
     
    		Log.d("ee","receive");
    		
    		NotificationHandler.getInstance().setUpNormalNotification();
    		// 消息id（每条消息都会生成唯一的一个id，目前是SDK生成）
    		String msgId = intent.getStringExtra("msgid");
    		//发送方
    		String username = intent.getStringExtra("from");
    		// 收到这个广播的时候，message已经在db和内存里了，可以通过id获取mesage对象
    		EMMessage message = EMChatManager.getInstance().getMessage(msgId);
    		EMConversation	conversation = EMChatManager.getInstance().getConversation(username);
    		// 如果是群聊消息，获取到group id
    		if (message.getChatType() == ChatType.GroupChat) {
    			username = message.getTo();
    		}
    		if (!username.equals(username)) {
    			// 消息不是发给当前会话，return
    			return;
    		}
    	}
    }

	private void initTabs() {
		
		mtab1 = findViewById(R.id.tab1);
		mtab2 = findViewById(R.id.tab2);
		mtab3 = findViewById(R.id.tab3);
		mtab4 = findViewById(R.id.tab4);
		
		mtab1.setOnClickListener(this);
		mtab2.setOnClickListener(this);
		mtab3.setOnClickListener(this);
		mtab4.setOnClickListener(this);
		
		mTitleText = (TextView)findViewById(R.id.title_text);
		mTitleText.setText("一点");
		
		mCurTab = 1;
	}

	public View getAddView(){
		
		return findViewById(R.id.add);
	}
	@Override
	public void onClick(View view) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		switch (view.getId()) {
		case R.id.tab1:
			if(mCurTab == 1)break;
	        ft.replace(R.id.container, mOneDotFragment);
	        ft.commit();
	        mTitleText.setText("一点");
	        mCurTab = 1;
			break;
		case R.id.tab2:
			if(mCurTab == 2)break;
	        ft.replace(R.id.container, mOneKeFragment);
	        ft.commit();
	        mTitleText.setText("一刻");
	        mCurTab = 2;
			break;
		case R.id.tab3:
			if(mCurTab == 3)break;
	        ft.replace(R.id.container, mChatFragment);
	        ft.commit();
	        mTitleText.setText("聊天");
	        mCurTab = 3;
			break;
		case R.id.tab4:
			if(mCurTab == 4)break;
	        ft.replace(R.id.container, mCircleFragment);
	        ft.commit();
	        mTitleText.setText("圈子");
	        mCurTab = 4;
			break;
		default:
			break;
		}
	}

}
