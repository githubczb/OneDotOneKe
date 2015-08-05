package com.onedot.onedotoneke.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;


public class OneDotDetailActivity extends BaseActivity implements View.OnClickListener {
	private View mBackFrame;
	private TextView content;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.onedot_detail);
		
		mBackFrame = findViewById(R.id.back_frame);
		mBackFrame.setVisibility(View.VISIBLE);
		mBackFrame.setOnClickListener(this);
		
		content = (TextView) findViewById(R.id.item_detail);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.back_frame:
			finish();
			break;
		default:
			break;	
		}
	}
}
