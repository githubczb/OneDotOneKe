package com.onedot.onedotoneke.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

import com.onedot.onedotoneke.EMChatHandler;
import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;

/*
 * @author:ÄªÊ¤ÀÚ
 * @class:LoginActivity
 * @time:2015.7.31
 * @function:µÇÂ¼½çÃæ
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{

	private Button mLoginBtn;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_login);
		
		mLoginBtn = (Button)findViewById(R.id.login_btn);
		mLoginBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.login_btn:
			EMChatHandler.getInstance().login("moshenglei", "12345");
			startActivity(new Intent(this,MainActivity.class));
			finish();
			break;

		default:
			break;
		}
	}
}
