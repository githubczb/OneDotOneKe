package com.onedot.onedotoneke.activity;

import android.os.Bundle;
import android.view.View;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;

/*
 * @author:莫胜磊
 * @time:2015.7.31
 * @class:CircleContentActivity
 * @function:圈子 内容 页面
 */
public class CircleContentActivity extends BaseActivity implements View.OnClickListener{

	private View mBackFrame;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_circle_content);
		
		mBackFrame = findViewById(R.id.back_frame);
		mBackFrame.setVisibility(View.VISIBLE);
		mBackFrame.setOnClickListener(this);
		
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
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
