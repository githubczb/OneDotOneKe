package com.onedot.onedotoneke.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;

/*
 * @author:莫胜磊
 * @time:2015/7.31
 * @function:聊天内容 页面
 * @class:ChatWithOneActivity
 */
public class ChatContentActivity extends BaseActivity implements View.OnClickListener{

	private View mBack;
	private TextView mTitle;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_chat_content);
		initViews();
	}

	private void initViews() {
		mBack = findViewById(R.id.back_frame);
		mBack.setOnClickListener(this);
		mBack.setVisibility(View.VISIBLE);
		
		mTitle = (TextView)findViewById(R.id.title_text);
		mTitle.setText("莫胜磊");
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.back_frame:
			finish();
			break;

		default:
			break;
		}
	}
}
