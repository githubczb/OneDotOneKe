package com.onedot.onedotoneke.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;

/*
 * @author:莫胜磊
 * @time:2015.8.3
 * @class:WelcomeActivity
 * @function:欢迎 页面
 */
public class WelcomeActivity extends BaseActivity implements View.OnClickListener{

	private Button mGoRegister;
	private Button mGoLogin;
	private View mGoMain;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_welcome);
		
		mGoLogin = (Button)findViewById(R.id.wel_go_login);
		mGoRegister = (Button)findViewById(R.id.wel_go_register);
		mGoMain =  findViewById(R.id.wel_go_main);
		
		mGoLogin.setOnClickListener(this);
		mGoMain.setOnClickListener(this);
		mGoRegister.setOnClickListener(this);
	}


	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		
		case R.id.wel_go_login:
			startActivity(new Intent(this,LoginActivity.class));
			finish();
			break;
		case R.id.wel_go_main:
			startActivity(new Intent(this,MainActivity.class));
			finish();
			break;
		case R.id.wel_go_register:
			startActivity(new Intent(this,RegisterActivity.class));
			finish();
			break;
		default:
			break;
		}
	}
}
